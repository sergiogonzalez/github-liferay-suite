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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link GHAutomatorTask}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GHAutomatorTask
 * @generated
 */
@ProviderType
public class GHAutomatorTaskWrapper implements GHAutomatorTask,
	ModelWrapper<GHAutomatorTask> {
	public GHAutomatorTaskWrapper(GHAutomatorTask ghAutomatorTask) {
		_ghAutomatorTask = ghAutomatorTask;
	}

	@Override
	public Class<?> getModelClass() {
		return GHAutomatorTask.class;
	}

	@Override
	public String getModelClassName() {
		return GHAutomatorTask.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("ghAutomatorTaskId", getGhAutomatorTaskId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("ghRepositoryId", getGhRepositoryId());
		attributes.put("ghTaskUuid", getGhTaskUuid());
		attributes.put("enabled", getEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long ghAutomatorTaskId = (Long)attributes.get("ghAutomatorTaskId");

		if (ghAutomatorTaskId != null) {
			setGhAutomatorTaskId(ghAutomatorTaskId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String ghRepositoryId = (String)attributes.get("ghRepositoryId");

		if (ghRepositoryId != null) {
			setGhRepositoryId(ghRepositoryId);
		}

		String ghTaskUuid = (String)attributes.get("ghTaskUuid");

		if (ghTaskUuid != null) {
			setGhTaskUuid(ghTaskUuid);
		}

		Boolean enabled = (Boolean)attributes.get("enabled");

		if (enabled != null) {
			setEnabled(enabled);
		}
	}

	@Override
	public GHAutomatorTask toEscapedModel() {
		return new GHAutomatorTaskWrapper(_ghAutomatorTask.toEscapedModel());
	}

	@Override
	public GHAutomatorTask toUnescapedModel() {
		return new GHAutomatorTaskWrapper(_ghAutomatorTask.toUnescapedModel());
	}

	/**
	* Returns the enabled of this g h automator task.
	*
	* @return the enabled of this g h automator task
	*/
	@Override
	public boolean getEnabled() {
		return _ghAutomatorTask.getEnabled();
	}

	@Override
	public boolean isCachedModel() {
		return _ghAutomatorTask.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this g h automator task is enabled.
	*
	* @return <code>true</code> if this g h automator task is enabled; <code>false</code> otherwise
	*/
	@Override
	public boolean isEnabled() {
		return _ghAutomatorTask.isEnabled();
	}

	@Override
	public boolean isEscapedModel() {
		return _ghAutomatorTask.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _ghAutomatorTask.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _ghAutomatorTask.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<GHAutomatorTask> toCacheModel() {
		return _ghAutomatorTask.toCacheModel();
	}

	@Override
	public int compareTo(GHAutomatorTask ghAutomatorTask) {
		return _ghAutomatorTask.compareTo(ghAutomatorTask);
	}

	@Override
	public int hashCode() {
		return _ghAutomatorTask.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ghAutomatorTask.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new GHAutomatorTaskWrapper((GHAutomatorTask)_ghAutomatorTask.clone());
	}

	/**
	* Returns the gh repository ID of this g h automator task.
	*
	* @return the gh repository ID of this g h automator task
	*/
	@Override
	public java.lang.String getGhRepositoryId() {
		return _ghAutomatorTask.getGhRepositoryId();
	}

	/**
	* Returns the gh task uuid of this g h automator task.
	*
	* @return the gh task uuid of this g h automator task
	*/
	@Override
	public java.lang.String getGhTaskUuid() {
		return _ghAutomatorTask.getGhTaskUuid();
	}

	/**
	* Returns the user uuid of this g h automator task.
	*
	* @return the user uuid of this g h automator task
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _ghAutomatorTask.getUserUuid();
	}

	/**
	* Returns the uuid of this g h automator task.
	*
	* @return the uuid of this g h automator task
	*/
	@Override
	public java.lang.String getUuid() {
		return _ghAutomatorTask.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _ghAutomatorTask.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _ghAutomatorTask.toXmlString();
	}

	/**
	* Returns the create date of this g h automator task.
	*
	* @return the create date of this g h automator task
	*/
	@Override
	public Date getCreateDate() {
		return _ghAutomatorTask.getCreateDate();
	}

	/**
	* Returns the modified date of this g h automator task.
	*
	* @return the modified date of this g h automator task
	*/
	@Override
	public Date getModifiedDate() {
		return _ghAutomatorTask.getModifiedDate();
	}

	/**
	* Returns the gh automator task ID of this g h automator task.
	*
	* @return the gh automator task ID of this g h automator task
	*/
	@Override
	public long getGhAutomatorTaskId() {
		return _ghAutomatorTask.getGhAutomatorTaskId();
	}

	/**
	* Returns the primary key of this g h automator task.
	*
	* @return the primary key of this g h automator task
	*/
	@Override
	public long getPrimaryKey() {
		return _ghAutomatorTask.getPrimaryKey();
	}

	/**
	* Returns the user ID of this g h automator task.
	*
	* @return the user ID of this g h automator task
	*/
	@Override
	public long getUserId() {
		return _ghAutomatorTask.getUserId();
	}

	@Override
	public void persist() {
		_ghAutomatorTask.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_ghAutomatorTask.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this g h automator task.
	*
	* @param createDate the create date of this g h automator task
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_ghAutomatorTask.setCreateDate(createDate);
	}

	/**
	* Sets whether this g h automator task is enabled.
	*
	* @param enabled the enabled of this g h automator task
	*/
	@Override
	public void setEnabled(boolean enabled) {
		_ghAutomatorTask.setEnabled(enabled);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_ghAutomatorTask.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_ghAutomatorTask.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_ghAutomatorTask.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the gh automator task ID of this g h automator task.
	*
	* @param ghAutomatorTaskId the gh automator task ID of this g h automator task
	*/
	@Override
	public void setGhAutomatorTaskId(long ghAutomatorTaskId) {
		_ghAutomatorTask.setGhAutomatorTaskId(ghAutomatorTaskId);
	}

	/**
	* Sets the gh repository ID of this g h automator task.
	*
	* @param ghRepositoryId the gh repository ID of this g h automator task
	*/
	@Override
	public void setGhRepositoryId(java.lang.String ghRepositoryId) {
		_ghAutomatorTask.setGhRepositoryId(ghRepositoryId);
	}

	/**
	* Sets the gh task uuid of this g h automator task.
	*
	* @param ghTaskUuid the gh task uuid of this g h automator task
	*/
	@Override
	public void setGhTaskUuid(java.lang.String ghTaskUuid) {
		_ghAutomatorTask.setGhTaskUuid(ghTaskUuid);
	}

	/**
	* Sets the modified date of this g h automator task.
	*
	* @param modifiedDate the modified date of this g h automator task
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_ghAutomatorTask.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_ghAutomatorTask.setNew(n);
	}

	/**
	* Sets the primary key of this g h automator task.
	*
	* @param primaryKey the primary key of this g h automator task
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_ghAutomatorTask.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_ghAutomatorTask.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this g h automator task.
	*
	* @param userId the user ID of this g h automator task
	*/
	@Override
	public void setUserId(long userId) {
		_ghAutomatorTask.setUserId(userId);
	}

	/**
	* Sets the user uuid of this g h automator task.
	*
	* @param userUuid the user uuid of this g h automator task
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_ghAutomatorTask.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this g h automator task.
	*
	* @param uuid the uuid of this g h automator task
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_ghAutomatorTask.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GHAutomatorTaskWrapper)) {
			return false;
		}

		GHAutomatorTaskWrapper ghAutomatorTaskWrapper = (GHAutomatorTaskWrapper)obj;

		if (Objects.equals(_ghAutomatorTask,
					ghAutomatorTaskWrapper._ghAutomatorTask)) {
			return true;
		}

		return false;
	}

	@Override
	public GHAutomatorTask getWrappedModel() {
		return _ghAutomatorTask;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _ghAutomatorTask.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _ghAutomatorTask.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_ghAutomatorTask.resetOriginalValues();
	}

	private final GHAutomatorTask _ghAutomatorTask;
}