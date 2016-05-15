package com.liferay.github.automator.web.portlet.action;

import com.liferay.github.automator.service.GHAutomatorTaskLocalService;
import com.liferay.github.automator.web.constants.GitHubAutomatorPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropertiesParamUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Sergio González
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + GitHubAutomatorPortletKeys.GITHUB_AUTOMATOR,
		"mvc.command.name=/github_automator/update_repository_task_status"
	},
	service = MVCActionCommand.class
)
public class UpdateRepositoryTaskStatusMVCActionCommand
	extends BaseMVCActionCommand {

	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String repositoryId = ParamUtil.getString(
			actionRequest, "repositoryId");

		UnicodeProperties repositoryTaskStatusProperties =
			PropertiesParamUtil.getProperties(
				actionRequest, "repositoryTaskStatus--");

		Set<String> repositoryTaskStatusUuidKeySet =
			repositoryTaskStatusProperties.keySet();

		for (String repositoryTaskStatusUuid : repositoryTaskStatusUuidKeySet) {
			boolean enabled = GetterUtil.getBoolean(
				repositoryTaskStatusProperties.getProperty(
					repositoryTaskStatusUuid));

			ghAutomatorTaskLocalService.updateGHAutomatorTask(
				themeDisplay.getUserId(), repositoryId,
				repositoryTaskStatusUuid, enabled);
		}
	}

	@Reference
	protected GHAutomatorTaskLocalService ghAutomatorTaskLocalService;

}