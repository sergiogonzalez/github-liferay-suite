package com.liferay.login.authentication.github.web.internal.servlet.taglib;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.taglib.BaseDynamicInclude;
import com.liferay.portal.kernel.servlet.taglib.DynamicInclude;
import com.liferay.portal.security.sso.github.GitHubAuthorization;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * @author Sergio González
 */
@Component(immediate = true, service = DynamicInclude.class)
public class GitHubNavigationPreDynamicInclude extends BaseDynamicInclude {

	@Override
	public void include(
			HttpServletRequest request, HttpServletResponse response,
			String key)
		throws IOException {

		if (!_gitHubAuthorization.isEnabled()) {
			return;
		}

		RequestDispatcher requestDispatcher =
			_servletContext.getRequestDispatcher(_JSP_PATH);

		try {
			requestDispatcher.include(request, response);
		}
		catch (ServletException se) {
			_log.error("Unable to include JSP " + _JSP_PATH, se);

			throw new IOException("Unable to include JSP " + _JSP_PATH, se);
		}
	}

	@Override
	public void register(DynamicIncludeRegistry dynamicIncludeRegistry) {
		dynamicIncludeRegistry.register(
			"com.liferay.login.web#/navigation.jsp#pre");
	}

	private static final String _JSP_PATH =
		"/html/portlet/login/navigation/github.jsp";

	private static final Log _log = LogFactoryUtil.getLog(
		GitHubNavigationPreDynamicInclude.class);

	@Reference(policyOption = ReferencePolicyOption.GREEDY)
	private GitHubAuthorization _gitHubAuthorization;

	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.login.authentication.github.web)"
	)
	private ServletContext _servletContext;

}