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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class GHAutomatorTaskSoap implements Serializable {
	public static GHAutomatorTaskSoap toSoapModel(GHAutomatorTask model) {
		GHAutomatorTaskSoap soapModel = new GHAutomatorTaskSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setGhAutomatorTaskId(model.getGhAutomatorTaskId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setGhRepositoryId(model.getGhRepositoryId());
		soapModel.setGhTaskUuid(model.getGhTaskUuid());
		soapModel.setEnabled(model.getEnabled());

		return soapModel;
	}

	public static GHAutomatorTaskSoap[] toSoapModels(GHAutomatorTask[] models) {
		GHAutomatorTaskSoap[] soapModels = new GHAutomatorTaskSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GHAutomatorTaskSoap[][] toSoapModels(
		GHAutomatorTask[][] models) {
		GHAutomatorTaskSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GHAutomatorTaskSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GHAutomatorTaskSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GHAutomatorTaskSoap[] toSoapModels(
		List<GHAutomatorTask> models) {
		List<GHAutomatorTaskSoap> soapModels = new ArrayList<GHAutomatorTaskSoap>(models.size());

		for (GHAutomatorTask model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GHAutomatorTaskSoap[soapModels.size()]);
	}

	public GHAutomatorTaskSoap() {
	}

	public long getPrimaryKey() {
		return _ghAutomatorTaskId;
	}

	public void setPrimaryKey(long pk) {
		setGhAutomatorTaskId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getGhAutomatorTaskId() {
		return _ghAutomatorTaskId;
	}

	public void setGhAutomatorTaskId(long ghAutomatorTaskId) {
		_ghAutomatorTaskId = ghAutomatorTaskId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getGhRepositoryId() {
		return _ghRepositoryId;
	}

	public void setGhRepositoryId(long ghRepositoryId) {
		_ghRepositoryId = ghRepositoryId;
	}

	public String getGhTaskUuid() {
		return _ghTaskUuid;
	}

	public void setGhTaskUuid(String ghTaskUuid) {
		_ghTaskUuid = ghTaskUuid;
	}

	public boolean getEnabled() {
		return _enabled;
	}

	public boolean isEnabled() {
		return _enabled;
	}

	public void setEnabled(boolean enabled) {
		_enabled = enabled;
	}

	private String _uuid;
	private long _ghAutomatorTaskId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _ghRepositoryId;
	private String _ghTaskUuid;
	private boolean _enabled;
}