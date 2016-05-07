package com.liferay.portal.security.sso.github;

import com.liferay.portal.kernel.model.User;

import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * @author Sergio González
 */
public interface GitHubAuthorization {

	public User addOrUpdateUser(
			HttpSession session, long companyId, String authorizationCode)
		throws Exception;

	public String getLoginRedirect(String returnRequestUri, List<String> scopes)
		throws Exception;

	public boolean isEnabled();

}