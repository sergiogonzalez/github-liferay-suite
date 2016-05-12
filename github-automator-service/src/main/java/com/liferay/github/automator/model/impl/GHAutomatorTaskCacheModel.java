package com.liferay.github.automator.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.github.automator.model.GHAutomatorTask;

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
 * The cache model class for representing GHAutomatorTask in entity cache.
 *
 * @author Sergio González
 * @see GHAutomatorTask
 * @generated
 */
@ProviderType
public class GHAutomatorTaskCacheModel implements CacheModel<GHAutomatorTask>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GHAutomatorTaskCacheModel)) {
			return false;
		}

		GHAutomatorTaskCacheModel ghAutomatorTaskCacheModel = (GHAutomatorTaskCacheModel)obj;

		if (ghAutomatorTaskId == ghAutomatorTaskCacheModel.ghAutomatorTaskId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ghAutomatorTaskId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", ghAutomatorTaskId=");
		sb.append(ghAutomatorTaskId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", ghRepositoryId=");
		sb.append(ghRepositoryId);
		sb.append(", ghTaskUuid=");
		sb.append(ghTaskUuid);
		sb.append(", enabled=");
		sb.append(enabled);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public GHAutomatorTask toEntityModel() {
		GHAutomatorTaskImpl ghAutomatorTaskImpl = new GHAutomatorTaskImpl();

		if (uuid == null) {
			ghAutomatorTaskImpl.setUuid(StringPool.BLANK);
		}
		else {
			ghAutomatorTaskImpl.setUuid(uuid);
		}

		ghAutomatorTaskImpl.setGhAutomatorTaskId(ghAutomatorTaskId);
		ghAutomatorTaskImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			ghAutomatorTaskImpl.setCreateDate(null);
		}
		else {
			ghAutomatorTaskImpl.setCreateDate(new Date(createDate));
		}

		if (ghRepositoryId == null) {
			ghAutomatorTaskImpl.setGhRepositoryId(StringPool.BLANK);
		}
		else {
			ghAutomatorTaskImpl.setGhRepositoryId(ghRepositoryId);
		}

		if (ghTaskUuid == null) {
			ghAutomatorTaskImpl.setGhTaskUuid(StringPool.BLANK);
		}
		else {
			ghAutomatorTaskImpl.setGhTaskUuid(ghTaskUuid);
		}

		ghAutomatorTaskImpl.setEnabled(enabled);

		ghAutomatorTaskImpl.resetOriginalValues();

		return ghAutomatorTaskImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		ghAutomatorTaskId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		ghRepositoryId = objectInput.readUTF();
		ghTaskUuid = objectInput.readUTF();

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

		objectOutput.writeLong(ghAutomatorTaskId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);

		if (ghRepositoryId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ghRepositoryId);
		}

		if (ghTaskUuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ghTaskUuid);
		}

		objectOutput.writeBoolean(enabled);
	}

	public String uuid;
	public long ghAutomatorTaskId;
	public long userId;
	public long createDate;
	public String ghRepositoryId;
	public String ghTaskUuid;
	public boolean enabled;
}