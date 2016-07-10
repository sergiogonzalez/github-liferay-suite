/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.github.automator.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the GHAutomatorTask service. Represents a row in the &quot;GHAutomatorTask&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
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