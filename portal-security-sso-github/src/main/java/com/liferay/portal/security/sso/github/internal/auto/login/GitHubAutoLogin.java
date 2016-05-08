package com.liferay.portal.security.sso.github.internal.auto.login;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auto.login.AutoLogin;
import com.liferay.portal.kernel.security.auto.login.BaseAutoLogin;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.sso.github.GitHubAuthorization;
import com.liferay.portal.security.sso.github.constants.GitHubWebKeys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * @author Sergio González
 */
@Component(immediate = true, service = AutoLogin.class)
public class GitHubAutoLogin extends BaseAutoLogin {

	@Override
	protected String[] doLogin(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		long companyId = PortalUtil.getCompanyId(request);

		if (!_gitHubAuthorization.isEnabled()) {
			return null;
		}

		User user = getUser(request, companyId);

		if (user == null) {
			return null;
		}

		String[] credentials = new String[3];

		credentials[0] = String.valueOf(user.getUserId());
		credentials[1] = user.getPassword();
		credentials[2] = Boolean.TRUE.toString();

		return credentials;
	}

	protected User getUser(HttpServletRequest request, long companyId)
		throws Exception {

		HttpSession session = request.getSession();

		String emailAddress = GetterUtil.getString(
			session.getAttribute(GitHubWebKeys.GITHUB_USER_EMAIL_ADDRESS));

		if (Validator.isNotNull(emailAddress)) {
			session.removeAttribute(GitHubWebKeys.GITHUB_USER_EMAIL_ADDRESS);

			return _userLocalService.getUserByEmailAddress(
				companyId, emailAddress);
		}

		return null;
	}

	@Reference(policyOption = ReferencePolicyOption.GREEDY)
	private GitHubAuthorization _gitHubAuthorization;

	@Reference
	private UserLocalService _userLocalService;

}