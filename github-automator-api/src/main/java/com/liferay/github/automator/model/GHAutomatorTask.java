package com.liferay.github.automator.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the GHAutomatorTask service. Represents a row in the &quot;GHAutomatorTask&quot; database table, with each column mapped to a property of this class.
 *
 * @author Sergio González
 * @see GHAutomatorTaskModel
 * @see com.liferay.github.automator.model.impl.GHAutomatorTaskImpl
 * @see com.liferay.github.automator.model.impl.GHAutomatorTaskModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.github.automator.model.impl.GHAutomatorTaskImpl")
@ProviderType
public interface GHAutomatorTask extends GHAutomatorTaskModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.github.automator.model.impl.GHAutomatorTaskImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<GHAutomatorTask, Long> GH_AUTOMATOR_TASK_ID_ACCESSOR =
		new Accessor<GHAutomatorTask, Long>() {
			@Override
			public Long get(GHAutomatorTask ghAutomatorTask) {
				return ghAutomatorTask.getGhAutomatorTaskId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<GHAutomatorTask> getTypeClass() {
				return GHAutomatorTask.class;
			}
		};
}