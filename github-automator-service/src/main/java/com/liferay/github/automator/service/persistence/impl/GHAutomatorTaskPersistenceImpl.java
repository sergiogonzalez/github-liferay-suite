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

package com.liferay.github.automator.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.github.automator.exception.NoSuchGHAutomatorTaskException;
import com.liferay.github.automator.model.GHAutomatorTask;
import com.liferay.github.automator.model.impl.GHAutomatorTaskImpl;
import com.liferay.github.automator.model.impl.GHAutomatorTaskModelImpl;
import com.liferay.github.automator.service.persistence.GHAutomatorTaskPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the g h automator task service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GHAutomatorTaskPersistence
 * @see com.liferay.github.automator.service.persistence.GHAutomatorTaskUtil
 * @generated
 */
@ProviderType
public class GHAutomatorTaskPersistenceImpl extends BasePersistenceImpl<GHAutomatorTask>
	implements GHAutomatorTaskPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GHAutomatorTaskUtil} to access the g h automator task persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GHAutomatorTaskImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GHAutomatorTaskModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorTaskModelImpl.FINDER_CACHE_ENABLED,
			GHAutomatorTaskImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GHAutomatorTaskModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorTaskModelImpl.FINDER_CACHE_ENABLED,
			GHAutomatorTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GHAutomatorTaskModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(GHAutomatorTaskModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorTaskModelImpl.FINDER_CACHE_ENABLED,
			GHAutomatorTaskImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(GHAutomatorTaskModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorTaskModelImpl.FINDER_CACHE_ENABLED,
			GHAutomatorTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			GHAutomatorTaskModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(GHAutomatorTaskModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the g h automator tasks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching g h automator tasks
	 */
	@Override
	public List<GHAutomatorTask> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g h automator tasks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GHAutomatorTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of g h automator tasks
	 * @param end the upper bound of the range of g h automator tasks (not inclusive)
	 * @return the range of matching g h automator tasks
	 */
	@Override
	public List<GHAutomatorTask> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the g h automator tasks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GHAutomatorTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of g h automator tasks
	 * @param end the upper bound of the range of g h automator tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g h automator tasks
	 */
	@Override
	public List<GHAutomatorTask> findByUuid(String uuid, int start, int end,
		OrderByComparator<GHAutomatorTask> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the g h automator tasks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GHAutomatorTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of g h automator tasks
	 * @param end the upper bound of the range of g h automator tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching g h automator tasks
	 */
	@Override
	public List<GHAutomatorTask> findByUuid(String uuid, int start, int end,
		OrderByComparator<GHAutomatorTask> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<GHAutomatorTask> list = null;

		if (retrieveFromCache) {
			list = (List<GHAutomatorTask>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GHAutomatorTask ghAutomatorTask : list) {
					if (!Objects.equals(uuid, ghAutomatorTask.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_GHAUTOMATORTASK_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GHAutomatorTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<GHAutomatorTask>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<GHAutomatorTask>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first g h automator task in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g h automator task
	 * @throws NoSuchGHAutomatorTaskException if a matching g h automator task could not be found
	 */
	@Override
	public GHAutomatorTask findByUuid_First(String uuid,
		OrderByComparator<GHAutomatorTask> orderByComparator)
		throws NoSuchGHAutomatorTaskException {
		GHAutomatorTask ghAutomatorTask = fetchByUuid_First(uuid,
				orderByComparator);

		if (ghAutomatorTask != null) {
			return ghAutomatorTask;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGHAutomatorTaskException(msg.toString());
	}

	/**
	 * Returns the first g h automator task in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	 */
	@Override
	public GHAutomatorTask fetchByUuid_First(String uuid,
		OrderByComparator<GHAutomatorTask> orderByComparator) {
		List<GHAutomatorTask> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g h automator task in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g h automator task
	 * @throws NoSuchGHAutomatorTaskException if a matching g h automator task could not be found
	 */
	@Override
	public GHAutomatorTask findByUuid_Last(String uuid,
		OrderByComparator<GHAutomatorTask> orderByComparator)
		throws NoSuchGHAutomatorTaskException {
		GHAutomatorTask ghAutomatorTask = fetchByUuid_Last(uuid,
				orderByComparator);

		if (ghAutomatorTask != null) {
			return ghAutomatorTask;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGHAutomatorTaskException(msg.toString());
	}

	/**
	 * Returns the last g h automator task in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	 */
	@Override
	public GHAutomatorTask fetchByUuid_Last(String uuid,
		OrderByComparator<GHAutomatorTask> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<GHAutomatorTask> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g h automator tasks before and after the current g h automator task in the ordered set where uuid = &#63;.
	 *
	 * @param ghAutomatorTaskId the primary key of the current g h automator task
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g h automator task
	 * @throws NoSuchGHAutomatorTaskException if a g h automator task with the primary key could not be found
	 */
	@Override
	public GHAutomatorTask[] findByUuid_PrevAndNext(long ghAutomatorTaskId,
		String uuid, OrderByComparator<GHAutomatorTask> orderByComparator)
		throws NoSuchGHAutomatorTaskException {
		GHAutomatorTask ghAutomatorTask = findByPrimaryKey(ghAutomatorTaskId);

		Session session = null;

		try {
			session = openSession();

			GHAutomatorTask[] array = new GHAutomatorTaskImpl[3];

			array[0] = getByUuid_PrevAndNext(session, ghAutomatorTask, uuid,
					orderByComparator, true);

			array[1] = ghAutomatorTask;

			array[2] = getByUuid_PrevAndNext(session, ghAutomatorTask, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GHAutomatorTask getByUuid_PrevAndNext(Session session,
		GHAutomatorTask ghAutomatorTask, String uuid,
		OrderByComparator<GHAutomatorTask> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GHAUTOMATORTASK_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(GHAutomatorTaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ghAutomatorTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GHAutomatorTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g h automator tasks where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (GHAutomatorTask ghAutomatorTask : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ghAutomatorTask);
		}
	}

	/**
	 * Returns the number of g h automator tasks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching g h automator tasks
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GHAUTOMATORTASK_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "ghAutomatorTask.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "ghAutomatorTask.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(ghAutomatorTask.uuid IS NULL OR ghAutomatorTask.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GHREPOSITORYID =
		new FinderPath(GHAutomatorTaskModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorTaskModelImpl.FINDER_CACHE_ENABLED,
			GHAutomatorTaskImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGHRepositoryId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GHREPOSITORYID =
		new FinderPath(GHAutomatorTaskModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorTaskModelImpl.FINDER_CACHE_ENABLED,
			GHAutomatorTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGHRepositoryId",
			new String[] { Long.class.getName() },
			GHAutomatorTaskModelImpl.GHREPOSITORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GHREPOSITORYID = new FinderPath(GHAutomatorTaskModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGHRepositoryId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the g h automator tasks where ghRepositoryId = &#63;.
	 *
	 * @param ghRepositoryId the gh repository ID
	 * @return the matching g h automator tasks
	 */
	@Override
	public List<GHAutomatorTask> findByGHRepositoryId(long ghRepositoryId) {
		return findByGHRepositoryId(ghRepositoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g h automator tasks where ghRepositoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GHAutomatorTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ghRepositoryId the gh repository ID
	 * @param start the lower bound of the range of g h automator tasks
	 * @param end the upper bound of the range of g h automator tasks (not inclusive)
	 * @return the range of matching g h automator tasks
	 */
	@Override
	public List<GHAutomatorTask> findByGHRepositoryId(long ghRepositoryId,
		int start, int end) {
		return findByGHRepositoryId(ghRepositoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the g h automator tasks where ghRepositoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GHAutomatorTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ghRepositoryId the gh repository ID
	 * @param start the lower bound of the range of g h automator tasks
	 * @param end the upper bound of the range of g h automator tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g h automator tasks
	 */
	@Override
	public List<GHAutomatorTask> findByGHRepositoryId(long ghRepositoryId,
		int start, int end, OrderByComparator<GHAutomatorTask> orderByComparator) {
		return findByGHRepositoryId(ghRepositoryId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the g h automator tasks where ghRepositoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GHAutomatorTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ghRepositoryId the gh repository ID
	 * @param start the lower bound of the range of g h automator tasks
	 * @param end the upper bound of the range of g h automator tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching g h automator tasks
	 */
	@Override
	public List<GHAutomatorTask> findByGHRepositoryId(long ghRepositoryId,
		int start, int end,
		OrderByComparator<GHAutomatorTask> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GHREPOSITORYID;
			finderArgs = new Object[] { ghRepositoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GHREPOSITORYID;
			finderArgs = new Object[] {
					ghRepositoryId,
					
					start, end, orderByComparator
				};
		}

		List<GHAutomatorTask> list = null;

		if (retrieveFromCache) {
			list = (List<GHAutomatorTask>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GHAutomatorTask ghAutomatorTask : list) {
					if ((ghRepositoryId != ghAutomatorTask.getGhRepositoryId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_GHAUTOMATORTASK_WHERE);

			query.append(_FINDER_COLUMN_GHREPOSITORYID_GHREPOSITORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GHAutomatorTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ghRepositoryId);

				if (!pagination) {
					list = (List<GHAutomatorTask>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<GHAutomatorTask>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first g h automator task in the ordered set where ghRepositoryId = &#63;.
	 *
	 * @param ghRepositoryId the gh repository ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g h automator task
	 * @throws NoSuchGHAutomatorTaskException if a matching g h automator task could not be found
	 */
	@Override
	public GHAutomatorTask findByGHRepositoryId_First(long ghRepositoryId,
		OrderByComparator<GHAutomatorTask> orderByComparator)
		throws NoSuchGHAutomatorTaskException {
		GHAutomatorTask ghAutomatorTask = fetchByGHRepositoryId_First(ghRepositoryId,
				orderByComparator);

		if (ghAutomatorTask != null) {
			return ghAutomatorTask;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ghRepositoryId=");
		msg.append(ghRepositoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGHAutomatorTaskException(msg.toString());
	}

	/**
	 * Returns the first g h automator task in the ordered set where ghRepositoryId = &#63;.
	 *
	 * @param ghRepositoryId the gh repository ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	 */
	@Override
	public GHAutomatorTask fetchByGHRepositoryId_First(long ghRepositoryId,
		OrderByComparator<GHAutomatorTask> orderByComparator) {
		List<GHAutomatorTask> list = findByGHRepositoryId(ghRepositoryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g h automator task in the ordered set where ghRepositoryId = &#63;.
	 *
	 * @param ghRepositoryId the gh repository ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g h automator task
	 * @throws NoSuchGHAutomatorTaskException if a matching g h automator task could not be found
	 */
	@Override
	public GHAutomatorTask findByGHRepositoryId_Last(long ghRepositoryId,
		OrderByComparator<GHAutomatorTask> orderByComparator)
		throws NoSuchGHAutomatorTaskException {
		GHAutomatorTask ghAutomatorTask = fetchByGHRepositoryId_Last(ghRepositoryId,
				orderByComparator);

		if (ghAutomatorTask != null) {
			return ghAutomatorTask;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ghRepositoryId=");
		msg.append(ghRepositoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGHAutomatorTaskException(msg.toString());
	}

	/**
	 * Returns the last g h automator task in the ordered set where ghRepositoryId = &#63;.
	 *
	 * @param ghRepositoryId the gh repository ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	 */
	@Override
	public GHAutomatorTask fetchByGHRepositoryId_Last(long ghRepositoryId,
		OrderByComparator<GHAutomatorTask> orderByComparator) {
		int count = countByGHRepositoryId(ghRepositoryId);

		if (count == 0) {
			return null;
		}

		List<GHAutomatorTask> list = findByGHRepositoryId(ghRepositoryId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g h automator tasks before and after the current g h automator task in the ordered set where ghRepositoryId = &#63;.
	 *
	 * @param ghAutomatorTaskId the primary key of the current g h automator task
	 * @param ghRepositoryId the gh repository ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g h automator task
	 * @throws NoSuchGHAutomatorTaskException if a g h automator task with the primary key could not be found
	 */
	@Override
	public GHAutomatorTask[] findByGHRepositoryId_PrevAndNext(
		long ghAutomatorTaskId, long ghRepositoryId,
		OrderByComparator<GHAutomatorTask> orderByComparator)
		throws NoSuchGHAutomatorTaskException {
		GHAutomatorTask ghAutomatorTask = findByPrimaryKey(ghAutomatorTaskId);

		Session session = null;

		try {
			session = openSession();

			GHAutomatorTask[] array = new GHAutomatorTaskImpl[3];

			array[0] = getByGHRepositoryId_PrevAndNext(session,
					ghAutomatorTask, ghRepositoryId, orderByComparator, true);

			array[1] = ghAutomatorTask;

			array[2] = getByGHRepositoryId_PrevAndNext(session,
					ghAutomatorTask, ghRepositoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GHAutomatorTask getByGHRepositoryId_PrevAndNext(Session session,
		GHAutomatorTask ghAutomatorTask, long ghRepositoryId,
		OrderByComparator<GHAutomatorTask> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GHAUTOMATORTASK_WHERE);

		query.append(_FINDER_COLUMN_GHREPOSITORYID_GHREPOSITORYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(GHAutomatorTaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ghRepositoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ghAutomatorTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GHAutomatorTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g h automator tasks where ghRepositoryId = &#63; from the database.
	 *
	 * @param ghRepositoryId the gh repository ID
	 */
	@Override
	public void removeByGHRepositoryId(long ghRepositoryId) {
		for (GHAutomatorTask ghAutomatorTask : findByGHRepositoryId(
				ghRepositoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ghAutomatorTask);
		}
	}

	/**
	 * Returns the number of g h automator tasks where ghRepositoryId = &#63;.
	 *
	 * @param ghRepositoryId the gh repository ID
	 * @return the number of matching g h automator tasks
	 */
	@Override
	public int countByGHRepositoryId(long ghRepositoryId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GHREPOSITORYID;

		Object[] finderArgs = new Object[] { ghRepositoryId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GHAUTOMATORTASK_WHERE);

			query.append(_FINDER_COLUMN_GHREPOSITORYID_GHREPOSITORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ghRepositoryId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GHREPOSITORYID_GHREPOSITORYID_2 = "ghAutomatorTask.ghRepositoryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GHTASKUUID =
		new FinderPath(GHAutomatorTaskModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorTaskModelImpl.FINDER_CACHE_ENABLED,
			GHAutomatorTaskImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGHTaskUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GHTASKUUID =
		new FinderPath(GHAutomatorTaskModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorTaskModelImpl.FINDER_CACHE_ENABLED,
			GHAutomatorTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGHTaskUuid",
			new String[] { String.class.getName() },
			GHAutomatorTaskModelImpl.GHTASKUUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GHTASKUUID = new FinderPath(GHAutomatorTaskModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGHTaskUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the g h automator tasks where ghTaskUuid = &#63;.
	 *
	 * @param ghTaskUuid the gh task uuid
	 * @return the matching g h automator tasks
	 */
	@Override
	public List<GHAutomatorTask> findByGHTaskUuid(String ghTaskUuid) {
		return findByGHTaskUuid(ghTaskUuid, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g h automator tasks where ghTaskUuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GHAutomatorTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ghTaskUuid the gh task uuid
	 * @param start the lower bound of the range of g h automator tasks
	 * @param end the upper bound of the range of g h automator tasks (not inclusive)
	 * @return the range of matching g h automator tasks
	 */
	@Override
	public List<GHAutomatorTask> findByGHTaskUuid(String ghTaskUuid, int start,
		int end) {
		return findByGHTaskUuid(ghTaskUuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the g h automator tasks where ghTaskUuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GHAutomatorTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ghTaskUuid the gh task uuid
	 * @param start the lower bound of the range of g h automator tasks
	 * @param end the upper bound of the range of g h automator tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g h automator tasks
	 */
	@Override
	public List<GHAutomatorTask> findByGHTaskUuid(String ghTaskUuid, int start,
		int end, OrderByComparator<GHAutomatorTask> orderByComparator) {
		return findByGHTaskUuid(ghTaskUuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the g h automator tasks where ghTaskUuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GHAutomatorTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ghTaskUuid the gh task uuid
	 * @param start the lower bound of the range of g h automator tasks
	 * @param end the upper bound of the range of g h automator tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching g h automator tasks
	 */
	@Override
	public List<GHAutomatorTask> findByGHTaskUuid(String ghTaskUuid, int start,
		int end, OrderByComparator<GHAutomatorTask> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GHTASKUUID;
			finderArgs = new Object[] { ghTaskUuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GHTASKUUID;
			finderArgs = new Object[] { ghTaskUuid, start, end, orderByComparator };
		}

		List<GHAutomatorTask> list = null;

		if (retrieveFromCache) {
			list = (List<GHAutomatorTask>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GHAutomatorTask ghAutomatorTask : list) {
					if (!Objects.equals(ghTaskUuid,
								ghAutomatorTask.getGhTaskUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_GHAUTOMATORTASK_WHERE);

			boolean bindGhTaskUuid = false;

			if (ghTaskUuid == null) {
				query.append(_FINDER_COLUMN_GHTASKUUID_GHTASKUUID_1);
			}
			else if (ghTaskUuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GHTASKUUID_GHTASKUUID_3);
			}
			else {
				bindGhTaskUuid = true;

				query.append(_FINDER_COLUMN_GHTASKUUID_GHTASKUUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GHAutomatorTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindGhTaskUuid) {
					qPos.add(ghTaskUuid);
				}

				if (!pagination) {
					list = (List<GHAutomatorTask>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<GHAutomatorTask>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first g h automator task in the ordered set where ghTaskUuid = &#63;.
	 *
	 * @param ghTaskUuid the gh task uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g h automator task
	 * @throws NoSuchGHAutomatorTaskException if a matching g h automator task could not be found
	 */
	@Override
	public GHAutomatorTask findByGHTaskUuid_First(String ghTaskUuid,
		OrderByComparator<GHAutomatorTask> orderByComparator)
		throws NoSuchGHAutomatorTaskException {
		GHAutomatorTask ghAutomatorTask = fetchByGHTaskUuid_First(ghTaskUuid,
				orderByComparator);

		if (ghAutomatorTask != null) {
			return ghAutomatorTask;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ghTaskUuid=");
		msg.append(ghTaskUuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGHAutomatorTaskException(msg.toString());
	}

	/**
	 * Returns the first g h automator task in the ordered set where ghTaskUuid = &#63;.
	 *
	 * @param ghTaskUuid the gh task uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	 */
	@Override
	public GHAutomatorTask fetchByGHTaskUuid_First(String ghTaskUuid,
		OrderByComparator<GHAutomatorTask> orderByComparator) {
		List<GHAutomatorTask> list = findByGHTaskUuid(ghTaskUuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g h automator task in the ordered set where ghTaskUuid = &#63;.
	 *
	 * @param ghTaskUuid the gh task uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g h automator task
	 * @throws NoSuchGHAutomatorTaskException if a matching g h automator task could not be found
	 */
	@Override
	public GHAutomatorTask findByGHTaskUuid_Last(String ghTaskUuid,
		OrderByComparator<GHAutomatorTask> orderByComparator)
		throws NoSuchGHAutomatorTaskException {
		GHAutomatorTask ghAutomatorTask = fetchByGHTaskUuid_Last(ghTaskUuid,
				orderByComparator);

		if (ghAutomatorTask != null) {
			return ghAutomatorTask;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ghTaskUuid=");
		msg.append(ghTaskUuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGHAutomatorTaskException(msg.toString());
	}

	/**
	 * Returns the last g h automator task in the ordered set where ghTaskUuid = &#63;.
	 *
	 * @param ghTaskUuid the gh task uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	 */
	@Override
	public GHAutomatorTask fetchByGHTaskUuid_Last(String ghTaskUuid,
		OrderByComparator<GHAutomatorTask> orderByComparator) {
		int count = countByGHTaskUuid(ghTaskUuid);

		if (count == 0) {
			return null;
		}

		List<GHAutomatorTask> list = findByGHTaskUuid(ghTaskUuid, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g h automator tasks before and after the current g h automator task in the ordered set where ghTaskUuid = &#63;.
	 *
	 * @param ghAutomatorTaskId the primary key of the current g h automator task
	 * @param ghTaskUuid the gh task uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g h automator task
	 * @throws NoSuchGHAutomatorTaskException if a g h automator task with the primary key could not be found
	 */
	@Override
	public GHAutomatorTask[] findByGHTaskUuid_PrevAndNext(
		long ghAutomatorTaskId, String ghTaskUuid,
		OrderByComparator<GHAutomatorTask> orderByComparator)
		throws NoSuchGHAutomatorTaskException {
		GHAutomatorTask ghAutomatorTask = findByPrimaryKey(ghAutomatorTaskId);

		Session session = null;

		try {
			session = openSession();

			GHAutomatorTask[] array = new GHAutomatorTaskImpl[3];

			array[0] = getByGHTaskUuid_PrevAndNext(session, ghAutomatorTask,
					ghTaskUuid, orderByComparator, true);

			array[1] = ghAutomatorTask;

			array[2] = getByGHTaskUuid_PrevAndNext(session, ghAutomatorTask,
					ghTaskUuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GHAutomatorTask getByGHTaskUuid_PrevAndNext(Session session,
		GHAutomatorTask ghAutomatorTask, String ghTaskUuid,
		OrderByComparator<GHAutomatorTask> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GHAUTOMATORTASK_WHERE);

		boolean bindGhTaskUuid = false;

		if (ghTaskUuid == null) {
			query.append(_FINDER_COLUMN_GHTASKUUID_GHTASKUUID_1);
		}
		else if (ghTaskUuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_GHTASKUUID_GHTASKUUID_3);
		}
		else {
			bindGhTaskUuid = true;

			query.append(_FINDER_COLUMN_GHTASKUUID_GHTASKUUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(GHAutomatorTaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindGhTaskUuid) {
			qPos.add(ghTaskUuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ghAutomatorTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GHAutomatorTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g h automator tasks where ghTaskUuid = &#63; from the database.
	 *
	 * @param ghTaskUuid the gh task uuid
	 */
	@Override
	public void removeByGHTaskUuid(String ghTaskUuid) {
		for (GHAutomatorTask ghAutomatorTask : findByGHTaskUuid(ghTaskUuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ghAutomatorTask);
		}
	}

	/**
	 * Returns the number of g h automator tasks where ghTaskUuid = &#63;.
	 *
	 * @param ghTaskUuid the gh task uuid
	 * @return the number of matching g h automator tasks
	 */
	@Override
	public int countByGHTaskUuid(String ghTaskUuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GHTASKUUID;

		Object[] finderArgs = new Object[] { ghTaskUuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GHAUTOMATORTASK_WHERE);

			boolean bindGhTaskUuid = false;

			if (ghTaskUuid == null) {
				query.append(_FINDER_COLUMN_GHTASKUUID_GHTASKUUID_1);
			}
			else if (ghTaskUuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GHTASKUUID_GHTASKUUID_3);
			}
			else {
				bindGhTaskUuid = true;

				query.append(_FINDER_COLUMN_GHTASKUUID_GHTASKUUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindGhTaskUuid) {
					qPos.add(ghTaskUuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GHTASKUUID_GHTASKUUID_1 = "ghAutomatorTask.ghTaskUuid IS NULL";
	private static final String _FINDER_COLUMN_GHTASKUUID_GHTASKUUID_2 = "ghAutomatorTask.ghTaskUuid = ?";
	private static final String _FINDER_COLUMN_GHTASKUUID_GHTASKUUID_3 = "(ghAutomatorTask.ghTaskUuid IS NULL OR ghAutomatorTask.ghTaskUuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_GHRID_GHTUUID = new FinderPath(GHAutomatorTaskModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorTaskModelImpl.FINDER_CACHE_ENABLED,
			GHAutomatorTaskImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByGHRID_GHTUUID",
			new String[] { Long.class.getName(), String.class.getName() },
			GHAutomatorTaskModelImpl.GHREPOSITORYID_COLUMN_BITMASK |
			GHAutomatorTaskModelImpl.GHTASKUUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GHRID_GHTUUID = new FinderPath(GHAutomatorTaskModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGHRID_GHTUUID",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the g h automator task where ghRepositoryId = &#63; and ghTaskUuid = &#63; or throws a {@link NoSuchGHAutomatorTaskException} if it could not be found.
	 *
	 * @param ghRepositoryId the gh repository ID
	 * @param ghTaskUuid the gh task uuid
	 * @return the matching g h automator task
	 * @throws NoSuchGHAutomatorTaskException if a matching g h automator task could not be found
	 */
	@Override
	public GHAutomatorTask findByGHRID_GHTUUID(long ghRepositoryId,
		String ghTaskUuid) throws NoSuchGHAutomatorTaskException {
		GHAutomatorTask ghAutomatorTask = fetchByGHRID_GHTUUID(ghRepositoryId,
				ghTaskUuid);

		if (ghAutomatorTask == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ghRepositoryId=");
			msg.append(ghRepositoryId);

			msg.append(", ghTaskUuid=");
			msg.append(ghTaskUuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchGHAutomatorTaskException(msg.toString());
		}

		return ghAutomatorTask;
	}

	/**
	 * Returns the g h automator task where ghRepositoryId = &#63; and ghTaskUuid = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ghRepositoryId the gh repository ID
	 * @param ghTaskUuid the gh task uuid
	 * @return the matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	 */
	@Override
	public GHAutomatorTask fetchByGHRID_GHTUUID(long ghRepositoryId,
		String ghTaskUuid) {
		return fetchByGHRID_GHTUUID(ghRepositoryId, ghTaskUuid, true);
	}

	/**
	 * Returns the g h automator task where ghRepositoryId = &#63; and ghTaskUuid = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ghRepositoryId the gh repository ID
	 * @param ghTaskUuid the gh task uuid
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	 */
	@Override
	public GHAutomatorTask fetchByGHRID_GHTUUID(long ghRepositoryId,
		String ghTaskUuid, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { ghRepositoryId, ghTaskUuid };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_GHRID_GHTUUID,
					finderArgs, this);
		}

		if (result instanceof GHAutomatorTask) {
			GHAutomatorTask ghAutomatorTask = (GHAutomatorTask)result;

			if ((ghRepositoryId != ghAutomatorTask.getGhRepositoryId()) ||
					!Objects.equals(ghTaskUuid, ghAutomatorTask.getGhTaskUuid())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_GHAUTOMATORTASK_WHERE);

			query.append(_FINDER_COLUMN_GHRID_GHTUUID_GHREPOSITORYID_2);

			boolean bindGhTaskUuid = false;

			if (ghTaskUuid == null) {
				query.append(_FINDER_COLUMN_GHRID_GHTUUID_GHTASKUUID_1);
			}
			else if (ghTaskUuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GHRID_GHTUUID_GHTASKUUID_3);
			}
			else {
				bindGhTaskUuid = true;

				query.append(_FINDER_COLUMN_GHRID_GHTUUID_GHTASKUUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ghRepositoryId);

				if (bindGhTaskUuid) {
					qPos.add(ghTaskUuid);
				}

				List<GHAutomatorTask> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_GHRID_GHTUUID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"GHAutomatorTaskPersistenceImpl.fetchByGHRID_GHTUUID(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					GHAutomatorTask ghAutomatorTask = list.get(0);

					result = ghAutomatorTask;

					cacheResult(ghAutomatorTask);

					if ((ghAutomatorTask.getGhRepositoryId() != ghRepositoryId) ||
							(ghAutomatorTask.getGhTaskUuid() == null) ||
							!ghAutomatorTask.getGhTaskUuid().equals(ghTaskUuid)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_GHRID_GHTUUID,
							finderArgs, ghAutomatorTask);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_GHRID_GHTUUID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (GHAutomatorTask)result;
		}
	}

	/**
	 * Removes the g h automator task where ghRepositoryId = &#63; and ghTaskUuid = &#63; from the database.
	 *
	 * @param ghRepositoryId the gh repository ID
	 * @param ghTaskUuid the gh task uuid
	 * @return the g h automator task that was removed
	 */
	@Override
	public GHAutomatorTask removeByGHRID_GHTUUID(long ghRepositoryId,
		String ghTaskUuid) throws NoSuchGHAutomatorTaskException {
		GHAutomatorTask ghAutomatorTask = findByGHRID_GHTUUID(ghRepositoryId,
				ghTaskUuid);

		return remove(ghAutomatorTask);
	}

	/**
	 * Returns the number of g h automator tasks where ghRepositoryId = &#63; and ghTaskUuid = &#63;.
	 *
	 * @param ghRepositoryId the gh repository ID
	 * @param ghTaskUuid the gh task uuid
	 * @return the number of matching g h automator tasks
	 */
	@Override
	public int countByGHRID_GHTUUID(long ghRepositoryId, String ghTaskUuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GHRID_GHTUUID;

		Object[] finderArgs = new Object[] { ghRepositoryId, ghTaskUuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_GHAUTOMATORTASK_WHERE);

			query.append(_FINDER_COLUMN_GHRID_GHTUUID_GHREPOSITORYID_2);

			boolean bindGhTaskUuid = false;

			if (ghTaskUuid == null) {
				query.append(_FINDER_COLUMN_GHRID_GHTUUID_GHTASKUUID_1);
			}
			else if (ghTaskUuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GHRID_GHTUUID_GHTASKUUID_3);
			}
			else {
				bindGhTaskUuid = true;

				query.append(_FINDER_COLUMN_GHRID_GHTUUID_GHTASKUUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ghRepositoryId);

				if (bindGhTaskUuid) {
					qPos.add(ghTaskUuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GHRID_GHTUUID_GHREPOSITORYID_2 = "ghAutomatorTask.ghRepositoryId = ? AND ";
	private static final String _FINDER_COLUMN_GHRID_GHTUUID_GHTASKUUID_1 = "ghAutomatorTask.ghTaskUuid IS NULL";
	private static final String _FINDER_COLUMN_GHRID_GHTUUID_GHTASKUUID_2 = "ghAutomatorTask.ghTaskUuid = ?";
	private static final String _FINDER_COLUMN_GHRID_GHTUUID_GHTASKUUID_3 = "(ghAutomatorTask.ghTaskUuid IS NULL OR ghAutomatorTask.ghTaskUuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GHRID_E = new FinderPath(GHAutomatorTaskModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorTaskModelImpl.FINDER_CACHE_ENABLED,
			GHAutomatorTaskImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGHRID_E",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GHRID_E =
		new FinderPath(GHAutomatorTaskModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorTaskModelImpl.FINDER_CACHE_ENABLED,
			GHAutomatorTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGHRID_E",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			GHAutomatorTaskModelImpl.GHREPOSITORYID_COLUMN_BITMASK |
			GHAutomatorTaskModelImpl.ENABLED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GHRID_E = new FinderPath(GHAutomatorTaskModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGHRID_E",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the g h automator tasks where ghRepositoryId = &#63; and enabled = &#63;.
	 *
	 * @param ghRepositoryId the gh repository ID
	 * @param enabled the enabled
	 * @return the matching g h automator tasks
	 */
	@Override
	public List<GHAutomatorTask> findByGHRID_E(long ghRepositoryId,
		boolean enabled) {
		return findByGHRID_E(ghRepositoryId, enabled, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g h automator tasks where ghRepositoryId = &#63; and enabled = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GHAutomatorTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ghRepositoryId the gh repository ID
	 * @param enabled the enabled
	 * @param start the lower bound of the range of g h automator tasks
	 * @param end the upper bound of the range of g h automator tasks (not inclusive)
	 * @return the range of matching g h automator tasks
	 */
	@Override
	public List<GHAutomatorTask> findByGHRID_E(long ghRepositoryId,
		boolean enabled, int start, int end) {
		return findByGHRID_E(ghRepositoryId, enabled, start, end, null);
	}

	/**
	 * Returns an ordered range of all the g h automator tasks where ghRepositoryId = &#63; and enabled = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GHAutomatorTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ghRepositoryId the gh repository ID
	 * @param enabled the enabled
	 * @param start the lower bound of the range of g h automator tasks
	 * @param end the upper bound of the range of g h automator tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g h automator tasks
	 */
	@Override
	public List<GHAutomatorTask> findByGHRID_E(long ghRepositoryId,
		boolean enabled, int start, int end,
		OrderByComparator<GHAutomatorTask> orderByComparator) {
		return findByGHRID_E(ghRepositoryId, enabled, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the g h automator tasks where ghRepositoryId = &#63; and enabled = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GHAutomatorTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ghRepositoryId the gh repository ID
	 * @param enabled the enabled
	 * @param start the lower bound of the range of g h automator tasks
	 * @param end the upper bound of the range of g h automator tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching g h automator tasks
	 */
	@Override
	public List<GHAutomatorTask> findByGHRID_E(long ghRepositoryId,
		boolean enabled, int start, int end,
		OrderByComparator<GHAutomatorTask> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GHRID_E;
			finderArgs = new Object[] { ghRepositoryId, enabled };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GHRID_E;
			finderArgs = new Object[] {
					ghRepositoryId, enabled,
					
					start, end, orderByComparator
				};
		}

		List<GHAutomatorTask> list = null;

		if (retrieveFromCache) {
			list = (List<GHAutomatorTask>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GHAutomatorTask ghAutomatorTask : list) {
					if ((ghRepositoryId != ghAutomatorTask.getGhRepositoryId()) ||
							(enabled != ghAutomatorTask.getEnabled())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_GHAUTOMATORTASK_WHERE);

			query.append(_FINDER_COLUMN_GHRID_E_GHREPOSITORYID_2);

			query.append(_FINDER_COLUMN_GHRID_E_ENABLED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GHAutomatorTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ghRepositoryId);

				qPos.add(enabled);

				if (!pagination) {
					list = (List<GHAutomatorTask>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<GHAutomatorTask>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first g h automator task in the ordered set where ghRepositoryId = &#63; and enabled = &#63;.
	 *
	 * @param ghRepositoryId the gh repository ID
	 * @param enabled the enabled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g h automator task
	 * @throws NoSuchGHAutomatorTaskException if a matching g h automator task could not be found
	 */
	@Override
	public GHAutomatorTask findByGHRID_E_First(long ghRepositoryId,
		boolean enabled, OrderByComparator<GHAutomatorTask> orderByComparator)
		throws NoSuchGHAutomatorTaskException {
		GHAutomatorTask ghAutomatorTask = fetchByGHRID_E_First(ghRepositoryId,
				enabled, orderByComparator);

		if (ghAutomatorTask != null) {
			return ghAutomatorTask;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ghRepositoryId=");
		msg.append(ghRepositoryId);

		msg.append(", enabled=");
		msg.append(enabled);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGHAutomatorTaskException(msg.toString());
	}

	/**
	 * Returns the first g h automator task in the ordered set where ghRepositoryId = &#63; and enabled = &#63;.
	 *
	 * @param ghRepositoryId the gh repository ID
	 * @param enabled the enabled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	 */
	@Override
	public GHAutomatorTask fetchByGHRID_E_First(long ghRepositoryId,
		boolean enabled, OrderByComparator<GHAutomatorTask> orderByComparator) {
		List<GHAutomatorTask> list = findByGHRID_E(ghRepositoryId, enabled, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g h automator task in the ordered set where ghRepositoryId = &#63; and enabled = &#63;.
	 *
	 * @param ghRepositoryId the gh repository ID
	 * @param enabled the enabled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g h automator task
	 * @throws NoSuchGHAutomatorTaskException if a matching g h automator task could not be found
	 */
	@Override
	public GHAutomatorTask findByGHRID_E_Last(long ghRepositoryId,
		boolean enabled, OrderByComparator<GHAutomatorTask> orderByComparator)
		throws NoSuchGHAutomatorTaskException {
		GHAutomatorTask ghAutomatorTask = fetchByGHRID_E_Last(ghRepositoryId,
				enabled, orderByComparator);

		if (ghAutomatorTask != null) {
			return ghAutomatorTask;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ghRepositoryId=");
		msg.append(ghRepositoryId);

		msg.append(", enabled=");
		msg.append(enabled);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGHAutomatorTaskException(msg.toString());
	}

	/**
	 * Returns the last g h automator task in the ordered set where ghRepositoryId = &#63; and enabled = &#63;.
	 *
	 * @param ghRepositoryId the gh repository ID
	 * @param enabled the enabled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	 */
	@Override
	public GHAutomatorTask fetchByGHRID_E_Last(long ghRepositoryId,
		boolean enabled, OrderByComparator<GHAutomatorTask> orderByComparator) {
		int count = countByGHRID_E(ghRepositoryId, enabled);

		if (count == 0) {
			return null;
		}

		List<GHAutomatorTask> list = findByGHRID_E(ghRepositoryId, enabled,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g h automator tasks before and after the current g h automator task in the ordered set where ghRepositoryId = &#63; and enabled = &#63;.
	 *
	 * @param ghAutomatorTaskId the primary key of the current g h automator task
	 * @param ghRepositoryId the gh repository ID
	 * @param enabled the enabled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g h automator task
	 * @throws NoSuchGHAutomatorTaskException if a g h automator task with the primary key could not be found
	 */
	@Override
	public GHAutomatorTask[] findByGHRID_E_PrevAndNext(long ghAutomatorTaskId,
		long ghRepositoryId, boolean enabled,
		OrderByComparator<GHAutomatorTask> orderByComparator)
		throws NoSuchGHAutomatorTaskException {
		GHAutomatorTask ghAutomatorTask = findByPrimaryKey(ghAutomatorTaskId);

		Session session = null;

		try {
			session = openSession();

			GHAutomatorTask[] array = new GHAutomatorTaskImpl[3];

			array[0] = getByGHRID_E_PrevAndNext(session, ghAutomatorTask,
					ghRepositoryId, enabled, orderByComparator, true);

			array[1] = ghAutomatorTask;

			array[2] = getByGHRID_E_PrevAndNext(session, ghAutomatorTask,
					ghRepositoryId, enabled, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GHAutomatorTask getByGHRID_E_PrevAndNext(Session session,
		GHAutomatorTask ghAutomatorTask, long ghRepositoryId, boolean enabled,
		OrderByComparator<GHAutomatorTask> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_GHAUTOMATORTASK_WHERE);

		query.append(_FINDER_COLUMN_GHRID_E_GHREPOSITORYID_2);

		query.append(_FINDER_COLUMN_GHRID_E_ENABLED_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(GHAutomatorTaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ghRepositoryId);

		qPos.add(enabled);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ghAutomatorTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GHAutomatorTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g h automator tasks where ghRepositoryId = &#63; and enabled = &#63; from the database.
	 *
	 * @param ghRepositoryId the gh repository ID
	 * @param enabled the enabled
	 */
	@Override
	public void removeByGHRID_E(long ghRepositoryId, boolean enabled) {
		for (GHAutomatorTask ghAutomatorTask : findByGHRID_E(ghRepositoryId,
				enabled, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ghAutomatorTask);
		}
	}

	/**
	 * Returns the number of g h automator tasks where ghRepositoryId = &#63; and enabled = &#63;.
	 *
	 * @param ghRepositoryId the gh repository ID
	 * @param enabled the enabled
	 * @return the number of matching g h automator tasks
	 */
	@Override
	public int countByGHRID_E(long ghRepositoryId, boolean enabled) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GHRID_E;

		Object[] finderArgs = new Object[] { ghRepositoryId, enabled };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_GHAUTOMATORTASK_WHERE);

			query.append(_FINDER_COLUMN_GHRID_E_GHREPOSITORYID_2);

			query.append(_FINDER_COLUMN_GHRID_E_ENABLED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ghRepositoryId);

				qPos.add(enabled);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GHRID_E_GHREPOSITORYID_2 = "ghAutomatorTask.ghRepositoryId = ? AND ";
	private static final String _FINDER_COLUMN_GHRID_E_ENABLED_2 = "ghAutomatorTask.enabled = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GHTUUID_E =
		new FinderPath(GHAutomatorTaskModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorTaskModelImpl.FINDER_CACHE_ENABLED,
			GHAutomatorTaskImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGHTUUID_E",
			new String[] {
				String.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GHTUUID_E =
		new FinderPath(GHAutomatorTaskModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorTaskModelImpl.FINDER_CACHE_ENABLED,
			GHAutomatorTaskImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGHTUUID_E",
			new String[] { String.class.getName(), Boolean.class.getName() },
			GHAutomatorTaskModelImpl.GHTASKUUID_COLUMN_BITMASK |
			GHAutomatorTaskModelImpl.ENABLED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GHTUUID_E = new FinderPath(GHAutomatorTaskModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorTaskModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGHTUUID_E",
			new String[] { String.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the g h automator tasks where ghTaskUuid = &#63; and enabled = &#63;.
	 *
	 * @param ghTaskUuid the gh task uuid
	 * @param enabled the enabled
	 * @return the matching g h automator tasks
	 */
	@Override
	public List<GHAutomatorTask> findByGHTUUID_E(String ghTaskUuid,
		boolean enabled) {
		return findByGHTUUID_E(ghTaskUuid, enabled, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g h automator tasks where ghTaskUuid = &#63; and enabled = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GHAutomatorTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ghTaskUuid the gh task uuid
	 * @param enabled the enabled
	 * @param start the lower bound of the range of g h automator tasks
	 * @param end the upper bound of the range of g h automator tasks (not inclusive)
	 * @return the range of matching g h automator tasks
	 */
	@Override
	public List<GHAutomatorTask> findByGHTUUID_E(String ghTaskUuid,
		boolean enabled, int start, int end) {
		return findByGHTUUID_E(ghTaskUuid, enabled, start, end, null);
	}

	/**
	 * Returns an ordered range of all the g h automator tasks where ghTaskUuid = &#63; and enabled = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GHAutomatorTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ghTaskUuid the gh task uuid
	 * @param enabled the enabled
	 * @param start the lower bound of the range of g h automator tasks
	 * @param end the upper bound of the range of g h automator tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g h automator tasks
	 */
	@Override
	public List<GHAutomatorTask> findByGHTUUID_E(String ghTaskUuid,
		boolean enabled, int start, int end,
		OrderByComparator<GHAutomatorTask> orderByComparator) {
		return findByGHTUUID_E(ghTaskUuid, enabled, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the g h automator tasks where ghTaskUuid = &#63; and enabled = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GHAutomatorTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ghTaskUuid the gh task uuid
	 * @param enabled the enabled
	 * @param start the lower bound of the range of g h automator tasks
	 * @param end the upper bound of the range of g h automator tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching g h automator tasks
	 */
	@Override
	public List<GHAutomatorTask> findByGHTUUID_E(String ghTaskUuid,
		boolean enabled, int start, int end,
		OrderByComparator<GHAutomatorTask> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GHTUUID_E;
			finderArgs = new Object[] { ghTaskUuid, enabled };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GHTUUID_E;
			finderArgs = new Object[] {
					ghTaskUuid, enabled,
					
					start, end, orderByComparator
				};
		}

		List<GHAutomatorTask> list = null;

		if (retrieveFromCache) {
			list = (List<GHAutomatorTask>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GHAutomatorTask ghAutomatorTask : list) {
					if (!Objects.equals(ghTaskUuid,
								ghAutomatorTask.getGhTaskUuid()) ||
							(enabled != ghAutomatorTask.getEnabled())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_GHAUTOMATORTASK_WHERE);

			boolean bindGhTaskUuid = false;

			if (ghTaskUuid == null) {
				query.append(_FINDER_COLUMN_GHTUUID_E_GHTASKUUID_1);
			}
			else if (ghTaskUuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GHTUUID_E_GHTASKUUID_3);
			}
			else {
				bindGhTaskUuid = true;

				query.append(_FINDER_COLUMN_GHTUUID_E_GHTASKUUID_2);
			}

			query.append(_FINDER_COLUMN_GHTUUID_E_ENABLED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GHAutomatorTaskModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindGhTaskUuid) {
					qPos.add(ghTaskUuid);
				}

				qPos.add(enabled);

				if (!pagination) {
					list = (List<GHAutomatorTask>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<GHAutomatorTask>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first g h automator task in the ordered set where ghTaskUuid = &#63; and enabled = &#63;.
	 *
	 * @param ghTaskUuid the gh task uuid
	 * @param enabled the enabled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g h automator task
	 * @throws NoSuchGHAutomatorTaskException if a matching g h automator task could not be found
	 */
	@Override
	public GHAutomatorTask findByGHTUUID_E_First(String ghTaskUuid,
		boolean enabled, OrderByComparator<GHAutomatorTask> orderByComparator)
		throws NoSuchGHAutomatorTaskException {
		GHAutomatorTask ghAutomatorTask = fetchByGHTUUID_E_First(ghTaskUuid,
				enabled, orderByComparator);

		if (ghAutomatorTask != null) {
			return ghAutomatorTask;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ghTaskUuid=");
		msg.append(ghTaskUuid);

		msg.append(", enabled=");
		msg.append(enabled);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGHAutomatorTaskException(msg.toString());
	}

	/**
	 * Returns the first g h automator task in the ordered set where ghTaskUuid = &#63; and enabled = &#63;.
	 *
	 * @param ghTaskUuid the gh task uuid
	 * @param enabled the enabled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	 */
	@Override
	public GHAutomatorTask fetchByGHTUUID_E_First(String ghTaskUuid,
		boolean enabled, OrderByComparator<GHAutomatorTask> orderByComparator) {
		List<GHAutomatorTask> list = findByGHTUUID_E(ghTaskUuid, enabled, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g h automator task in the ordered set where ghTaskUuid = &#63; and enabled = &#63;.
	 *
	 * @param ghTaskUuid the gh task uuid
	 * @param enabled the enabled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g h automator task
	 * @throws NoSuchGHAutomatorTaskException if a matching g h automator task could not be found
	 */
	@Override
	public GHAutomatorTask findByGHTUUID_E_Last(String ghTaskUuid,
		boolean enabled, OrderByComparator<GHAutomatorTask> orderByComparator)
		throws NoSuchGHAutomatorTaskException {
		GHAutomatorTask ghAutomatorTask = fetchByGHTUUID_E_Last(ghTaskUuid,
				enabled, orderByComparator);

		if (ghAutomatorTask != null) {
			return ghAutomatorTask;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ghTaskUuid=");
		msg.append(ghTaskUuid);

		msg.append(", enabled=");
		msg.append(enabled);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGHAutomatorTaskException(msg.toString());
	}

	/**
	 * Returns the last g h automator task in the ordered set where ghTaskUuid = &#63; and enabled = &#63;.
	 *
	 * @param ghTaskUuid the gh task uuid
	 * @param enabled the enabled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	 */
	@Override
	public GHAutomatorTask fetchByGHTUUID_E_Last(String ghTaskUuid,
		boolean enabled, OrderByComparator<GHAutomatorTask> orderByComparator) {
		int count = countByGHTUUID_E(ghTaskUuid, enabled);

		if (count == 0) {
			return null;
		}

		List<GHAutomatorTask> list = findByGHTUUID_E(ghTaskUuid, enabled,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g h automator tasks before and after the current g h automator task in the ordered set where ghTaskUuid = &#63; and enabled = &#63;.
	 *
	 * @param ghAutomatorTaskId the primary key of the current g h automator task
	 * @param ghTaskUuid the gh task uuid
	 * @param enabled the enabled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g h automator task
	 * @throws NoSuchGHAutomatorTaskException if a g h automator task with the primary key could not be found
	 */
	@Override
	public GHAutomatorTask[] findByGHTUUID_E_PrevAndNext(
		long ghAutomatorTaskId, String ghTaskUuid, boolean enabled,
		OrderByComparator<GHAutomatorTask> orderByComparator)
		throws NoSuchGHAutomatorTaskException {
		GHAutomatorTask ghAutomatorTask = findByPrimaryKey(ghAutomatorTaskId);

		Session session = null;

		try {
			session = openSession();

			GHAutomatorTask[] array = new GHAutomatorTaskImpl[3];

			array[0] = getByGHTUUID_E_PrevAndNext(session, ghAutomatorTask,
					ghTaskUuid, enabled, orderByComparator, true);

			array[1] = ghAutomatorTask;

			array[2] = getByGHTUUID_E_PrevAndNext(session, ghAutomatorTask,
					ghTaskUuid, enabled, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GHAutomatorTask getByGHTUUID_E_PrevAndNext(Session session,
		GHAutomatorTask ghAutomatorTask, String ghTaskUuid, boolean enabled,
		OrderByComparator<GHAutomatorTask> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_GHAUTOMATORTASK_WHERE);

		boolean bindGhTaskUuid = false;

		if (ghTaskUuid == null) {
			query.append(_FINDER_COLUMN_GHTUUID_E_GHTASKUUID_1);
		}
		else if (ghTaskUuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_GHTUUID_E_GHTASKUUID_3);
		}
		else {
			bindGhTaskUuid = true;

			query.append(_FINDER_COLUMN_GHTUUID_E_GHTASKUUID_2);
		}

		query.append(_FINDER_COLUMN_GHTUUID_E_ENABLED_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(GHAutomatorTaskModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindGhTaskUuid) {
			qPos.add(ghTaskUuid);
		}

		qPos.add(enabled);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ghAutomatorTask);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GHAutomatorTask> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g h automator tasks where ghTaskUuid = &#63; and enabled = &#63; from the database.
	 *
	 * @param ghTaskUuid the gh task uuid
	 * @param enabled the enabled
	 */
	@Override
	public void removeByGHTUUID_E(String ghTaskUuid, boolean enabled) {
		for (GHAutomatorTask ghAutomatorTask : findByGHTUUID_E(ghTaskUuid,
				enabled, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ghAutomatorTask);
		}
	}

	/**
	 * Returns the number of g h automator tasks where ghTaskUuid = &#63; and enabled = &#63;.
	 *
	 * @param ghTaskUuid the gh task uuid
	 * @param enabled the enabled
	 * @return the number of matching g h automator tasks
	 */
	@Override
	public int countByGHTUUID_E(String ghTaskUuid, boolean enabled) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GHTUUID_E;

		Object[] finderArgs = new Object[] { ghTaskUuid, enabled };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_GHAUTOMATORTASK_WHERE);

			boolean bindGhTaskUuid = false;

			if (ghTaskUuid == null) {
				query.append(_FINDER_COLUMN_GHTUUID_E_GHTASKUUID_1);
			}
			else if (ghTaskUuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GHTUUID_E_GHTASKUUID_3);
			}
			else {
				bindGhTaskUuid = true;

				query.append(_FINDER_COLUMN_GHTUUID_E_GHTASKUUID_2);
			}

			query.append(_FINDER_COLUMN_GHTUUID_E_ENABLED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindGhTaskUuid) {
					qPos.add(ghTaskUuid);
				}

				qPos.add(enabled);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GHTUUID_E_GHTASKUUID_1 = "ghAutomatorTask.ghTaskUuid IS NULL AND ";
	private static final String _FINDER_COLUMN_GHTUUID_E_GHTASKUUID_2 = "ghAutomatorTask.ghTaskUuid = ? AND ";
	private static final String _FINDER_COLUMN_GHTUUID_E_GHTASKUUID_3 = "(ghAutomatorTask.ghTaskUuid IS NULL OR ghAutomatorTask.ghTaskUuid = '') AND ";
	private static final String _FINDER_COLUMN_GHTUUID_E_ENABLED_2 = "ghAutomatorTask.enabled = ?";

	public GHAutomatorTaskPersistenceImpl() {
		setModelClass(GHAutomatorTask.class);
	}

	/**
	 * Caches the g h automator task in the entity cache if it is enabled.
	 *
	 * @param ghAutomatorTask the g h automator task
	 */
	@Override
	public void cacheResult(GHAutomatorTask ghAutomatorTask) {
		entityCache.putResult(GHAutomatorTaskModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorTaskImpl.class, ghAutomatorTask.getPrimaryKey(),
			ghAutomatorTask);

		finderCache.putResult(FINDER_PATH_FETCH_BY_GHRID_GHTUUID,
			new Object[] {
				ghAutomatorTask.getGhRepositoryId(),
				ghAutomatorTask.getGhTaskUuid()
			}, ghAutomatorTask);

		ghAutomatorTask.resetOriginalValues();
	}

	/**
	 * Caches the g h automator tasks in the entity cache if it is enabled.
	 *
	 * @param ghAutomatorTasks the g h automator tasks
	 */
	@Override
	public void cacheResult(List<GHAutomatorTask> ghAutomatorTasks) {
		for (GHAutomatorTask ghAutomatorTask : ghAutomatorTasks) {
			if (entityCache.getResult(
						GHAutomatorTaskModelImpl.ENTITY_CACHE_ENABLED,
						GHAutomatorTaskImpl.class,
						ghAutomatorTask.getPrimaryKey()) == null) {
				cacheResult(ghAutomatorTask);
			}
			else {
				ghAutomatorTask.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all g h automator tasks.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GHAutomatorTaskImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the g h automator task.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GHAutomatorTask ghAutomatorTask) {
		entityCache.removeResult(GHAutomatorTaskModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorTaskImpl.class, ghAutomatorTask.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((GHAutomatorTaskModelImpl)ghAutomatorTask);
	}

	@Override
	public void clearCache(List<GHAutomatorTask> ghAutomatorTasks) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GHAutomatorTask ghAutomatorTask : ghAutomatorTasks) {
			entityCache.removeResult(GHAutomatorTaskModelImpl.ENTITY_CACHE_ENABLED,
				GHAutomatorTaskImpl.class, ghAutomatorTask.getPrimaryKey());

			clearUniqueFindersCache((GHAutomatorTaskModelImpl)ghAutomatorTask);
		}
	}

	protected void cacheUniqueFindersCache(
		GHAutomatorTaskModelImpl ghAutomatorTaskModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					ghAutomatorTaskModelImpl.getGhRepositoryId(),
					ghAutomatorTaskModelImpl.getGhTaskUuid()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_GHRID_GHTUUID, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_GHRID_GHTUUID, args,
				ghAutomatorTaskModelImpl);
		}
		else {
			if ((ghAutomatorTaskModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_GHRID_GHTUUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ghAutomatorTaskModelImpl.getGhRepositoryId(),
						ghAutomatorTaskModelImpl.getGhTaskUuid()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_GHRID_GHTUUID, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_GHRID_GHTUUID, args,
					ghAutomatorTaskModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		GHAutomatorTaskModelImpl ghAutomatorTaskModelImpl) {
		Object[] args = new Object[] {
				ghAutomatorTaskModelImpl.getGhRepositoryId(),
				ghAutomatorTaskModelImpl.getGhTaskUuid()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_GHRID_GHTUUID, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_GHRID_GHTUUID, args);

		if ((ghAutomatorTaskModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_GHRID_GHTUUID.getColumnBitmask()) != 0) {
			args = new Object[] {
					ghAutomatorTaskModelImpl.getOriginalGhRepositoryId(),
					ghAutomatorTaskModelImpl.getOriginalGhTaskUuid()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GHRID_GHTUUID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_GHRID_GHTUUID, args);
		}
	}

	/**
	 * Creates a new g h automator task with the primary key. Does not add the g h automator task to the database.
	 *
	 * @param ghAutomatorTaskId the primary key for the new g h automator task
	 * @return the new g h automator task
	 */
	@Override
	public GHAutomatorTask create(long ghAutomatorTaskId) {
		GHAutomatorTask ghAutomatorTask = new GHAutomatorTaskImpl();

		ghAutomatorTask.setNew(true);
		ghAutomatorTask.setPrimaryKey(ghAutomatorTaskId);

		String uuid = PortalUUIDUtil.generate();

		ghAutomatorTask.setUuid(uuid);

		return ghAutomatorTask;
	}

	/**
	 * Removes the g h automator task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ghAutomatorTaskId the primary key of the g h automator task
	 * @return the g h automator task that was removed
	 * @throws NoSuchGHAutomatorTaskException if a g h automator task with the primary key could not be found
	 */
	@Override
	public GHAutomatorTask remove(long ghAutomatorTaskId)
		throws NoSuchGHAutomatorTaskException {
		return remove((Serializable)ghAutomatorTaskId);
	}

	/**
	 * Removes the g h automator task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the g h automator task
	 * @return the g h automator task that was removed
	 * @throws NoSuchGHAutomatorTaskException if a g h automator task with the primary key could not be found
	 */
	@Override
	public GHAutomatorTask remove(Serializable primaryKey)
		throws NoSuchGHAutomatorTaskException {
		Session session = null;

		try {
			session = openSession();

			GHAutomatorTask ghAutomatorTask = (GHAutomatorTask)session.get(GHAutomatorTaskImpl.class,
					primaryKey);

			if (ghAutomatorTask == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGHAutomatorTaskException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ghAutomatorTask);
		}
		catch (NoSuchGHAutomatorTaskException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected GHAutomatorTask removeImpl(GHAutomatorTask ghAutomatorTask) {
		ghAutomatorTask = toUnwrappedModel(ghAutomatorTask);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ghAutomatorTask)) {
				ghAutomatorTask = (GHAutomatorTask)session.get(GHAutomatorTaskImpl.class,
						ghAutomatorTask.getPrimaryKeyObj());
			}

			if (ghAutomatorTask != null) {
				session.delete(ghAutomatorTask);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ghAutomatorTask != null) {
			clearCache(ghAutomatorTask);
		}

		return ghAutomatorTask;
	}

	@Override
	public GHAutomatorTask updateImpl(GHAutomatorTask ghAutomatorTask) {
		ghAutomatorTask = toUnwrappedModel(ghAutomatorTask);

		boolean isNew = ghAutomatorTask.isNew();

		GHAutomatorTaskModelImpl ghAutomatorTaskModelImpl = (GHAutomatorTaskModelImpl)ghAutomatorTask;

		if (Validator.isNull(ghAutomatorTask.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			ghAutomatorTask.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (ghAutomatorTask.getCreateDate() == null)) {
			if (serviceContext == null) {
				ghAutomatorTask.setCreateDate(now);
			}
			else {
				ghAutomatorTask.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!ghAutomatorTaskModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				ghAutomatorTask.setModifiedDate(now);
			}
			else {
				ghAutomatorTask.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (ghAutomatorTask.isNew()) {
				session.save(ghAutomatorTask);

				ghAutomatorTask.setNew(false);
			}
			else {
				ghAutomatorTask = (GHAutomatorTask)session.merge(ghAutomatorTask);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !GHAutomatorTaskModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((ghAutomatorTaskModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ghAutomatorTaskModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { ghAutomatorTaskModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((ghAutomatorTaskModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GHREPOSITORYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ghAutomatorTaskModelImpl.getOriginalGhRepositoryId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GHREPOSITORYID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GHREPOSITORYID,
					args);

				args = new Object[] { ghAutomatorTaskModelImpl.getGhRepositoryId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GHREPOSITORYID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GHREPOSITORYID,
					args);
			}

			if ((ghAutomatorTaskModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GHTASKUUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ghAutomatorTaskModelImpl.getOriginalGhTaskUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GHTASKUUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GHTASKUUID,
					args);

				args = new Object[] { ghAutomatorTaskModelImpl.getGhTaskUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GHTASKUUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GHTASKUUID,
					args);
			}

			if ((ghAutomatorTaskModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GHRID_E.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ghAutomatorTaskModelImpl.getOriginalGhRepositoryId(),
						ghAutomatorTaskModelImpl.getOriginalEnabled()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GHRID_E, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GHRID_E,
					args);

				args = new Object[] {
						ghAutomatorTaskModelImpl.getGhRepositoryId(),
						ghAutomatorTaskModelImpl.getEnabled()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GHRID_E, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GHRID_E,
					args);
			}

			if ((ghAutomatorTaskModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GHTUUID_E.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ghAutomatorTaskModelImpl.getOriginalGhTaskUuid(),
						ghAutomatorTaskModelImpl.getOriginalEnabled()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GHTUUID_E, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GHTUUID_E,
					args);

				args = new Object[] {
						ghAutomatorTaskModelImpl.getGhTaskUuid(),
						ghAutomatorTaskModelImpl.getEnabled()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GHTUUID_E, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GHTUUID_E,
					args);
			}
		}

		entityCache.putResult(GHAutomatorTaskModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorTaskImpl.class, ghAutomatorTask.getPrimaryKey(),
			ghAutomatorTask, false);

		clearUniqueFindersCache(ghAutomatorTaskModelImpl);
		cacheUniqueFindersCache(ghAutomatorTaskModelImpl, isNew);

		ghAutomatorTask.resetOriginalValues();

		return ghAutomatorTask;
	}

	protected GHAutomatorTask toUnwrappedModel(GHAutomatorTask ghAutomatorTask) {
		if (ghAutomatorTask instanceof GHAutomatorTaskImpl) {
			return ghAutomatorTask;
		}

		GHAutomatorTaskImpl ghAutomatorTaskImpl = new GHAutomatorTaskImpl();

		ghAutomatorTaskImpl.setNew(ghAutomatorTask.isNew());
		ghAutomatorTaskImpl.setPrimaryKey(ghAutomatorTask.getPrimaryKey());

		ghAutomatorTaskImpl.setUuid(ghAutomatorTask.getUuid());
		ghAutomatorTaskImpl.setGhAutomatorTaskId(ghAutomatorTask.getGhAutomatorTaskId());
		ghAutomatorTaskImpl.setUserId(ghAutomatorTask.getUserId());
		ghAutomatorTaskImpl.setCreateDate(ghAutomatorTask.getCreateDate());
		ghAutomatorTaskImpl.setModifiedDate(ghAutomatorTask.getModifiedDate());
		ghAutomatorTaskImpl.setGhRepositoryId(ghAutomatorTask.getGhRepositoryId());
		ghAutomatorTaskImpl.setGhTaskUuid(ghAutomatorTask.getGhTaskUuid());
		ghAutomatorTaskImpl.setEnabled(ghAutomatorTask.isEnabled());

		return ghAutomatorTaskImpl;
	}

	/**
	 * Returns the g h automator task with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the g h automator task
	 * @return the g h automator task
	 * @throws NoSuchGHAutomatorTaskException if a g h automator task with the primary key could not be found
	 */
	@Override
	public GHAutomatorTask findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGHAutomatorTaskException {
		GHAutomatorTask ghAutomatorTask = fetchByPrimaryKey(primaryKey);

		if (ghAutomatorTask == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGHAutomatorTaskException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return ghAutomatorTask;
	}

	/**
	 * Returns the g h automator task with the primary key or throws a {@link NoSuchGHAutomatorTaskException} if it could not be found.
	 *
	 * @param ghAutomatorTaskId the primary key of the g h automator task
	 * @return the g h automator task
	 * @throws NoSuchGHAutomatorTaskException if a g h automator task with the primary key could not be found
	 */
	@Override
	public GHAutomatorTask findByPrimaryKey(long ghAutomatorTaskId)
		throws NoSuchGHAutomatorTaskException {
		return findByPrimaryKey((Serializable)ghAutomatorTaskId);
	}

	/**
	 * Returns the g h automator task with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the g h automator task
	 * @return the g h automator task, or <code>null</code> if a g h automator task with the primary key could not be found
	 */
	@Override
	public GHAutomatorTask fetchByPrimaryKey(Serializable primaryKey) {
		GHAutomatorTask ghAutomatorTask = (GHAutomatorTask)entityCache.getResult(GHAutomatorTaskModelImpl.ENTITY_CACHE_ENABLED,
				GHAutomatorTaskImpl.class, primaryKey);

		if (ghAutomatorTask == _nullGHAutomatorTask) {
			return null;
		}

		if (ghAutomatorTask == null) {
			Session session = null;

			try {
				session = openSession();

				ghAutomatorTask = (GHAutomatorTask)session.get(GHAutomatorTaskImpl.class,
						primaryKey);

				if (ghAutomatorTask != null) {
					cacheResult(ghAutomatorTask);
				}
				else {
					entityCache.putResult(GHAutomatorTaskModelImpl.ENTITY_CACHE_ENABLED,
						GHAutomatorTaskImpl.class, primaryKey,
						_nullGHAutomatorTask);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(GHAutomatorTaskModelImpl.ENTITY_CACHE_ENABLED,
					GHAutomatorTaskImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return ghAutomatorTask;
	}

	/**
	 * Returns the g h automator task with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ghAutomatorTaskId the primary key of the g h automator task
	 * @return the g h automator task, or <code>null</code> if a g h automator task with the primary key could not be found
	 */
	@Override
	public GHAutomatorTask fetchByPrimaryKey(long ghAutomatorTaskId) {
		return fetchByPrimaryKey((Serializable)ghAutomatorTaskId);
	}

	@Override
	public Map<Serializable, GHAutomatorTask> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, GHAutomatorTask> map = new HashMap<Serializable, GHAutomatorTask>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			GHAutomatorTask ghAutomatorTask = fetchByPrimaryKey(primaryKey);

			if (ghAutomatorTask != null) {
				map.put(primaryKey, ghAutomatorTask);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			GHAutomatorTask ghAutomatorTask = (GHAutomatorTask)entityCache.getResult(GHAutomatorTaskModelImpl.ENTITY_CACHE_ENABLED,
					GHAutomatorTaskImpl.class, primaryKey);

			if (ghAutomatorTask == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, ghAutomatorTask);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_GHAUTOMATORTASK_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (GHAutomatorTask ghAutomatorTask : (List<GHAutomatorTask>)q.list()) {
				map.put(ghAutomatorTask.getPrimaryKeyObj(), ghAutomatorTask);

				cacheResult(ghAutomatorTask);

				uncachedPrimaryKeys.remove(ghAutomatorTask.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(GHAutomatorTaskModelImpl.ENTITY_CACHE_ENABLED,
					GHAutomatorTaskImpl.class, primaryKey, _nullGHAutomatorTask);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the g h automator tasks.
	 *
	 * @return the g h automator tasks
	 */
	@Override
	public List<GHAutomatorTask> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g h automator tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GHAutomatorTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g h automator tasks
	 * @param end the upper bound of the range of g h automator tasks (not inclusive)
	 * @return the range of g h automator tasks
	 */
	@Override
	public List<GHAutomatorTask> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the g h automator tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GHAutomatorTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g h automator tasks
	 * @param end the upper bound of the range of g h automator tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of g h automator tasks
	 */
	@Override
	public List<GHAutomatorTask> findAll(int start, int end,
		OrderByComparator<GHAutomatorTask> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the g h automator tasks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GHAutomatorTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g h automator tasks
	 * @param end the upper bound of the range of g h automator tasks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of g h automator tasks
	 */
	@Override
	public List<GHAutomatorTask> findAll(int start, int end,
		OrderByComparator<GHAutomatorTask> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<GHAutomatorTask> list = null;

		if (retrieveFromCache) {
			list = (List<GHAutomatorTask>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_GHAUTOMATORTASK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GHAUTOMATORTASK;

				if (pagination) {
					sql = sql.concat(GHAutomatorTaskModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GHAutomatorTask>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<GHAutomatorTask>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the g h automator tasks from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (GHAutomatorTask ghAutomatorTask : findAll()) {
			remove(ghAutomatorTask);
		}
	}

	/**
	 * Returns the number of g h automator tasks.
	 *
	 * @return the number of g h automator tasks
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_GHAUTOMATORTASK);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GHAutomatorTaskModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the g h automator task persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(GHAutomatorTaskImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_GHAUTOMATORTASK = "SELECT ghAutomatorTask FROM GHAutomatorTask ghAutomatorTask";
	private static final String _SQL_SELECT_GHAUTOMATORTASK_WHERE_PKS_IN = "SELECT ghAutomatorTask FROM GHAutomatorTask ghAutomatorTask WHERE ghAutomatorTaskId IN (";
	private static final String _SQL_SELECT_GHAUTOMATORTASK_WHERE = "SELECT ghAutomatorTask FROM GHAutomatorTask ghAutomatorTask WHERE ";
	private static final String _SQL_COUNT_GHAUTOMATORTASK = "SELECT COUNT(ghAutomatorTask) FROM GHAutomatorTask ghAutomatorTask";
	private static final String _SQL_COUNT_GHAUTOMATORTASK_WHERE = "SELECT COUNT(ghAutomatorTask) FROM GHAutomatorTask ghAutomatorTask WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ghAutomatorTask.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GHAutomatorTask exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GHAutomatorTask exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(GHAutomatorTaskPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static final GHAutomatorTask _nullGHAutomatorTask = new GHAutomatorTaskImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GHAutomatorTask> toCacheModel() {
				return _nullGHAutomatorTaskCacheModel;
			}
		};

	private static final CacheModel<GHAutomatorTask> _nullGHAutomatorTaskCacheModel =
		new CacheModel<GHAutomatorTask>() {
			@Override
			public GHAutomatorTask toEntityModel() {
				return _nullGHAutomatorTask;
			}
		};
}