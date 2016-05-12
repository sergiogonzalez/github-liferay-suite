package com.liferay.github.automator.web.portlet.action;

import com.liferay.github.automator.service.GHAutomatorRepositoryLocalService;
import com.liferay.github.automator.web.constants.GitHubAutomatorPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
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
		"mvc.command.name=/github_automator/update_repository_status"
	},
	service = MVCActionCommand.class
)
public class UpdateRepositoryStatusMVCActionCommand
	extends BaseMVCActionCommand {

	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		UnicodeProperties repositoryStatusProperties =
			PropertiesParamUtil.getProperties(
				actionRequest, "repositoryStatus--");

		Set<String> repositoryStatusPropertyKeySet =
			repositoryStatusProperties.keySet();

		for (String repositoryStatusPropertyKey :
				repositoryStatusPropertyKeySet) {

			boolean enabled = GetterUtil.getBoolean(
				repositoryStatusProperties.getProperty(
					repositoryStatusPropertyKey));

			ghAutomatorRepositoryLocalService.updateGHAutomatorRepository(
				themeDisplay.getUserId(), repositoryStatusPropertyKey, enabled);
		}
	}

	@Reference
	protected GHAutomatorRepositoryLocalService
		ghAutomatorRepositoryLocalService;

}