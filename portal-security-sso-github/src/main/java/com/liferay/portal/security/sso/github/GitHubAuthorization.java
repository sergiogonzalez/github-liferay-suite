package com.liferay.portal.security.sso.github;

import com.liferay.portal.kernel.model.User;

import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * @author Sergio González
 */
public interface GitHubAuthorization {

	public User addOrUpdateUser(
			HttpSession session, long companyId, String accessToken)
		throws Exception;

	public String getAccessToken(String code);

	public String getLoginRedirect(String returnRequestUri, List<String> scopes)
		throws Exception;

	public List<String> getScopes();

	public boolean isEnabled();

	public void saveAccessToken(String accessToken, HttpSession session);

}