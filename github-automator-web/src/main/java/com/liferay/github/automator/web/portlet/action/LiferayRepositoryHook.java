package com.liferay.github.automator.web.portlet.action;

import java.util.List;

import org.eclipse.egit.github.core.RepositoryHook;

/**
 * @author Sergio González
 */
public class LiferayRepositoryHook extends RepositoryHook {

	public List<String> getEvents() {
		return events;
	}

	public void setEvents(List<String> events) {
		this.events = events;
	}

	private List<String> events;

}