package com.liferay.github.automator.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.github.automator.model.GHAutomatorTask;
import com.liferay.github.automator.service.base.GHAutomatorTaskLocalServiceBaseImpl;

import java.util.Date;

/**
 * @author Sergio González
 */
@ProviderType
public class GHAutomatorTaskLocalServiceImpl
	extends GHAutomatorTaskLocalServiceBaseImpl {

	public boolean isGHAutomatorTaskEnabled(
		String repositoryId, String taskUuid) {

		GHAutomatorTask ghAutomatorTask =
			ghAutomatorTaskPersistence.fetchByGHRID_GHTUUID(
				repositoryId, taskUuid);

		if (ghAutomatorTask != null) {
			return ghAutomatorTask.isEnabled();
		}

		return false;
	}

	public GHAutomatorTask updateGHAutomatorTask(
		long userId, String repositoryId, String taskUuid, boolean enabled) {

		Date now = new Date();

		GHAutomatorTask ghAutomatorTask =
			ghAutomatorTaskPersistence.fetchByGHRID_GHTUUID(
				repositoryId, taskUuid);

		if (ghAutomatorTask == null) {
			long ghAutomatorTaskId = counterLocalService.increment();

			ghAutomatorTask = ghAutomatorTaskPersistence.create(
				ghAutomatorTaskId);

			ghAutomatorTask.setUserId(userId);
			ghAutomatorTask.setCreateDate(now);
			ghAutomatorTask.setGhRepositoryId(repositoryId);
			ghAutomatorTask.setGhTaskUuid(taskUuid);
		}

		ghAutomatorTask.setModifiedDate(now);
		ghAutomatorTask.setEnabled(enabled);

		return ghAutomatorTaskPersistence.update(ghAutomatorTask);
	}

}