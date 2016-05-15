package com.liferay.github.automator.web.portlet.action;

import com.liferay.github.automator.service.GHAutomatorTaskLocalService;
import com.liferay.github.automator.task.GHAutomatorTask;
import com.liferay.github.automator.task.GHAutomatorTaskRegistry;
import com.liferay.github.automator.web.constants.GitHubAutomatorPortletKeys;
import com.liferay.github.automator.web.constants.GitHubAutomatorWebKeys;
import com.liferay.github.automator.web.model.view.GitHubTaskModelView;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;

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

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String repositoryId = ParamUtil.getString(
			renderRequest, "repositoryId");

		List<GHAutomatorTask> allTasks = ghAutomatorTaskRegistry.getAllTasks();

		List<GitHubTaskModelView> gitHubTaskModelViews = new ArrayList<>();

		for (GHAutomatorTask task : allTasks) {
			boolean ghAutomatorTaskEnabled =
				ghAutomatorTaskLocalService.isGHAutomatorTaskEnabled(
					repositoryId, task.getUuid());

			GitHubTaskModelView gitHubTaskModelView = new GitHubTaskModelView(
				repositoryId, task.getUuid(),
				task.getTitle(themeDisplay.getLocale()),
				task.getDescription(themeDisplay.getLocale()),
				task.getImageURL(), ghAutomatorTaskEnabled);

			gitHubTaskModelViews.add(gitHubTaskModelView);
		}

		renderRequest.setAttribute(
			GitHubAutomatorWebKeys.GITHUB_TASK_MODEL_VIEWS,
			gitHubTaskModelViews);

		return "/view_repository.jsp";
	}

	@Reference
	protected GHAutomatorTaskLocalService ghAutomatorTaskLocalService;

	@Reference
	protected GHAutomatorTaskRegistry ghAutomatorTaskRegistry;

}