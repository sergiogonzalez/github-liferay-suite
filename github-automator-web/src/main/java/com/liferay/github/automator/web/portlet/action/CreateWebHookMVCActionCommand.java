package com.liferay.github.automator.web.portlet.action;

import com.liferay.github.automator.web.constants.GitHubAutomatorPortletKeys;
import com.liferay.github.automator.web.constants.GitHubAutomatorWebKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryHook;
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
		"mvc.command.name=/github_automator/add_hook"
	},
	service = MVCActionCommand.class
)
public class CreateWebHookMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String accessToken = getAccessToken(actionRequest);

		GitHubClient gitHubClient = new GitHubClient();

		gitHubClient.setOAuth2Token(accessToken);

		RepositoryService repositoryService = new RepositoryService(
			gitHubClient);

		String owner = ParamUtil.getString(actionRequest, "owner");
		String name = ParamUtil.getString(actionRequest, "name");

		Repository repository = repositoryService.getRepository(owner, name);

		RepositoryHook repositoryHook = getRepositoryHook();

		repositoryService.createHook(repository, repositoryHook);
	}

	protected String getAccessToken(ActionRequest actionRequest) {
		HttpServletRequest httpServletRequest =
			PortalUtil.getHttpServletRequest(actionRequest);

		HttpServletRequest originalServletRequest =
			PortalUtil.getOriginalServletRequest(httpServletRequest);

		HttpSession session = originalServletRequest.getSession();

		return GetterUtil.getString(
			session.getAttribute(GitHubAutomatorWebKeys.GITHUB_ACCESS_TOKEN));
	}

	protected RepositoryHook getRepositoryHook() {
		Map<String, String> config = new HashMap();

		config.put("url", "http://payload.url.com");
		config.put("content_type", "json");
		config.put("events", "pull_request");

		LiferayRepositoryHook repositoryHook = new LiferayRepositoryHook();

		repositoryHook.setActive(true);
		repositoryHook.setConfig(config);
		repositoryHook.setName("web");
		repositoryHook.setEvents(Arrays.asList("push", "pull_request"));

		return repositoryHook;
	}

}