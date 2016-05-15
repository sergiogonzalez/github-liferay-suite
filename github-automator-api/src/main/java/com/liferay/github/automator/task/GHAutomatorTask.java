package com.liferay.github.automator.task;

import java.io.IOException;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Sergio González
 */
public interface GHAutomatorTask {

	public void activate(String repositoryId);

	public void deactivate(String repositoryId);

	public String getDescription(Locale locale);

	public String getImageURL();

	public String getTitle(Locale locale);

	public String getUuid();

	public void include(
			HttpServletRequest request, HttpServletResponse response)
		throws IOException;

}