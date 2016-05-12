package com.liferay.github.automator.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.github.automator.model.GHAutomatorTask;
import com.liferay.github.automator.model.GHAutomatorTaskModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the GHAutomatorTask service. Represents a row in the &quot;GHAutomatorTask&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link GHAutomatorTaskModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link GHAutomatorTaskImpl}.
 * </p>
 *
 * @author Sergio González
 * @see GHAutomatorTaskImpl
 * @see GHAutomatorTask
 * @see GHAutomatorTaskModel
 * @generated
 */
@ProviderType
public class GHAutomatorTaskModelImpl extends BaseModelImpl<GHAutomatorTask>
	implements GHAutomatorTaskModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a g h automator task model instance should use the {@link GHAutomatorTask} interface instead.
	 */
	public static final String TABLE_NAME = "GHAutomatorTask";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "ghAutomatorTaskId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "ghRepositoryId", Types.VARCHAR },
			{ "ghTaskUuid", Types.VARCHAR },
			{ "enabled", Types.BOOLEAN }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ghAutomatorTaskId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("ghRepositoryId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ghTaskUuid", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("enabled", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE = "create table GHAutomatorTask (uuid_ VARCHAR(75) null,ghAutomatorTaskId LONG not null primary key,userId LONG,createDate DATE null,ghRepositoryId VARCHAR(75) null,ghTaskUuid VARCHAR(75) null,enabled BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table GHAutomatorTask";
	public static final String ORDER_BY_JPQL = " ORDER BY ghAutomatorTask.ghAutomatorTaskId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY GHAutomatorTask.ghAutomatorTaskId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.github.automator.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.github.automator.model.GHAutomatorTask"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.github.automator.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.github.automator.model.GHAutomatorTask"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.github.automator.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.github.automator.model.GHAutomatorTask"),
			true);
	public static final long ENABLED_COLUMN_BITMASK = 1L;
	public static final long GHREPOSITORYID_COLUMN_BITMASK = 2L;
	public static final long GHTASKUUID_COLUMN_BITMASK = 4L;
	public static final long UUID_COLUMN_BITMASK = 8L;
	public static final long GHAUTOMATORTASKID_COLUMN_BITMASK = 16L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.github.automator.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.github.automator.model.GHAutomatorTask"));

	public GHAutomatorTaskModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _ghAutomatorTaskId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGhAutomatorTaskId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ghAutomatorTaskId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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
		attributes.put("ghRepositoryId", getGhRepositoryId());
		attributes.put("ghTaskUuid", getGhTaskUuid());
		attributes.put("enabled", getEnabled());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getGhAutomatorTaskId() {
		return _ghAutomatorTaskId;
	}

	@Override
	public void setGhAutomatorTaskId(long ghAutomatorTaskId) {
		_ghAutomatorTaskId = ghAutomatorTaskId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public String getGhRepositoryId() {
		if (_ghRepositoryId == null) {
			return StringPool.BLANK;
		}
		else {
			return _ghRepositoryId;
		}
	}

	@Override
	public void setGhRepositoryId(String ghRepositoryId) {
		_columnBitmask |= GHREPOSITORYID_COLUMN_BITMASK;

		if (_originalGhRepositoryId == null) {
			_originalGhRepositoryId = _ghRepositoryId;
		}

		_ghRepositoryId = ghRepositoryId;
	}

	public String getOriginalGhRepositoryId() {
		return GetterUtil.getString(_originalGhRepositoryId);
	}

	@Override
	public String getGhTaskUuid() {
		if (_ghTaskUuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _ghTaskUuid;
		}
	}

	@Override
	public void setGhTaskUuid(String ghTaskUuid) {
		_columnBitmask |= GHTASKUUID_COLUMN_BITMASK;

		if (_originalGhTaskUuid == null) {
			_originalGhTaskUuid = _ghTaskUuid;
		}

		_ghTaskUuid = ghTaskUuid;
	}

	public String getOriginalGhTaskUuid() {
		return GetterUtil.getString(_originalGhTaskUuid);
	}

	@Override
	public boolean getEnabled() {
		return _enabled;
	}

	@Override
	public boolean isEnabled() {
		return _enabled;
	}

	@Override
	public void setEnabled(boolean enabled) {
		_columnBitmask |= ENABLED_COLUMN_BITMASK;

		if (!_setOriginalEnabled) {
			_setOriginalEnabled = true;

			_originalEnabled = _enabled;
		}

		_enabled = enabled;
	}

	public boolean getOriginalEnabled() {
		return _originalEnabled;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			GHAutomatorTask.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public GHAutomatorTask toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (GHAutomatorTask)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		GHAutomatorTaskImpl ghAutomatorTaskImpl = new GHAutomatorTaskImpl();

		ghAutomatorTaskImpl.setUuid(getUuid());
		ghAutomatorTaskImpl.setGhAutomatorTaskId(getGhAutomatorTaskId());
		ghAutomatorTaskImpl.setUserId(getUserId());
		ghAutomatorTaskImpl.setCreateDate(getCreateDate());
		ghAutomatorTaskImpl.setGhRepositoryId(getGhRepositoryId());
		ghAutomatorTaskImpl.setGhTaskUuid(getGhTaskUuid());
		ghAutomatorTaskImpl.setEnabled(getEnabled());

		ghAutomatorTaskImpl.resetOriginalValues();

		return ghAutomatorTaskImpl;
	}

	@Override
	public int compareTo(GHAutomatorTask ghAutomatorTask) {
		long primaryKey = ghAutomatorTask.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GHAutomatorTask)) {
			return false;
		}

		GHAutomatorTask ghAutomatorTask = (GHAutomatorTask)obj;

		long primaryKey = ghAutomatorTask.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		GHAutomatorTaskModelImpl ghAutomatorTaskModelImpl = this;

		ghAutomatorTaskModelImpl._originalUuid = ghAutomatorTaskModelImpl._uuid;

		ghAutomatorTaskModelImpl._originalGhRepositoryId = ghAutomatorTaskModelImpl._ghRepositoryId;

		ghAutomatorTaskModelImpl._originalGhTaskUuid = ghAutomatorTaskModelImpl._ghTaskUuid;

		ghAutomatorTaskModelImpl._originalEnabled = ghAutomatorTaskModelImpl._enabled;

		ghAutomatorTaskModelImpl._setOriginalEnabled = false;

		ghAutomatorTaskModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<GHAutomatorTask> toCacheModel() {
		GHAutomatorTaskCacheModel ghAutomatorTaskCacheModel = new GHAutomatorTaskCacheModel();

		ghAutomatorTaskCacheModel.uuid = getUuid();

		String uuid = ghAutomatorTaskCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			ghAutomatorTaskCacheModel.uuid = null;
		}

		ghAutomatorTaskCacheModel.ghAutomatorTaskId = getGhAutomatorTaskId();

		ghAutomatorTaskCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			ghAutomatorTaskCacheModel.createDate = createDate.getTime();
		}
		else {
			ghAutomatorTaskCacheModel.createDate = Long.MIN_VALUE;
		}

		ghAutomatorTaskCacheModel.ghRepositoryId = getGhRepositoryId();

		String ghRepositoryId = ghAutomatorTaskCacheModel.ghRepositoryId;

		if ((ghRepositoryId != null) && (ghRepositoryId.length() == 0)) {
			ghAutomatorTaskCacheModel.ghRepositoryId = null;
		}

		ghAutomatorTaskCacheModel.ghTaskUuid = getGhTaskUuid();

		String ghTaskUuid = ghAutomatorTaskCacheModel.ghTaskUuid;

		if ((ghTaskUuid != null) && (ghTaskUuid.length() == 0)) {
			ghAutomatorTaskCacheModel.ghTaskUuid = null;
		}

		ghAutomatorTaskCacheModel.enabled = getEnabled();

		return ghAutomatorTaskCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", ghAutomatorTaskId=");
		sb.append(getGhAutomatorTaskId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", ghRepositoryId=");
		sb.append(getGhRepositoryId());
		sb.append(", ghTaskUuid=");
		sb.append(getGhTaskUuid());
		sb.append(", enabled=");
		sb.append(getEnabled());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.liferay.github.automator.model.GHAutomatorTask");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ghAutomatorTaskId</column-name><column-value><![CDATA[");
		sb.append(getGhAutomatorTaskId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ghRepositoryId</column-name><column-value><![CDATA[");
		sb.append(getGhRepositoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ghTaskUuid</column-name><column-value><![CDATA[");
		sb.append(getGhTaskUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>enabled</column-name><column-value><![CDATA[");
		sb.append(getEnabled());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = GHAutomatorTask.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			GHAutomatorTask.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _ghAutomatorTaskId;
	private long _userId;
	private Date _createDate;
	private String _ghRepositoryId;
	private String _originalGhRepositoryId;
	private String _ghTaskUuid;
	private String _originalGhTaskUuid;
	private boolean _enabled;
	private boolean _originalEnabled;
	private boolean _setOriginalEnabled;
	private long _columnBitmask;
	private GHAutomatorTask _escapedModel;
}