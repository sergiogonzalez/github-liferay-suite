package com.liferay.github.automator.web.model.view;

/**
 * @author Sergio González
 */
public class GitHubRepositoryModelView {

	public GitHubRepositoryModelView(
		String repositoryId, String repositoryName,
		String repositoryDescription, String ownerLogin,
		String ownerAvatarURL) {

		_repositoryId = repositoryId;
		_repositoryName = repositoryName;
		_repositoryDescription = repositoryDescription;
		_ownerLogin = ownerLogin;
		_ownerAvatarURL = ownerAvatarURL;
	}

	public String getOwnerAvatarURL() {
		return _ownerAvatarURL;
	}

	public String getOwnerLogin() {
		return _ownerLogin;
	}

	public String getRepositoryDescription() {
		return _repositoryDescription;
	}

	public String getRepositoryId() {
		return _repositoryId;
	}

	public String getRepositoryName() {
		return _repositoryName;
	}

	private final String _ownerAvatarURL;
	private final String _ownerLogin;
	private final String _repositoryDescription;
	private final String _repositoryId;
	private final String _repositoryName;

}