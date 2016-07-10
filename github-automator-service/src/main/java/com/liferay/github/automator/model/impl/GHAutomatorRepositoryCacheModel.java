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

package com.liferay.github.automator.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.github.automator.model.GHAutomatorRepository;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GHAutomatorRepository in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see GHAutomatorRepository
 * @generated
 */
@ProviderType
public class GHAutomatorRepositoryCacheModel implements CacheModel<GHAutomatorRepository>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GHAutomatorRepositoryCacheModel)) {
			return false;
		}

		GHAutomatorRepositoryCacheModel ghAutomatorRepositoryCacheModel = (GHAutomatorRepositoryCacheModel)obj;

		if (ghAutomatorRepositoryId == ghAutomatorRepositoryCacheModel.ghAutomatorRepositoryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ghAutomatorRepositoryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", ghAutomatorRepositoryId=");
		sb.append(ghAutomatorRepositoryId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", ghRepositoryId=");
		sb.append(ghRepositoryId);
		sb.append(", enabled=");
		sb.append(enabled);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public GHAutomatorRepository toEntityModel() {
		GHAutomatorRepositoryImpl ghAutomatorRepositoryImpl = new GHAutomatorRepositoryImpl();

		if (uuid == null) {
			ghAutomatorRepositoryImpl.setUuid(StringPool.BLANK);
		}
		else {
			ghAutomatorRepositoryImpl.setUuid(uuid);
		}

		ghAutomatorRepositoryImpl.setGhAutomatorRepositoryId(ghAutomatorRepositoryId);
		ghAutomatorRepositoryImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			ghAutomatorRepositoryImpl.setCreateDate(null);
		}
		else {
			ghAutomatorRepositoryImpl.setCreateDate(new Date(createDate));
		}

		if (ghRepositoryId == null) {
			ghAutomatorRepositoryImpl.setGhRepositoryId(StringPool.BLANK);
		}
		else {
			ghAutomatorRepositoryImpl.setGhRepositoryId(ghRepositoryId);
		}

		ghAutomatorRepositoryImpl.setEnabled(enabled);

		ghAutomatorRepositoryImpl.resetOriginalValues();

		return ghAutomatorRepositoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		ghAutomatorRepositoryId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		ghRepositoryId = objectInput.readUTF();

		enabled = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(ghAutomatorRepositoryId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);

		if (ghRepositoryId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ghRepositoryId);
		}

		objectOutput.writeBoolean(enabled);
	}

	public String uuid;
	public long ghAutomatorRepositoryId;
	public long userId;
	public long createDate;
	public String ghRepositoryId;
	public boolean enabled;
}