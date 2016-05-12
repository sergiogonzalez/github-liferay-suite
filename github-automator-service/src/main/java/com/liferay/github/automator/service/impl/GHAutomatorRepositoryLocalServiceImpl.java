package com.liferay.github.automator.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.github.automator.model.GHAutomatorRepository;
import com.liferay.github.automator.service.base.GHAutomatorRepositoryLocalServiceBaseImpl;

import java.util.Date;

/**
 * @author Sergio González
 */
@ProviderType
public class GHAutomatorRepositoryLocalServiceImpl
	extends GHAutomatorRepositoryLocalServiceBaseImpl {

	public boolean isGHAutomatorRepositoryEnabled(String repositoryId) {
		GHAutomatorRepository ghAutomatorRepository =
			ghAutomatorRepositoryPersistence.fetchByGHRepositoryId(
				repositoryId);

		if (ghAutomatorRepository != null) {
			return ghAutomatorRepository.isEnabled();
		}

		return false;
	}

	public GHAutomatorRepository updateGHAutomatorRepository(
		long userId, String repositoryId, boolean enabled) {

		Date now = new Date();

		GHAutomatorRepository ghAutomatorRespository =
			ghAutomatorRepositoryPersistence.fetchByGHRepositoryId(
				repositoryId);

		if (ghAutomatorRespository == null) {
			long ghAutomatorRepositoryId = counterLocalService.increment();

			ghAutomatorRespository = ghAutomatorRepositoryPersistence.create(
				ghAutomatorRepositoryId);

			ghAutomatorRespository.setUserId(userId);
			ghAutomatorRespository.setGhRepositoryId(repositoryId);
		}

		ghAutomatorRespository.setEnabled(enabled);

		return ghAutomatorRepositoryPersistence.update(ghAutomatorRespository);
	}

}