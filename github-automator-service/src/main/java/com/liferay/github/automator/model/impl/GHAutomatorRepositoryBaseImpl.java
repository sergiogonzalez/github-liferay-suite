package com.liferay.github.automator.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.github.automator.model.GHAutomatorRepository;
import com.liferay.github.automator.service.GHAutomatorRepositoryLocalServiceUtil;

/**
 * The extended model base implementation for the GHAutomatorRepository service. Represents a row in the &quot;GHAutomatorRepository&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link GHAutomatorRepositoryImpl}.
 * </p>
 *
 * @author Sergio González
 * @see GHAutomatorRepositoryImpl
 * @see GHAutomatorRepository
 * @generated
 */
@ProviderType
public abstract class GHAutomatorRepositoryBaseImpl
	extends GHAutomatorRepositoryModelImpl implements GHAutomatorRepository {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a g h automator repository model instance should use the {@link GHAutomatorRepository} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			GHAutomatorRepositoryLocalServiceUtil.addGHAutomatorRepository(this);
		}
		else {
			GHAutomatorRepositoryLocalServiceUtil.updateGHAutomatorRepository(this);
		}
	}
}