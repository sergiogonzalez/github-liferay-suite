package com.liferay.login.authentication.github.web.internal.portlet.action;

import com.liferay.login.authentication.github.web.internal.constants.GitHubLoginConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.struts.StrutsAction;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PortletKeys;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.sso.github.GitHubAuthorization;

import java.util.List;

import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * @author Sergio González
 */
@Component(
	immediate = true,
	property = {"path=" + GitHubLoginConstants.GITHUB_LOGIN_URL},
	service = StrutsAction.class
)
public class GitHubLoginAction extends BaseStrutsAction {

	@Override
	public String execute(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		if (!_gitHubAuthorization.isEnabled()) {
			throw new PrincipalException.MustBeEnabled(
				themeDisplay.getCompanyId(),
				GitHubAuthorization.class.getName());
		}

		String cmd = ParamUtil.getString(request, Constants.CMD);

		if (cmd.equals(GitHubLoginConstants.CMD_LOGIN)) {
			String returnRequestUri = getReturnRequestUri(request);

			List<String> scopes = _gitHubAuthorization.getScopes();

			String loginRedirect = _gitHubAuthorization.getLoginRedirect(
				returnRequestUri, scopes);

			response.sendRedirect(loginRedirect);
		}
		else if (cmd.equals(GitHubLoginConstants.CMD_TOKEN)) {
			HttpSession session = request.getSession();

			String authorizationCode = ParamUtil.getString(request, "code");

			if (Validator.isNotNull(authorizationCode)) {
				String accessToken = _gitHubAuthorization.getAccessToken(
					authorizationCode);

				_gitHubAuthorization.saveAccessToken(accessToken, session);

				User user = _gitHubAuthorization.addOrUpdateUser(
					session, themeDisplay.getCompanyId(), accessToken);

				if ((user != null) &&
					(user.getStatus() == WorkflowConstants.STATUS_INCOMPLETE)) {

					sendUpdateAccountRedirect(request, response, user);

					return null;
				}

				sendLoginRedirect(request, response);

				return null;
			}

			String error = ParamUtil.getString(request, "error");

			if (error.equals("access_denied")) {
				sendLoginRedirect(request, response);

				return null;
			}
		}

		return null;
	}

	protected String getReturnRequestUri(HttpServletRequest request) {
		return PortalUtil.getPortalURL(request) + PortalUtil.getPathMain() +
			_REDIRECT_URI;
	}

	protected void sendLoginRedirect(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		PortletURL portletURL = PortletURLFactoryUtil.create(
			request, PortletKeys.LOGIN, themeDisplay.getPlid(),
			PortletRequest.RENDER_PHASE);

		portletURL.setParameter(
			"mvcRenderCommandName", "/login/login_redirect");
		portletURL.setWindowState(LiferayWindowState.POP_UP);

		response.sendRedirect(portletURL.toString());
	}

	protected void sendUpdateAccountRedirect(
			HttpServletRequest request, HttpServletResponse response, User user)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		PortletURL portletURL = PortletURLFactoryUtil.create(
			request, PortletKeys.LOGIN, themeDisplay.getPlid(),
			PortletRequest.RENDER_PHASE);

		portletURL.setParameter("saveLastPath", Boolean.FALSE.toString());
		portletURL.setParameter(
			"mvcRenderCommandName", "/login/associate_github_user");

		PortletURL redirectURL = PortletURLFactoryUtil.create(
			request, PortletKeys.LOGIN, themeDisplay.getPlid(),
			PortletRequest.RENDER_PHASE);

		redirectURL.setParameter(
			"mvcRenderCommandName", "/login/login_redirect");
		redirectURL.setParameter("emailAddress", user.getEmailAddress());
		redirectURL.setParameter("anonymousUser", Boolean.FALSE.toString());
		redirectURL.setPortletMode(PortletMode.VIEW);
		redirectURL.setWindowState(LiferayWindowState.POP_UP);

		portletURL.setParameter("redirect", redirectURL.toString());

		portletURL.setParameter("userId", String.valueOf(user.getUserId()));
		portletURL.setParameter("emailAddress", user.getEmailAddress());
		portletURL.setParameter("firstName", user.getFirstName());
		portletURL.setParameter("lastName", user.getLastName());
		portletURL.setPortletMode(PortletMode.VIEW);
		portletURL.setWindowState(LiferayWindowState.POP_UP);

		response.sendRedirect(portletURL.toString());
	}

	private static final String _REDIRECT_URI =
		GitHubLoginConstants.GITHUB_LOGIN_URL + "?cmd=" +
			GitHubLoginConstants.CMD_TOKEN;

	@Reference(policyOption = ReferencePolicyOption.GREEDY)
	private GitHubAuthorization _gitHubAuthorization;

}