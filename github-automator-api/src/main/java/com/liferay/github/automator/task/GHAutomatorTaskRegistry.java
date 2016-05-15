package com.liferay.github.automator.task;

import java.util.List;

/**
 * @author Sergio González
 */
public interface GHAutomatorTaskRegistry {

	public List<GHAutomatorTask> getActiveTasks(String repositoryId);

	public List<GHAutomatorTask> getAllTasks();

}