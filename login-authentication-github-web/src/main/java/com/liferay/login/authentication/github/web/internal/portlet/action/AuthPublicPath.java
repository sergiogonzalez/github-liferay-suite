package com.liferay.login.authentication.github.web.internal.portlet.action;

import org.osgi.service.component.annotations.Component;

/**
 * @author Sergio González
 */
@Component(
	immediate = true, property = {"auth.public.path=/portal/github_login"},
	service = Object.class
)
public class AuthPublicPath {
}