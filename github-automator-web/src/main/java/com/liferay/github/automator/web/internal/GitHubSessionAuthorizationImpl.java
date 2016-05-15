package com.liferay.github.automator.web.internal;

import com.liferay.github.automator.web.constants.GitHubAutomatorWebKeys;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.security.sso.github.GitHubAuthorization;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Sergio González
 */
@Component(
	configurationPid = "com.liferay.portal.security.sso.github.configuration.GitHubAuthorizationConfiguration",
	immediate = true,
	property = {
		"github.session.authorization=automator", "service.ranking:Integer=100"
	},
	service = GitHubAuthorization.class
)
public class GitHubSessionAuthorizationImpl implements GitHubAuthorization {

	public User addOrUpdateUser(
			HttpSession session, long companyId, String authorizationCode)
		throws Exception {

		return gitHubAuthorization.addOrUpdateUser(
			session, companyId, authorizationCode);
	}

	public String getAccessToken(String code, String state) {
		return gitHubAuthorization.getAccessToken(code, state);
	}

	public String getLoginRedirect(String returnRequestUri, List<String> scopes)
		throws Exception {

		return gitHubAuthorization.getLoginRedirect(returnRequestUri, scopes);
	}

	public List<String> getScopes() {
		List<String> scopes = new ArrayList<>(gitHubAuthorization.getScopes());

		scopes.add("write:repo_hook,repo");

		return scopes;
	}

	public boolean isEnabled() {
		return gitHubAuthorization.isEnabled();
	}

	public void saveAccessToken(String accessToken, HttpSession session) {
		session.setAttribute(
			GitHubAutomatorWebKeys.GITHUB_ACCESS_TOKEN, accessToken);
	}

	@Reference(target = "(!(github.session.authorization=automator))")
	protected GitHubAuthorization gitHubAuthorization;

}