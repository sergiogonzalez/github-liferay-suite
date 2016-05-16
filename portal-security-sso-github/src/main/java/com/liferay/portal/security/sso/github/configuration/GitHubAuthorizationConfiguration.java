package com.liferay.portal.security.sso.github.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Sergio González
 */
@ExtendedObjectClassDefinition(category = "foundation")
@Meta.OCD(
	id = "com.liferay.portal.security.sso.github.configuration.GitHubAuthorizationConfiguration",
	localization = "content/Language",
	name = "github.authorization.configuration.name"
)
public interface GitHubAuthorizationConfiguration {

	@Meta.AD(deflt = "true", description = "enabled-help", required = false)
	public boolean enabled();

	@Meta.AD(deflt = "", description = "client-id-help", required = false)
	public String clientId();

	@Meta.AD(deflt = "", description = "client-secret-help", required = false)
	public String clientSecret();

	@Meta.AD(
		deflt = "1", description = "clean-expired-authentication-ticket-help",
		required = false
	)
	public int cleanExpiredAuthenticationTicketHourPeriod();

}