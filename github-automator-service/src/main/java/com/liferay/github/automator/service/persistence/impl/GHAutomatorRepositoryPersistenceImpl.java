package com.liferay.github.automator.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.github.automator.exception.NoSuchGHAutomatorRepositoryException;
import com.liferay.github.automator.model.GHAutomatorRepository;
import com.liferay.github.automator.model.impl.GHAutomatorRepositoryImpl;
import com.liferay.github.automator.model.impl.GHAutomatorRepositoryModelImpl;
import com.liferay.github.automator.service.persistence.GHAutomatorRepositoryPersistence;

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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the g h automator repository service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sergio González
 * @see GHAutomatorRepositoryPersistence
 * @see com.liferay.github.automator.service.persistence.GHAutomatorRepositoryUtil
 * @generated
 */
@ProviderType
public class GHAutomatorRepositoryPersistenceImpl extends BasePersistenceImpl<GHAutomatorRepository>
	implements GHAutomatorRepositoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GHAutomatorRepositoryUtil} to access the g h automator repository persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GHAutomatorRepositoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GHAutomatorRepositoryModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorRepositoryModelImpl.FINDER_CACHE_ENABLED,
			GHAutomatorRepositoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GHAutomatorRepositoryModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorRepositoryModelImpl.FINDER_CACHE_ENABLED,
			GHAutomatorRepositoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GHAutomatorRepositoryModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorRepositoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(GHAutomatorRepositoryModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorRepositoryModelImpl.FINDER_CACHE_ENABLED,
			GHAutomatorRepositoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(GHAutomatorRepositoryModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorRepositoryModelImpl.FINDER_CACHE_ENABLED,
			GHAutomatorRepositoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			GHAutomatorRepositoryModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(GHAutomatorRepositoryModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorRepositoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the g h automator repositories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching g h automator repositories
	 */
	@Override
	public List<GHAutomatorRepository> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g h automator repositories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GHAutomatorRepositoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of g h automator repositories
	 * @param end the upper bound of the range of g h automator repositories (not inclusive)
	 * @return the range of matching g h automator repositories
	 */
	@Override
	public List<GHAutomatorRepository> findByUuid(String uuid, int start,
		int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the g h automator repositories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GHAutomatorRepositoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of g h automator repositories
	 * @param end the upper bound of the range of g h automator repositories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g h automator repositories
	 */
	@Override
	public List<GHAutomatorRepository> findByUuid(String uuid, int start,
		int end, OrderByComparator<GHAutomatorRepository> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the g h automator repositories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GHAutomatorRepositoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of g h automator repositories
	 * @param end the upper bound of the range of g h automator repositories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching g h automator repositories
	 */
	@Override
	public List<GHAutomatorRepository> findByUuid(String uuid, int start,
		int end, OrderByComparator<GHAutomatorRepository> orderByComparator,
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

		List<GHAutomatorRepository> list = null;

		if (retrieveFromCache) {
			list = (List<GHAutomatorRepository>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GHAutomatorRepository ghAutomatorRepository : list) {
					if (!Objects.equals(uuid, ghAutomatorRepository.getUuid())) {
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

			query.append(_SQL_SELECT_GHAUTOMATORREPOSITORY_WHERE);

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
				query.append(GHAutomatorRepositoryModelImpl.ORDER_BY_JPQL);
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
					list = (List<GHAutomatorRepository>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<GHAutomatorRepository>)QueryUtil.list(q,
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
	 * Returns the first g h automator repository in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g h automator repository
	 * @throws NoSuchGHAutomatorRepositoryException if a matching g h automator repository could not be found
	 */
	@Override
	public GHAutomatorRepository findByUuid_First(String uuid,
		OrderByComparator<GHAutomatorRepository> orderByComparator)
		throws NoSuchGHAutomatorRepositoryException {
		GHAutomatorRepository ghAutomatorRepository = fetchByUuid_First(uuid,
				orderByComparator);

		if (ghAutomatorRepository != null) {
			return ghAutomatorRepository;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGHAutomatorRepositoryException(msg.toString());
	}

	/**
	 * Returns the first g h automator repository in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g h automator repository, or <code>null</code> if a matching g h automator repository could not be found
	 */
	@Override
	public GHAutomatorRepository fetchByUuid_First(String uuid,
		OrderByComparator<GHAutomatorRepository> orderByComparator) {
		List<GHAutomatorRepository> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g h automator repository in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g h automator repository
	 * @throws NoSuchGHAutomatorRepositoryException if a matching g h automator repository could not be found
	 */
	@Override
	public GHAutomatorRepository findByUuid_Last(String uuid,
		OrderByComparator<GHAutomatorRepository> orderByComparator)
		throws NoSuchGHAutomatorRepositoryException {
		GHAutomatorRepository ghAutomatorRepository = fetchByUuid_Last(uuid,
				orderByComparator);

		if (ghAutomatorRepository != null) {
			return ghAutomatorRepository;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGHAutomatorRepositoryException(msg.toString());
	}

	/**
	 * Returns the last g h automator repository in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g h automator repository, or <code>null</code> if a matching g h automator repository could not be found
	 */
	@Override
	public GHAutomatorRepository fetchByUuid_Last(String uuid,
		OrderByComparator<GHAutomatorRepository> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<GHAutomatorRepository> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g h automator repositories before and after the current g h automator repository in the ordered set where uuid = &#63;.
	 *
	 * @param ghAutomatorRepositoryId the primary key of the current g h automator repository
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g h automator repository
	 * @throws NoSuchGHAutomatorRepositoryException if a g h automator repository with the primary key could not be found
	 */
	@Override
	public GHAutomatorRepository[] findByUuid_PrevAndNext(
		long ghAutomatorRepositoryId, String uuid,
		OrderByComparator<GHAutomatorRepository> orderByComparator)
		throws NoSuchGHAutomatorRepositoryException {
		GHAutomatorRepository ghAutomatorRepository = findByPrimaryKey(ghAutomatorRepositoryId);

		Session session = null;

		try {
			session = openSession();

			GHAutomatorRepository[] array = new GHAutomatorRepositoryImpl[3];

			array[0] = getByUuid_PrevAndNext(session, ghAutomatorRepository,
					uuid, orderByComparator, true);

			array[1] = ghAutomatorRepository;

			array[2] = getByUuid_PrevAndNext(session, ghAutomatorRepository,
					uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GHAutomatorRepository getByUuid_PrevAndNext(Session session,
		GHAutomatorRepository ghAutomatorRepository, String uuid,
		OrderByComparator<GHAutomatorRepository> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GHAUTOMATORREPOSITORY_WHERE);

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
			query.append(GHAutomatorRepositoryModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(ghAutomatorRepository);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GHAutomatorRepository> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g h automator repositories where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (GHAutomatorRepository ghAutomatorRepository : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ghAutomatorRepository);
		}
	}

	/**
	 * Returns the number of g h automator repositories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching g h automator repositories
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GHAUTOMATORREPOSITORY_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "ghAutomatorRepository.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "ghAutomatorRepository.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(ghAutomatorRepository.uuid IS NULL OR ghAutomatorRepository.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_GHREPOSITORYID = new FinderPath(GHAutomatorRepositoryModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorRepositoryModelImpl.FINDER_CACHE_ENABLED,
			GHAutomatorRepositoryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByGHRepositoryId", new String[] { String.class.getName() },
			GHAutomatorRepositoryModelImpl.GHREPOSITORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GHREPOSITORYID = new FinderPath(GHAutomatorRepositoryModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorRepositoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGHRepositoryId",
			new String[] { String.class.getName() });

	/**
	 * Returns the g h automator repository where ghRepositoryId = &#63; or throws a {@link NoSuchGHAutomatorRepositoryException} if it could not be found.
	 *
	 * @param ghRepositoryId the gh repository ID
	 * @return the matching g h automator repository
	 * @throws NoSuchGHAutomatorRepositoryException if a matching g h automator repository could not be found
	 */
	@Override
	public GHAutomatorRepository findByGHRepositoryId(String ghRepositoryId)
		throws NoSuchGHAutomatorRepositoryException {
		GHAutomatorRepository ghAutomatorRepository = fetchByGHRepositoryId(ghRepositoryId);

		if (ghAutomatorRepository == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ghRepositoryId=");
			msg.append(ghRepositoryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchGHAutomatorRepositoryException(msg.toString());
		}

		return ghAutomatorRepository;
	}

	/**
	 * Returns the g h automator repository where ghRepositoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ghRepositoryId the gh repository ID
	 * @return the matching g h automator repository, or <code>null</code> if a matching g h automator repository could not be found
	 */
	@Override
	public GHAutomatorRepository fetchByGHRepositoryId(String ghRepositoryId) {
		return fetchByGHRepositoryId(ghRepositoryId, true);
	}

	/**
	 * Returns the g h automator repository where ghRepositoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ghRepositoryId the gh repository ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching g h automator repository, or <code>null</code> if a matching g h automator repository could not be found
	 */
	@Override
	public GHAutomatorRepository fetchByGHRepositoryId(String ghRepositoryId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { ghRepositoryId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_GHREPOSITORYID,
					finderArgs, this);
		}

		if (result instanceof GHAutomatorRepository) {
			GHAutomatorRepository ghAutomatorRepository = (GHAutomatorRepository)result;

			if (!Objects.equals(ghRepositoryId,
						ghAutomatorRepository.getGhRepositoryId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_GHAUTOMATORREPOSITORY_WHERE);

			boolean bindGhRepositoryId = false;

			if (ghRepositoryId == null) {
				query.append(_FINDER_COLUMN_GHREPOSITORYID_GHREPOSITORYID_1);
			}
			else if (ghRepositoryId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GHREPOSITORYID_GHREPOSITORYID_3);
			}
			else {
				bindGhRepositoryId = true;

				query.append(_FINDER_COLUMN_GHREPOSITORYID_GHREPOSITORYID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindGhRepositoryId) {
					qPos.add(ghRepositoryId);
				}

				List<GHAutomatorRepository> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_GHREPOSITORYID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"GHAutomatorRepositoryPersistenceImpl.fetchByGHRepositoryId(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					GHAutomatorRepository ghAutomatorRepository = list.get(0);

					result = ghAutomatorRepository;

					cacheResult(ghAutomatorRepository);

					if ((ghAutomatorRepository.getGhRepositoryId() == null) ||
							!ghAutomatorRepository.getGhRepositoryId()
													  .equals(ghRepositoryId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_GHREPOSITORYID,
							finderArgs, ghAutomatorRepository);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_GHREPOSITORYID,
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
			return (GHAutomatorRepository)result;
		}
	}

	/**
	 * Removes the g h automator repository where ghRepositoryId = &#63; from the database.
	 *
	 * @param ghRepositoryId the gh repository ID
	 * @return the g h automator repository that was removed
	 */
	@Override
	public GHAutomatorRepository removeByGHRepositoryId(String ghRepositoryId)
		throws NoSuchGHAutomatorRepositoryException {
		GHAutomatorRepository ghAutomatorRepository = findByGHRepositoryId(ghRepositoryId);

		return remove(ghAutomatorRepository);
	}

	/**
	 * Returns the number of g h automator repositories where ghRepositoryId = &#63;.
	 *
	 * @param ghRepositoryId the gh repository ID
	 * @return the number of matching g h automator repositories
	 */
	@Override
	public int countByGHRepositoryId(String ghRepositoryId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GHREPOSITORYID;

		Object[] finderArgs = new Object[] { ghRepositoryId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GHAUTOMATORREPOSITORY_WHERE);

			boolean bindGhRepositoryId = false;

			if (ghRepositoryId == null) {
				query.append(_FINDER_COLUMN_GHREPOSITORYID_GHREPOSITORYID_1);
			}
			else if (ghRepositoryId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GHREPOSITORYID_GHREPOSITORYID_3);
			}
			else {
				bindGhRepositoryId = true;

				query.append(_FINDER_COLUMN_GHREPOSITORYID_GHREPOSITORYID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindGhRepositoryId) {
					qPos.add(ghRepositoryId);
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

	private static final String _FINDER_COLUMN_GHREPOSITORYID_GHREPOSITORYID_1 = "ghAutomatorRepository.ghRepositoryId IS NULL";
	private static final String _FINDER_COLUMN_GHREPOSITORYID_GHREPOSITORYID_2 = "ghAutomatorRepository.ghRepositoryId = ?";
	private static final String _FINDER_COLUMN_GHREPOSITORYID_GHREPOSITORYID_3 = "(ghAutomatorRepository.ghRepositoryId IS NULL OR ghAutomatorRepository.ghRepositoryId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GHRID_E = new FinderPath(GHAutomatorRepositoryModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorRepositoryModelImpl.FINDER_CACHE_ENABLED,
			GHAutomatorRepositoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGHRID_E",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GHRID_E =
		new FinderPath(GHAutomatorRepositoryModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorRepositoryModelImpl.FINDER_CACHE_ENABLED,
			GHAutomatorRepositoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGHRID_E",
			new String[] { Boolean.class.getName() },
			GHAutomatorRepositoryModelImpl.ENABLED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GHRID_E = new FinderPath(GHAutomatorRepositoryModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorRepositoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGHRID_E",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the g h automator repositories where enabled = &#63;.
	 *
	 * @param enabled the enabled
	 * @return the matching g h automator repositories
	 */
	@Override
	public List<GHAutomatorRepository> findByGHRID_E(boolean enabled) {
		return findByGHRID_E(enabled, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g h automator repositories where enabled = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GHAutomatorRepositoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param enabled the enabled
	 * @param start the lower bound of the range of g h automator repositories
	 * @param end the upper bound of the range of g h automator repositories (not inclusive)
	 * @return the range of matching g h automator repositories
	 */
	@Override
	public List<GHAutomatorRepository> findByGHRID_E(boolean enabled,
		int start, int end) {
		return findByGHRID_E(enabled, start, end, null);
	}

	/**
	 * Returns an ordered range of all the g h automator repositories where enabled = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GHAutomatorRepositoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param enabled the enabled
	 * @param start the lower bound of the range of g h automator repositories
	 * @param end the upper bound of the range of g h automator repositories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g h automator repositories
	 */
	@Override
	public List<GHAutomatorRepository> findByGHRID_E(boolean enabled,
		int start, int end,
		OrderByComparator<GHAutomatorRepository> orderByComparator) {
		return findByGHRID_E(enabled, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the g h automator repositories where enabled = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GHAutomatorRepositoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param enabled the enabled
	 * @param start the lower bound of the range of g h automator repositories
	 * @param end the upper bound of the range of g h automator repositories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching g h automator repositories
	 */
	@Override
	public List<GHAutomatorRepository> findByGHRID_E(boolean enabled,
		int start, int end,
		OrderByComparator<GHAutomatorRepository> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GHRID_E;
			finderArgs = new Object[] { enabled };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GHRID_E;
			finderArgs = new Object[] { enabled, start, end, orderByComparator };
		}

		List<GHAutomatorRepository> list = null;

		if (retrieveFromCache) {
			list = (List<GHAutomatorRepository>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GHAutomatorRepository ghAutomatorRepository : list) {
					if ((enabled != ghAutomatorRepository.getEnabled())) {
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

			query.append(_SQL_SELECT_GHAUTOMATORREPOSITORY_WHERE);

			query.append(_FINDER_COLUMN_GHRID_E_ENABLED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GHAutomatorRepositoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(enabled);

				if (!pagination) {
					list = (List<GHAutomatorRepository>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<GHAutomatorRepository>)QueryUtil.list(q,
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
	 * Returns the first g h automator repository in the ordered set where enabled = &#63;.
	 *
	 * @param enabled the enabled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g h automator repository
	 * @throws NoSuchGHAutomatorRepositoryException if a matching g h automator repository could not be found
	 */
	@Override
	public GHAutomatorRepository findByGHRID_E_First(boolean enabled,
		OrderByComparator<GHAutomatorRepository> orderByComparator)
		throws NoSuchGHAutomatorRepositoryException {
		GHAutomatorRepository ghAutomatorRepository = fetchByGHRID_E_First(enabled,
				orderByComparator);

		if (ghAutomatorRepository != null) {
			return ghAutomatorRepository;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("enabled=");
		msg.append(enabled);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGHAutomatorRepositoryException(msg.toString());
	}

	/**
	 * Returns the first g h automator repository in the ordered set where enabled = &#63;.
	 *
	 * @param enabled the enabled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g h automator repository, or <code>null</code> if a matching g h automator repository could not be found
	 */
	@Override
	public GHAutomatorRepository fetchByGHRID_E_First(boolean enabled,
		OrderByComparator<GHAutomatorRepository> orderByComparator) {
		List<GHAutomatorRepository> list = findByGHRID_E(enabled, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g h automator repository in the ordered set where enabled = &#63;.
	 *
	 * @param enabled the enabled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g h automator repository
	 * @throws NoSuchGHAutomatorRepositoryException if a matching g h automator repository could not be found
	 */
	@Override
	public GHAutomatorRepository findByGHRID_E_Last(boolean enabled,
		OrderByComparator<GHAutomatorRepository> orderByComparator)
		throws NoSuchGHAutomatorRepositoryException {
		GHAutomatorRepository ghAutomatorRepository = fetchByGHRID_E_Last(enabled,
				orderByComparator);

		if (ghAutomatorRepository != null) {
			return ghAutomatorRepository;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("enabled=");
		msg.append(enabled);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGHAutomatorRepositoryException(msg.toString());
	}

	/**
	 * Returns the last g h automator repository in the ordered set where enabled = &#63;.
	 *
	 * @param enabled the enabled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g h automator repository, or <code>null</code> if a matching g h automator repository could not be found
	 */
	@Override
	public GHAutomatorRepository fetchByGHRID_E_Last(boolean enabled,
		OrderByComparator<GHAutomatorRepository> orderByComparator) {
		int count = countByGHRID_E(enabled);

		if (count == 0) {
			return null;
		}

		List<GHAutomatorRepository> list = findByGHRID_E(enabled, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g h automator repositories before and after the current g h automator repository in the ordered set where enabled = &#63;.
	 *
	 * @param ghAutomatorRepositoryId the primary key of the current g h automator repository
	 * @param enabled the enabled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g h automator repository
	 * @throws NoSuchGHAutomatorRepositoryException if a g h automator repository with the primary key could not be found
	 */
	@Override
	public GHAutomatorRepository[] findByGHRID_E_PrevAndNext(
		long ghAutomatorRepositoryId, boolean enabled,
		OrderByComparator<GHAutomatorRepository> orderByComparator)
		throws NoSuchGHAutomatorRepositoryException {
		GHAutomatorRepository ghAutomatorRepository = findByPrimaryKey(ghAutomatorRepositoryId);

		Session session = null;

		try {
			session = openSession();

			GHAutomatorRepository[] array = new GHAutomatorRepositoryImpl[3];

			array[0] = getByGHRID_E_PrevAndNext(session, ghAutomatorRepository,
					enabled, orderByComparator, true);

			array[1] = ghAutomatorRepository;

			array[2] = getByGHRID_E_PrevAndNext(session, ghAutomatorRepository,
					enabled, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GHAutomatorRepository getByGHRID_E_PrevAndNext(Session session,
		GHAutomatorRepository ghAutomatorRepository, boolean enabled,
		OrderByComparator<GHAutomatorRepository> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GHAUTOMATORREPOSITORY_WHERE);

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
			query.append(GHAutomatorRepositoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(enabled);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ghAutomatorRepository);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GHAutomatorRepository> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g h automator repositories where enabled = &#63; from the database.
	 *
	 * @param enabled the enabled
	 */
	@Override
	public void removeByGHRID_E(boolean enabled) {
		for (GHAutomatorRepository ghAutomatorRepository : findByGHRID_E(
				enabled, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ghAutomatorRepository);
		}
	}

	/**
	 * Returns the number of g h automator repositories where enabled = &#63;.
	 *
	 * @param enabled the enabled
	 * @return the number of matching g h automator repositories
	 */
	@Override
	public int countByGHRID_E(boolean enabled) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GHRID_E;

		Object[] finderArgs = new Object[] { enabled };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GHAUTOMATORREPOSITORY_WHERE);

			query.append(_FINDER_COLUMN_GHRID_E_ENABLED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_GHRID_E_ENABLED_2 = "ghAutomatorRepository.enabled = ?";

	public GHAutomatorRepositoryPersistenceImpl() {
		setModelClass(GHAutomatorRepository.class);
	}

	/**
	 * Caches the g h automator repository in the entity cache if it is enabled.
	 *
	 * @param ghAutomatorRepository the g h automator repository
	 */
	@Override
	public void cacheResult(GHAutomatorRepository ghAutomatorRepository) {
		entityCache.putResult(GHAutomatorRepositoryModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorRepositoryImpl.class,
			ghAutomatorRepository.getPrimaryKey(), ghAutomatorRepository);

		finderCache.putResult(FINDER_PATH_FETCH_BY_GHREPOSITORYID,
			new Object[] { ghAutomatorRepository.getGhRepositoryId() },
			ghAutomatorRepository);

		ghAutomatorRepository.resetOriginalValues();
	}

	/**
	 * Caches the g h automator repositories in the entity cache if it is enabled.
	 *
	 * @param ghAutomatorRepositories the g h automator repositories
	 */
	@Override
	public void cacheResult(List<GHAutomatorRepository> ghAutomatorRepositories) {
		for (GHAutomatorRepository ghAutomatorRepository : ghAutomatorRepositories) {
			if (entityCache.getResult(
						GHAutomatorRepositoryModelImpl.ENTITY_CACHE_ENABLED,
						GHAutomatorRepositoryImpl.class,
						ghAutomatorRepository.getPrimaryKey()) == null) {
				cacheResult(ghAutomatorRepository);
			}
			else {
				ghAutomatorRepository.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all g h automator repositories.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GHAutomatorRepositoryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the g h automator repository.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GHAutomatorRepository ghAutomatorRepository) {
		entityCache.removeResult(GHAutomatorRepositoryModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorRepositoryImpl.class,
			ghAutomatorRepository.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((GHAutomatorRepositoryModelImpl)ghAutomatorRepository);
	}

	@Override
	public void clearCache(List<GHAutomatorRepository> ghAutomatorRepositories) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GHAutomatorRepository ghAutomatorRepository : ghAutomatorRepositories) {
			entityCache.removeResult(GHAutomatorRepositoryModelImpl.ENTITY_CACHE_ENABLED,
				GHAutomatorRepositoryImpl.class,
				ghAutomatorRepository.getPrimaryKey());

			clearUniqueFindersCache((GHAutomatorRepositoryModelImpl)ghAutomatorRepository);
		}
	}

	protected void cacheUniqueFindersCache(
		GHAutomatorRepositoryModelImpl ghAutomatorRepositoryModelImpl,
		boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					ghAutomatorRepositoryModelImpl.getGhRepositoryId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_GHREPOSITORYID, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_GHREPOSITORYID, args,
				ghAutomatorRepositoryModelImpl);
		}
		else {
			if ((ghAutomatorRepositoryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_GHREPOSITORYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ghAutomatorRepositoryModelImpl.getGhRepositoryId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_GHREPOSITORYID,
					args, Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_GHREPOSITORYID,
					args, ghAutomatorRepositoryModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		GHAutomatorRepositoryModelImpl ghAutomatorRepositoryModelImpl) {
		Object[] args = new Object[] {
				ghAutomatorRepositoryModelImpl.getGhRepositoryId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_GHREPOSITORYID, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_GHREPOSITORYID, args);

		if ((ghAutomatorRepositoryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_GHREPOSITORYID.getColumnBitmask()) != 0) {
			args = new Object[] {
					ghAutomatorRepositoryModelImpl.getOriginalGhRepositoryId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GHREPOSITORYID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_GHREPOSITORYID, args);
		}
	}

	/**
	 * Creates a new g h automator repository with the primary key. Does not add the g h automator repository to the database.
	 *
	 * @param ghAutomatorRepositoryId the primary key for the new g h automator repository
	 * @return the new g h automator repository
	 */
	@Override
	public GHAutomatorRepository create(long ghAutomatorRepositoryId) {
		GHAutomatorRepository ghAutomatorRepository = new GHAutomatorRepositoryImpl();

		ghAutomatorRepository.setNew(true);
		ghAutomatorRepository.setPrimaryKey(ghAutomatorRepositoryId);

		String uuid = PortalUUIDUtil.generate();

		ghAutomatorRepository.setUuid(uuid);

		return ghAutomatorRepository;
	}

	/**
	 * Removes the g h automator repository with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ghAutomatorRepositoryId the primary key of the g h automator repository
	 * @return the g h automator repository that was removed
	 * @throws NoSuchGHAutomatorRepositoryException if a g h automator repository with the primary key could not be found
	 */
	@Override
	public GHAutomatorRepository remove(long ghAutomatorRepositoryId)
		throws NoSuchGHAutomatorRepositoryException {
		return remove((Serializable)ghAutomatorRepositoryId);
	}

	/**
	 * Removes the g h automator repository with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the g h automator repository
	 * @return the g h automator repository that was removed
	 * @throws NoSuchGHAutomatorRepositoryException if a g h automator repository with the primary key could not be found
	 */
	@Override
	public GHAutomatorRepository remove(Serializable primaryKey)
		throws NoSuchGHAutomatorRepositoryException {
		Session session = null;

		try {
			session = openSession();

			GHAutomatorRepository ghAutomatorRepository = (GHAutomatorRepository)session.get(GHAutomatorRepositoryImpl.class,
					primaryKey);

			if (ghAutomatorRepository == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGHAutomatorRepositoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ghAutomatorRepository);
		}
		catch (NoSuchGHAutomatorRepositoryException nsee) {
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
	protected GHAutomatorRepository removeImpl(
		GHAutomatorRepository ghAutomatorRepository) {
		ghAutomatorRepository = toUnwrappedModel(ghAutomatorRepository);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ghAutomatorRepository)) {
				ghAutomatorRepository = (GHAutomatorRepository)session.get(GHAutomatorRepositoryImpl.class,
						ghAutomatorRepository.getPrimaryKeyObj());
			}

			if (ghAutomatorRepository != null) {
				session.delete(ghAutomatorRepository);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ghAutomatorRepository != null) {
			clearCache(ghAutomatorRepository);
		}

		return ghAutomatorRepository;
	}

	@Override
	public GHAutomatorRepository updateImpl(
		GHAutomatorRepository ghAutomatorRepository) {
		ghAutomatorRepository = toUnwrappedModel(ghAutomatorRepository);

		boolean isNew = ghAutomatorRepository.isNew();

		GHAutomatorRepositoryModelImpl ghAutomatorRepositoryModelImpl = (GHAutomatorRepositoryModelImpl)ghAutomatorRepository;

		if (Validator.isNull(ghAutomatorRepository.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			ghAutomatorRepository.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (ghAutomatorRepository.isNew()) {
				session.save(ghAutomatorRepository);

				ghAutomatorRepository.setNew(false);
			}
			else {
				ghAutomatorRepository = (GHAutomatorRepository)session.merge(ghAutomatorRepository);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !GHAutomatorRepositoryModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((ghAutomatorRepositoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ghAutomatorRepositoryModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { ghAutomatorRepositoryModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((ghAutomatorRepositoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GHRID_E.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ghAutomatorRepositoryModelImpl.getOriginalEnabled()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GHRID_E, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GHRID_E,
					args);

				args = new Object[] { ghAutomatorRepositoryModelImpl.getEnabled() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GHRID_E, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GHRID_E,
					args);
			}
		}

		entityCache.putResult(GHAutomatorRepositoryModelImpl.ENTITY_CACHE_ENABLED,
			GHAutomatorRepositoryImpl.class,
			ghAutomatorRepository.getPrimaryKey(), ghAutomatorRepository, false);

		clearUniqueFindersCache(ghAutomatorRepositoryModelImpl);
		cacheUniqueFindersCache(ghAutomatorRepositoryModelImpl, isNew);

		ghAutomatorRepository.resetOriginalValues();

		return ghAutomatorRepository;
	}

	protected GHAutomatorRepository toUnwrappedModel(
		GHAutomatorRepository ghAutomatorRepository) {
		if (ghAutomatorRepository instanceof GHAutomatorRepositoryImpl) {
			return ghAutomatorRepository;
		}

		GHAutomatorRepositoryImpl ghAutomatorRepositoryImpl = new GHAutomatorRepositoryImpl();

		ghAutomatorRepositoryImpl.setNew(ghAutomatorRepository.isNew());
		ghAutomatorRepositoryImpl.setPrimaryKey(ghAutomatorRepository.getPrimaryKey());

		ghAutomatorRepositoryImpl.setUuid(ghAutomatorRepository.getUuid());
		ghAutomatorRepositoryImpl.setGhAutomatorRepositoryId(ghAutomatorRepository.getGhAutomatorRepositoryId());
		ghAutomatorRepositoryImpl.setUserId(ghAutomatorRepository.getUserId());
		ghAutomatorRepositoryImpl.setCreateDate(ghAutomatorRepository.getCreateDate());
		ghAutomatorRepositoryImpl.setGhRepositoryId(ghAutomatorRepository.getGhRepositoryId());
		ghAutomatorRepositoryImpl.setEnabled(ghAutomatorRepository.isEnabled());

		return ghAutomatorRepositoryImpl;
	}

	/**
	 * Returns the g h automator repository with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the g h automator repository
	 * @return the g h automator repository
	 * @throws NoSuchGHAutomatorRepositoryException if a g h automator repository with the primary key could not be found
	 */
	@Override
	public GHAutomatorRepository findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGHAutomatorRepositoryException {
		GHAutomatorRepository ghAutomatorRepository = fetchByPrimaryKey(primaryKey);

		if (ghAutomatorRepository == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGHAutomatorRepositoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return ghAutomatorRepository;
	}

	/**
	 * Returns the g h automator repository with the primary key or throws a {@link NoSuchGHAutomatorRepositoryException} if it could not be found.
	 *
	 * @param ghAutomatorRepositoryId the primary key of the g h automator repository
	 * @return the g h automator repository
	 * @throws NoSuchGHAutomatorRepositoryException if a g h automator repository with the primary key could not be found
	 */
	@Override
	public GHAutomatorRepository findByPrimaryKey(long ghAutomatorRepositoryId)
		throws NoSuchGHAutomatorRepositoryException {
		return findByPrimaryKey((Serializable)ghAutomatorRepositoryId);
	}

	/**
	 * Returns the g h automator repository with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the g h automator repository
	 * @return the g h automator repository, or <code>null</code> if a g h automator repository with the primary key could not be found
	 */
	@Override
	public GHAutomatorRepository fetchByPrimaryKey(Serializable primaryKey) {
		GHAutomatorRepository ghAutomatorRepository = (GHAutomatorRepository)entityCache.getResult(GHAutomatorRepositoryModelImpl.ENTITY_CACHE_ENABLED,
				GHAutomatorRepositoryImpl.class, primaryKey);

		if (ghAutomatorRepository == _nullGHAutomatorRepository) {
			return null;
		}

		if (ghAutomatorRepository == null) {
			Session session = null;

			try {
				session = openSession();

				ghAutomatorRepository = (GHAutomatorRepository)session.get(GHAutomatorRepositoryImpl.class,
						primaryKey);

				if (ghAutomatorRepository != null) {
					cacheResult(ghAutomatorRepository);
				}
				else {
					entityCache.putResult(GHAutomatorRepositoryModelImpl.ENTITY_CACHE_ENABLED,
						GHAutomatorRepositoryImpl.class, primaryKey,
						_nullGHAutomatorRepository);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(GHAutomatorRepositoryModelImpl.ENTITY_CACHE_ENABLED,
					GHAutomatorRepositoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return ghAutomatorRepository;
	}

	/**
	 * Returns the g h automator repository with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ghAutomatorRepositoryId the primary key of the g h automator repository
	 * @return the g h automator repository, or <code>null</code> if a g h automator repository with the primary key could not be found
	 */
	@Override
	public GHAutomatorRepository fetchByPrimaryKey(long ghAutomatorRepositoryId) {
		return fetchByPrimaryKey((Serializable)ghAutomatorRepositoryId);
	}

	@Override
	public Map<Serializable, GHAutomatorRepository> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, GHAutomatorRepository> map = new HashMap<Serializable, GHAutomatorRepository>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			GHAutomatorRepository ghAutomatorRepository = fetchByPrimaryKey(primaryKey);

			if (ghAutomatorRepository != null) {
				map.put(primaryKey, ghAutomatorRepository);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			GHAutomatorRepository ghAutomatorRepository = (GHAutomatorRepository)entityCache.getResult(GHAutomatorRepositoryModelImpl.ENTITY_CACHE_ENABLED,
					GHAutomatorRepositoryImpl.class, primaryKey);

			if (ghAutomatorRepository == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, ghAutomatorRepository);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_GHAUTOMATORREPOSITORY_WHERE_PKS_IN);

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

			for (GHAutomatorRepository ghAutomatorRepository : (List<GHAutomatorRepository>)q.list()) {
				map.put(ghAutomatorRepository.getPrimaryKeyObj(),
					ghAutomatorRepository);

				cacheResult(ghAutomatorRepository);

				uncachedPrimaryKeys.remove(ghAutomatorRepository.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(GHAutomatorRepositoryModelImpl.ENTITY_CACHE_ENABLED,
					GHAutomatorRepositoryImpl.class, primaryKey,
					_nullGHAutomatorRepository);
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
	 * Returns all the g h automator repositories.
	 *
	 * @return the g h automator repositories
	 */
	@Override
	public List<GHAutomatorRepository> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g h automator repositories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GHAutomatorRepositoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g h automator repositories
	 * @param end the upper bound of the range of g h automator repositories (not inclusive)
	 * @return the range of g h automator repositories
	 */
	@Override
	public List<GHAutomatorRepository> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the g h automator repositories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GHAutomatorRepositoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g h automator repositories
	 * @param end the upper bound of the range of g h automator repositories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of g h automator repositories
	 */
	@Override
	public List<GHAutomatorRepository> findAll(int start, int end,
		OrderByComparator<GHAutomatorRepository> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the g h automator repositories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GHAutomatorRepositoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g h automator repositories
	 * @param end the upper bound of the range of g h automator repositories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of g h automator repositories
	 */
	@Override
	public List<GHAutomatorRepository> findAll(int start, int end,
		OrderByComparator<GHAutomatorRepository> orderByComparator,
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

		List<GHAutomatorRepository> list = null;

		if (retrieveFromCache) {
			list = (List<GHAutomatorRepository>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_GHAUTOMATORREPOSITORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GHAUTOMATORREPOSITORY;

				if (pagination) {
					sql = sql.concat(GHAutomatorRepositoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GHAutomatorRepository>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<GHAutomatorRepository>)QueryUtil.list(q,
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
	 * Removes all the g h automator repositories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (GHAutomatorRepository ghAutomatorRepository : findAll()) {
			remove(ghAutomatorRepository);
		}
	}

	/**
	 * Returns the number of g h automator repositories.
	 *
	 * @return the number of g h automator repositories
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_GHAUTOMATORREPOSITORY);

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
		return GHAutomatorRepositoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the g h automator repository persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(GHAutomatorRepositoryImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_GHAUTOMATORREPOSITORY = "SELECT ghAutomatorRepository FROM GHAutomatorRepository ghAutomatorRepository";
	private static final String _SQL_SELECT_GHAUTOMATORREPOSITORY_WHERE_PKS_IN = "SELECT ghAutomatorRepository FROM GHAutomatorRepository ghAutomatorRepository WHERE ghAutomatorRepositoryId IN (";
	private static final String _SQL_SELECT_GHAUTOMATORREPOSITORY_WHERE = "SELECT ghAutomatorRepository FROM GHAutomatorRepository ghAutomatorRepository WHERE ";
	private static final String _SQL_COUNT_GHAUTOMATORREPOSITORY = "SELECT COUNT(ghAutomatorRepository) FROM GHAutomatorRepository ghAutomatorRepository";
	private static final String _SQL_COUNT_GHAUTOMATORREPOSITORY_WHERE = "SELECT COUNT(ghAutomatorRepository) FROM GHAutomatorRepository ghAutomatorRepository WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ghAutomatorRepository.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GHAutomatorRepository exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GHAutomatorRepository exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(GHAutomatorRepositoryPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static final GHAutomatorRepository _nullGHAutomatorRepository = new GHAutomatorRepositoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GHAutomatorRepository> toCacheModel() {
				return _nullGHAutomatorRepositoryCacheModel;
			}
		};

	private static final CacheModel<GHAutomatorRepository> _nullGHAutomatorRepositoryCacheModel =
		new CacheModel<GHAutomatorRepository>() {
			@Override
			public GHAutomatorRepository toEntityModel() {
				return _nullGHAutomatorRepository;
			}
		};
}