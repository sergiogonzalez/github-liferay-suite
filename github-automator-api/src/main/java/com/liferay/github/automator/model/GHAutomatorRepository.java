package com.liferay.github.automator.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the GHAutomatorRepository service. Represents a row in the &quot;GHAutomatorRepository&quot; database table, with each column mapped to a property of this class.
 *
 * @author Sergio González
 * @see GHAutomatorRepositoryModel
 * @see com.liferay.github.automator.model.impl.GHAutomatorRepositoryImpl
 * @see com.liferay.github.automator.model.impl.GHAutomatorRepositoryModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.github.automator.model.impl.GHAutomatorRepositoryImpl")
@ProviderType
public interface GHAutomatorRepository extends GHAutomatorRepositoryModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.github.automator.model.impl.GHAutomatorRepositoryImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<GHAutomatorRepository, Long> GH_AUTOMATOR_REPOSITORY_ID_ACCESSOR =
		new Accessor<GHAutomatorRepository, Long>() {
			@Override
			public Long get(GHAutomatorRepository ghAutomatorRepository) {
				return ghAutomatorRepository.getGhAutomatorRepositoryId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<GHAutomatorRepository> getTypeClass() {
				return GHAutomatorRepository.class;
			}
		};
}