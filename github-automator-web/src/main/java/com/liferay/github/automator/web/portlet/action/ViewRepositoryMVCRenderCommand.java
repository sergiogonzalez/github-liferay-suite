package com.liferay.github.automator.web.portlet.action;

import com.liferay.github.automator.task.GHAutomatorTaskRegistry;
import com.liferay.github.automator.web.constants.GitHubAutomatorPortletKeys;
import com.liferay.github.automator.web.constants.GitHubAutomatorWebKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Sergio González
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + GitHubAutomatorPortletKeys.GITHUB_AUTOMATOR,
		"mvc.command.name=/github_automator/view_repository"
	},
	service = MVCRenderCommand.class
)
public class ViewRepositoryMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		String repositoryId = ParamUtil.getString(
			renderRequest, "repositoryId");

		renderRequest.setAttribute(
			GitHubAutomatorWebKeys.GITHUB_ALL_TASKS,
			ghAutomatorTaskRegistry.getAllTasks());
		renderRequest.setAttribute(
			GitHubAutomatorWebKeys.GITHUB_ACTIVE_TASKS,
			ghAutomatorTaskRegistry.getActiveTasks(repositoryId));

		return "/view_repository.jsp";
	}

	@Reference
	protected GHAutomatorTaskRegistry ghAutomatorTaskRegistry;

}