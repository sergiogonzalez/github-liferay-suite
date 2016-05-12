package com.liferay.github.automator.web.portlet.action;

import com.liferay.github.automator.web.constants.GitHubAutomatorPortletKeys;
import com.liferay.github.automator.web.constants.GitHubAutomatorWebKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.RepositoryService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Sergio González
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + GitHubAutomatorPortletKeys.GITHUB_AUTOMATOR,
		"mvc.command.name=/", "mvc.command.name=/github_automator/view"
	},
	service = MVCRenderCommand.class
)
public class ViewMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		renderRequest.setAttribute(
			GitHubAutomatorWebKeys.GITHUB_REPOSITORIES,
			getRepositories(renderRequest));

		return "/view.jsp";
	}

	protected String getAccessToken(RenderRequest renderRequest) {
		HttpServletRequest httpServletRequest =
			PortalUtil.getHttpServletRequest(renderRequest);

		HttpServletRequest originalServletRequest =
			PortalUtil.getOriginalServletRequest(httpServletRequest);

		HttpSession session = originalServletRequest.getSession();

		return GetterUtil.getString(
			session.getAttribute(GitHubAutomatorWebKeys.GITHUB_ACCESS_TOKEN));
	}

	protected List<Repository> getRepositories(RenderRequest renderRequest) {
		String accessToken = getAccessToken(renderRequest);

		if (Validator.isNull(accessToken)) {
			return Collections.emptyList();
		}

		GitHubClient gitHubClient = new GitHubClient();

		gitHubClient.setOAuth2Token(accessToken);

		RepositoryService repositoryService = new RepositoryService(
			gitHubClient);

		String navigation = ParamUtil.getString(
			renderRequest, "navigation", "owner");

		Map<String, String> filterData = new HashMap<>();

		if (navigation.equals("owner")) {
			filterData.put("affiliation", "owner");
		}
		else if (navigation.equals("collaborator")) {
			filterData.put("affiliation", "collaborator");
		}
		else if (navigation.equals("organization_member")) {
			filterData.put("affiliation", "organization_member");
		}

		try {
			return repositoryService.getRepositories(filterData);
		}
		catch (IOException ioe) {
			_log.error("Cannot obtain GitHub repositories");
		}

		return Collections.emptyList();
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ViewMVCRenderCommand.class);

}