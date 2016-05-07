package com.liferay.login.authentication.github.web.internal.portlet.action;

import com.liferay.login.authentication.github.web.internal.constants.GitHubLoginConstants;

import org.osgi.service.component.annotations.Component;

/**
 * @author Sergio González
 */
@Component(
	immediate = true,
	property = {"auth.public.path=" + GitHubLoginConstants.GITHUB_LOGIN_URL},
	service = Object.class
)
public class AuthPublicPath {
}