package com.liferay.github.automator.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * @author Sergio González
 * @generated
 */
@ProviderType
public interface GHAutomatorTaskModel extends BaseModel<GHAutomatorTask> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a g h automator task model instance should use the {@link GHAutomatorTask} interface instead.
	 */

	/**
	 * Returns the primary key of this g h automator task.
	 *
	 * @return the primary key of this g h automator task
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this g h automator task.
	 *
	 * @param primaryKey the primary key of this g h automator task
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this g h automator task.
	 *
	 * @return the uuid of this g h automator task
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this g h automator task.
	 *
	 * @param uuid the uuid of this g h automator task
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the gh automator task ID of this g h automator task.
	 *
	 * @return the gh automator task ID of this g h automator task
	 */
	public long getGhAutomatorTaskId();

	/**
	 * Sets the gh automator task ID of this g h automator task.
	 *
	 * @param ghAutomatorTaskId the gh automator task ID of this g h automator task
	 */
	public void setGhAutomatorTaskId(long ghAutomatorTaskId);

	/**
	 * Returns the user ID of this g h automator task.
	 *
	 * @return the user ID of this g h automator task
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this g h automator task.
	 *
	 * @param userId the user ID of this g h automator task
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this g h automator task.
	 *
	 * @return the user uuid of this g h automator task
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this g h automator task.
	 *
	 * @param userUuid the user uuid of this g h automator task
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this g h automator task.
	 *
	 * @return the create date of this g h automator task
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this g h automator task.
	 *
	 * @param createDate the create date of this g h automator task
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this g h automator task.
	 *
	 * @return the modified date of this g h automator task
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this g h automator task.
	 *
	 * @param modifiedDate the modified date of this g h automator task
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the gh repository ID of this g h automator task.
	 *
	 * @return the gh repository ID of this g h automator task
	 */
	@AutoEscape
	public String getGhRepositoryId();

	/**
	 * Sets the gh repository ID of this g h automator task.
	 *
	 * @param ghRepositoryId the gh repository ID of this g h automator task
	 */
	public void setGhRepositoryId(String ghRepositoryId);

	/**
	 * Returns the gh task uuid of this g h automator task.
	 *
	 * @return the gh task uuid of this g h automator task
	 */
	@AutoEscape
	public String getGhTaskUuid();

	/**
	 * Sets the gh task uuid of this g h automator task.
	 *
	 * @param ghTaskUuid the gh task uuid of this g h automator task
	 */
	public void setGhTaskUuid(String ghTaskUuid);

	/**
	 * Returns the enabled of this g h automator task.
	 *
	 * @return the enabled of this g h automator task
	 */
	public boolean getEnabled();

	/**
	 * Returns <code>true</code> if this g h automator task is enabled.
	 *
	 * @return <code>true</code> if this g h automator task is enabled; <code>false</code> otherwise
	 */
	public boolean isEnabled();

	/**
	 * Sets whether this g h automator task is enabled.
	 *
	 * @param enabled the enabled of this g h automator task
	 */
	public void setEnabled(boolean enabled);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(GHAutomatorTask ghAutomatorTask);

	@Override
	public int hashCode();

	@Override
	public CacheModel<GHAutomatorTask> toCacheModel();

	@Override
	public GHAutomatorTask toEscapedModel();

	@Override
	public GHAutomatorTask toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}