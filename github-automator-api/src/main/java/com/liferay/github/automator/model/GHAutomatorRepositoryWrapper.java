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
 * This class is a wrapper for {@link GHAutomatorRepository}.
 * </p>
 *
 * @author Sergio González
 * @see GHAutomatorRepository
 * @generated
 */
@ProviderType
public class GHAutomatorRepositoryWrapper implements GHAutomatorRepository,
	ModelWrapper<GHAutomatorRepository> {
	public GHAutomatorRepositoryWrapper(
		GHAutomatorRepository ghAutomatorRepository) {
		_ghAutomatorRepository = ghAutomatorRepository;
	}

	@Override
	public Class<?> getModelClass() {
		return GHAutomatorRepository.class;
	}

	@Override
	public String getModelClassName() {
		return GHAutomatorRepository.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("ghAutomatorRepositoryId", getGhAutomatorRepositoryId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("ghRepositoryId", getGhRepositoryId());
		attributes.put("enabled", getEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long ghAutomatorRepositoryId = (Long)attributes.get(
				"ghAutomatorRepositoryId");

		if (ghAutomatorRepositoryId != null) {
			setGhAutomatorRepositoryId(ghAutomatorRepositoryId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String ghRepositoryId = (String)attributes.get("ghRepositoryId");

		if (ghRepositoryId != null) {
			setGhRepositoryId(ghRepositoryId);
		}

		Boolean enabled = (Boolean)attributes.get("enabled");

		if (enabled != null) {
			setEnabled(enabled);
		}
	}

	@Override
	public GHAutomatorRepository toEscapedModel() {
		return new GHAutomatorRepositoryWrapper(_ghAutomatorRepository.toEscapedModel());
	}

	@Override
	public GHAutomatorRepository toUnescapedModel() {
		return new GHAutomatorRepositoryWrapper(_ghAutomatorRepository.toUnescapedModel());
	}

	/**
	* Returns the enabled of this g h automator repository.
	*
	* @return the enabled of this g h automator repository
	*/
	@Override
	public boolean getEnabled() {
		return _ghAutomatorRepository.getEnabled();
	}

	@Override
	public boolean isCachedModel() {
		return _ghAutomatorRepository.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this g h automator repository is enabled.
	*
	* @return <code>true</code> if this g h automator repository is enabled; <code>false</code> otherwise
	*/
	@Override
	public boolean isEnabled() {
		return _ghAutomatorRepository.isEnabled();
	}

	@Override
	public boolean isEscapedModel() {
		return _ghAutomatorRepository.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _ghAutomatorRepository.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _ghAutomatorRepository.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<GHAutomatorRepository> toCacheModel() {
		return _ghAutomatorRepository.toCacheModel();
	}

	@Override
	public int compareTo(GHAutomatorRepository ghAutomatorRepository) {
		return _ghAutomatorRepository.compareTo(ghAutomatorRepository);
	}

	@Override
	public int hashCode() {
		return _ghAutomatorRepository.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ghAutomatorRepository.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new GHAutomatorRepositoryWrapper((GHAutomatorRepository)_ghAutomatorRepository.clone());
	}

	/**
	* Returns the gh repository ID of this g h automator repository.
	*
	* @return the gh repository ID of this g h automator repository
	*/
	@Override
	public java.lang.String getGhRepositoryId() {
		return _ghAutomatorRepository.getGhRepositoryId();
	}

	/**
	* Returns the user uuid of this g h automator repository.
	*
	* @return the user uuid of this g h automator repository
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _ghAutomatorRepository.getUserUuid();
	}

	/**
	* Returns the uuid of this g h automator repository.
	*
	* @return the uuid of this g h automator repository
	*/
	@Override
	public java.lang.String getUuid() {
		return _ghAutomatorRepository.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _ghAutomatorRepository.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _ghAutomatorRepository.toXmlString();
	}

	/**
	* Returns the create date of this g h automator repository.
	*
	* @return the create date of this g h automator repository
	*/
	@Override
	public Date getCreateDate() {
		return _ghAutomatorRepository.getCreateDate();
	}

	/**
	* Returns the gh automator repository ID of this g h automator repository.
	*
	* @return the gh automator repository ID of this g h automator repository
	*/
	@Override
	public long getGhAutomatorRepositoryId() {
		return _ghAutomatorRepository.getGhAutomatorRepositoryId();
	}

	/**
	* Returns the primary key of this g h automator repository.
	*
	* @return the primary key of this g h automator repository
	*/
	@Override
	public long getPrimaryKey() {
		return _ghAutomatorRepository.getPrimaryKey();
	}

	/**
	* Returns the user ID of this g h automator repository.
	*
	* @return the user ID of this g h automator repository
	*/
	@Override
	public long getUserId() {
		return _ghAutomatorRepository.getUserId();
	}

	@Override
	public void persist() {
		_ghAutomatorRepository.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_ghAutomatorRepository.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this g h automator repository.
	*
	* @param createDate the create date of this g h automator repository
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_ghAutomatorRepository.setCreateDate(createDate);
	}

	/**
	* Sets whether this g h automator repository is enabled.
	*
	* @param enabled the enabled of this g h automator repository
	*/
	@Override
	public void setEnabled(boolean enabled) {
		_ghAutomatorRepository.setEnabled(enabled);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_ghAutomatorRepository.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_ghAutomatorRepository.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_ghAutomatorRepository.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the gh automator repository ID of this g h automator repository.
	*
	* @param ghAutomatorRepositoryId the gh automator repository ID of this g h automator repository
	*/
	@Override
	public void setGhAutomatorRepositoryId(long ghAutomatorRepositoryId) {
		_ghAutomatorRepository.setGhAutomatorRepositoryId(ghAutomatorRepositoryId);
	}

	/**
	* Sets the gh repository ID of this g h automator repository.
	*
	* @param ghRepositoryId the gh repository ID of this g h automator repository
	*/
	@Override
	public void setGhRepositoryId(java.lang.String ghRepositoryId) {
		_ghAutomatorRepository.setGhRepositoryId(ghRepositoryId);
	}

	@Override
	public void setNew(boolean n) {
		_ghAutomatorRepository.setNew(n);
	}

	/**
	* Sets the primary key of this g h automator repository.
	*
	* @param primaryKey the primary key of this g h automator repository
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_ghAutomatorRepository.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_ghAutomatorRepository.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this g h automator repository.
	*
	* @param userId the user ID of this g h automator repository
	*/
	@Override
	public void setUserId(long userId) {
		_ghAutomatorRepository.setUserId(userId);
	}

	/**
	* Sets the user uuid of this g h automator repository.
	*
	* @param userUuid the user uuid of this g h automator repository
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_ghAutomatorRepository.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this g h automator repository.
	*
	* @param uuid the uuid of this g h automator repository
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_ghAutomatorRepository.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GHAutomatorRepositoryWrapper)) {
			return false;
		}

		GHAutomatorRepositoryWrapper ghAutomatorRepositoryWrapper = (GHAutomatorRepositoryWrapper)obj;

		if (Objects.equals(_ghAutomatorRepository,
					ghAutomatorRepositoryWrapper._ghAutomatorRepository)) {
			return true;
		}

		return false;
	}

	@Override
	public GHAutomatorRepository getWrappedModel() {
		return _ghAutomatorRepository;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _ghAutomatorRepository.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _ghAutomatorRepository.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_ghAutomatorRepository.resetOriginalValues();
	}

	private final GHAutomatorRepository _ghAutomatorRepository;
}