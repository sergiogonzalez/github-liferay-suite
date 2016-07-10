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
public class GHAutomatorRepositorySoap implements Serializable {
	public static GHAutomatorRepositorySoap toSoapModel(
		GHAutomatorRepository model) {
		GHAutomatorRepositorySoap soapModel = new GHAutomatorRepositorySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setGhAutomatorRepositoryId(model.getGhAutomatorRepositoryId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setGhRepositoryId(model.getGhRepositoryId());
		soapModel.setEnabled(model.getEnabled());

		return soapModel;
	}

	public static GHAutomatorRepositorySoap[] toSoapModels(
		GHAutomatorRepository[] models) {
		GHAutomatorRepositorySoap[] soapModels = new GHAutomatorRepositorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GHAutomatorRepositorySoap[][] toSoapModels(
		GHAutomatorRepository[][] models) {
		GHAutomatorRepositorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GHAutomatorRepositorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new GHAutomatorRepositorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GHAutomatorRepositorySoap[] toSoapModels(
		List<GHAutomatorRepository> models) {
		List<GHAutomatorRepositorySoap> soapModels = new ArrayList<GHAutomatorRepositorySoap>(models.size());

		for (GHAutomatorRepository model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GHAutomatorRepositorySoap[soapModels.size()]);
	}

	public GHAutomatorRepositorySoap() {
	}

	public long getPrimaryKey() {
		return _ghAutomatorRepositoryId;
	}

	public void setPrimaryKey(long pk) {
		setGhAutomatorRepositoryId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getGhAutomatorRepositoryId() {
		return _ghAutomatorRepositoryId;
	}

	public void setGhAutomatorRepositoryId(long ghAutomatorRepositoryId) {
		_ghAutomatorRepositoryId = ghAutomatorRepositoryId;
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

	public String getGhRepositoryId() {
		return _ghRepositoryId;
	}

	public void setGhRepositoryId(String ghRepositoryId) {
		_ghRepositoryId = ghRepositoryId;
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
	private long _ghAutomatorRepositoryId;
	private long _userId;
	private Date _createDate;
	private String _ghRepositoryId;
	private boolean _enabled;
}