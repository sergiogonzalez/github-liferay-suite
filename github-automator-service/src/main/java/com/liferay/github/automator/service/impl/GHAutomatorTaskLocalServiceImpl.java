package com.liferay.github.automator.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.github.automator.internal.constants.GHAutomatorConstants;
import com.liferay.github.automator.model.GHAutomatorTask;
import com.liferay.github.automator.service.base.GHAutomatorTaskLocalServiceBaseImpl;

import java.util.Date;

/**
 * @author Sergio González
 */
@ProviderType
public class GHAutomatorTaskLocalServiceImpl
	extends GHAutomatorTaskLocalServiceBaseImpl {

	public boolean isGHAutomatorRepositoryEnabled(String repositoryId) {
		return doIsGHAutomatorTaskEnabled(
			repositoryId, GHAutomatorConstants.ROOT_TASK_UUID);
	}

	public boolean isGHAutomatorTaskEnabled(
		String repositoryId, String taskUuid) {

		return doIsGHAutomatorTaskEnabled(repositoryId, taskUuid);
	}

	public GHAutomatorTask updateGHAutomatorRepository(
		long userId, String repositoryId, boolean enabled) {

		Date now = new Date();

		GHAutomatorTask ghAutomatorTask =
			ghAutomatorTaskPersistence.fetchByGHRID_GHTUUID(
				repositoryId, GHAutomatorConstants.ROOT_TASK_UUID);

		if (ghAutomatorTask == null) {
			ghAutomatorTask = createGHAutomatorTask(
				userId, now, repositoryId, GHAutomatorConstants.ROOT_TASK_UUID);
		}

		ghAutomatorTask.setModifiedDate(now);
		ghAutomatorTask.setEnabled(enabled);

		return ghAutomatorTaskPersistence.update(ghAutomatorTask);
	}

	public GHAutomatorTask updateGHAutomatorTask(
		long userId, String repositoryId, String taskUuid, boolean enabled) {

		Date now = new Date();

		GHAutomatorTask ghAutomatorTask =
			ghAutomatorTaskPersistence.fetchByGHRID_GHTUUID(
				repositoryId, taskUuid);

		if (ghAutomatorTask == null) {
			ghAutomatorTask = createGHAutomatorTask(
				userId, now, repositoryId, taskUuid);
		}

		ghAutomatorTask.setModifiedDate(now);
		ghAutomatorTask.setEnabled(enabled);

		return ghAutomatorTaskPersistence.update(ghAutomatorTask);
	}

	protected GHAutomatorTask createGHAutomatorTask(
		long userId, Date createDate, String repositoryId, String taskUuid) {

		long ghAutomatorTaskId = counterLocalService.increment();

		GHAutomatorTask ghAutomatorTask = ghAutomatorTaskPersistence.create(
			ghAutomatorTaskId);

		ghAutomatorTask.setUserId(userId);
		ghAutomatorTask.setCreateDate(createDate);
		ghAutomatorTask.setGhRepositoryId(repositoryId);
		ghAutomatorTask.setGhTaskUuid(taskUuid);

		return ghAutomatorTask;
	}

	protected boolean doIsGHAutomatorTaskEnabled(
		String repositoryId, String taskUuid) {

		GHAutomatorTask ghAutomatorTask =
			ghAutomatorTaskPersistence.fetchByGHRID_GHTUUID(
				repositoryId, taskUuid);

		if (ghAutomatorTask != null) {
			return ghAutomatorTask.isEnabled();
		}

		return false;
	}

}