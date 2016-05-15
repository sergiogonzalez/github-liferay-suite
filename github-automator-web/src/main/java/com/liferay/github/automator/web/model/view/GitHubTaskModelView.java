package com.liferay.github.automator.web.model.view;

/**
 * @author Sergio González
 */
public class GitHubTaskModelView {

	public GitHubTaskModelView(
		String repositoryId, String taskUuid, String taskTitle,
		String taskDescription, String taskImageURL, boolean enabled) {

		_repositoryId = repositoryId;
		_taskUuid = taskUuid;
		_taskTitle = taskTitle;
		_taskDescription = taskDescription;
		_taskImageURL = taskImageURL;
		_enabled = enabled;
	}

	public String getRepositoryId() {
		return _repositoryId;
	}

	public String getTaskDescription() {
		return _taskDescription;
	}

	public String getTaskImageURL() {
		return _taskImageURL;
	}

	public String getTaskTitle() {
		return _taskTitle;
	}

	public String getTaskUuid() {
		return _taskUuid;
	}

	public boolean isEnabled() {
		return _enabled;
	}

	private final boolean _enabled;
	private final String _repositoryId;
	private final String _taskDescription;
	private final String _taskImageURL;
	private final String _taskTitle;
	private final String _taskUuid;

}