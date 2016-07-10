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

package com.liferay.github.automator.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.github.automator.model.GHAutomatorRepository;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the g h automator repository service. This utility wraps {@link com.liferay.github.automator.service.persistence.impl.GHAutomatorRepositoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GHAutomatorRepositoryPersistence
 * @see com.liferay.github.automator.service.persistence.impl.GHAutomatorRepositoryPersistenceImpl
 * @generated
 */
@ProviderType
public class GHAutomatorRepositoryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(GHAutomatorRepository ghAutomatorRepository) {
		getPersistence().clearCache(ghAutomatorRepository);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GHAutomatorRepository> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GHAutomatorRepository> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GHAutomatorRepository> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<GHAutomatorRepository> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static GHAutomatorRepository update(
		GHAutomatorRepository ghAutomatorRepository) {
		return getPersistence().update(ghAutomatorRepository);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static GHAutomatorRepository update(
		GHAutomatorRepository ghAutomatorRepository,
		ServiceContext serviceContext) {
		return getPersistence().update(ghAutomatorRepository, serviceContext);
	}

	/**
	* Returns all the g h automator repositories where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching g h automator repositories
	*/
	public static List<GHAutomatorRepository> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<GHAutomatorRepository> findByUuid(
		java.lang.String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<GHAutomatorRepository> findByUuid(
		java.lang.String uuid, int start, int end,
		OrderByComparator<GHAutomatorRepository> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<GHAutomatorRepository> findByUuid(
		java.lang.String uuid, int start, int end,
		OrderByComparator<GHAutomatorRepository> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first g h automator repository in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g h automator repository
	* @throws NoSuchGHAutomatorRepositoryException if a matching g h automator repository could not be found
	*/
	public static GHAutomatorRepository findByUuid_First(
		java.lang.String uuid,
		OrderByComparator<GHAutomatorRepository> orderByComparator)
		throws com.liferay.github.automator.exception.NoSuchGHAutomatorRepositoryException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first g h automator repository in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g h automator repository, or <code>null</code> if a matching g h automator repository could not be found
	*/
	public static GHAutomatorRepository fetchByUuid_First(
		java.lang.String uuid,
		OrderByComparator<GHAutomatorRepository> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last g h automator repository in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g h automator repository
	* @throws NoSuchGHAutomatorRepositoryException if a matching g h automator repository could not be found
	*/
	public static GHAutomatorRepository findByUuid_Last(java.lang.String uuid,
		OrderByComparator<GHAutomatorRepository> orderByComparator)
		throws com.liferay.github.automator.exception.NoSuchGHAutomatorRepositoryException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last g h automator repository in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g h automator repository, or <code>null</code> if a matching g h automator repository could not be found
	*/
	public static GHAutomatorRepository fetchByUuid_Last(
		java.lang.String uuid,
		OrderByComparator<GHAutomatorRepository> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static GHAutomatorRepository[] findByUuid_PrevAndNext(
		long ghAutomatorRepositoryId, java.lang.String uuid,
		OrderByComparator<GHAutomatorRepository> orderByComparator)
		throws com.liferay.github.automator.exception.NoSuchGHAutomatorRepositoryException {
		return getPersistence()
				   .findByUuid_PrevAndNext(ghAutomatorRepositoryId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the g h automator repositories where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of g h automator repositories where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching g h automator repositories
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the g h automator repository where ghRepositoryId = &#63; or throws a {@link NoSuchGHAutomatorRepositoryException} if it could not be found.
	*
	* @param ghRepositoryId the gh repository ID
	* @return the matching g h automator repository
	* @throws NoSuchGHAutomatorRepositoryException if a matching g h automator repository could not be found
	*/
	public static GHAutomatorRepository findByGHRepositoryId(
		java.lang.String ghRepositoryId)
		throws com.liferay.github.automator.exception.NoSuchGHAutomatorRepositoryException {
		return getPersistence().findByGHRepositoryId(ghRepositoryId);
	}

	/**
	* Returns the g h automator repository where ghRepositoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ghRepositoryId the gh repository ID
	* @return the matching g h automator repository, or <code>null</code> if a matching g h automator repository could not be found
	*/
	public static GHAutomatorRepository fetchByGHRepositoryId(
		java.lang.String ghRepositoryId) {
		return getPersistence().fetchByGHRepositoryId(ghRepositoryId);
	}

	/**
	* Returns the g h automator repository where ghRepositoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ghRepositoryId the gh repository ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching g h automator repository, or <code>null</code> if a matching g h automator repository could not be found
	*/
	public static GHAutomatorRepository fetchByGHRepositoryId(
		java.lang.String ghRepositoryId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByGHRepositoryId(ghRepositoryId, retrieveFromCache);
	}

	/**
	* Removes the g h automator repository where ghRepositoryId = &#63; from the database.
	*
	* @param ghRepositoryId the gh repository ID
	* @return the g h automator repository that was removed
	*/
	public static GHAutomatorRepository removeByGHRepositoryId(
		java.lang.String ghRepositoryId)
		throws com.liferay.github.automator.exception.NoSuchGHAutomatorRepositoryException {
		return getPersistence().removeByGHRepositoryId(ghRepositoryId);
	}

	/**
	* Returns the number of g h automator repositories where ghRepositoryId = &#63;.
	*
	* @param ghRepositoryId the gh repository ID
	* @return the number of matching g h automator repositories
	*/
	public static int countByGHRepositoryId(java.lang.String ghRepositoryId) {
		return getPersistence().countByGHRepositoryId(ghRepositoryId);
	}

	/**
	* Returns all the g h automator repositories where enabled = &#63;.
	*
	* @param enabled the enabled
	* @return the matching g h automator repositories
	*/
	public static List<GHAutomatorRepository> findByGHRID_E(boolean enabled) {
		return getPersistence().findByGHRID_E(enabled);
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
	public static List<GHAutomatorRepository> findByGHRID_E(boolean enabled,
		int start, int end) {
		return getPersistence().findByGHRID_E(enabled, start, end);
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
	public static List<GHAutomatorRepository> findByGHRID_E(boolean enabled,
		int start, int end,
		OrderByComparator<GHAutomatorRepository> orderByComparator) {
		return getPersistence()
				   .findByGHRID_E(enabled, start, end, orderByComparator);
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
	public static List<GHAutomatorRepository> findByGHRID_E(boolean enabled,
		int start, int end,
		OrderByComparator<GHAutomatorRepository> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGHRID_E(enabled, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first g h automator repository in the ordered set where enabled = &#63;.
	*
	* @param enabled the enabled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g h automator repository
	* @throws NoSuchGHAutomatorRepositoryException if a matching g h automator repository could not be found
	*/
	public static GHAutomatorRepository findByGHRID_E_First(boolean enabled,
		OrderByComparator<GHAutomatorRepository> orderByComparator)
		throws com.liferay.github.automator.exception.NoSuchGHAutomatorRepositoryException {
		return getPersistence().findByGHRID_E_First(enabled, orderByComparator);
	}

	/**
	* Returns the first g h automator repository in the ordered set where enabled = &#63;.
	*
	* @param enabled the enabled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g h automator repository, or <code>null</code> if a matching g h automator repository could not be found
	*/
	public static GHAutomatorRepository fetchByGHRID_E_First(boolean enabled,
		OrderByComparator<GHAutomatorRepository> orderByComparator) {
		return getPersistence().fetchByGHRID_E_First(enabled, orderByComparator);
	}

	/**
	* Returns the last g h automator repository in the ordered set where enabled = &#63;.
	*
	* @param enabled the enabled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g h automator repository
	* @throws NoSuchGHAutomatorRepositoryException if a matching g h automator repository could not be found
	*/
	public static GHAutomatorRepository findByGHRID_E_Last(boolean enabled,
		OrderByComparator<GHAutomatorRepository> orderByComparator)
		throws com.liferay.github.automator.exception.NoSuchGHAutomatorRepositoryException {
		return getPersistence().findByGHRID_E_Last(enabled, orderByComparator);
	}

	/**
	* Returns the last g h automator repository in the ordered set where enabled = &#63;.
	*
	* @param enabled the enabled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g h automator repository, or <code>null</code> if a matching g h automator repository could not be found
	*/
	public static GHAutomatorRepository fetchByGHRID_E_Last(boolean enabled,
		OrderByComparator<GHAutomatorRepository> orderByComparator) {
		return getPersistence().fetchByGHRID_E_Last(enabled, orderByComparator);
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
	public static GHAutomatorRepository[] findByGHRID_E_PrevAndNext(
		long ghAutomatorRepositoryId, boolean enabled,
		OrderByComparator<GHAutomatorRepository> orderByComparator)
		throws com.liferay.github.automator.exception.NoSuchGHAutomatorRepositoryException {
		return getPersistence()
				   .findByGHRID_E_PrevAndNext(ghAutomatorRepositoryId, enabled,
			orderByComparator);
	}

	/**
	* Removes all the g h automator repositories where enabled = &#63; from the database.
	*
	* @param enabled the enabled
	*/
	public static void removeByGHRID_E(boolean enabled) {
		getPersistence().removeByGHRID_E(enabled);
	}

	/**
	* Returns the number of g h automator repositories where enabled = &#63;.
	*
	* @param enabled the enabled
	* @return the number of matching g h automator repositories
	*/
	public static int countByGHRID_E(boolean enabled) {
		return getPersistence().countByGHRID_E(enabled);
	}

	/**
	* Caches the g h automator repository in the entity cache if it is enabled.
	*
	* @param ghAutomatorRepository the g h automator repository
	*/
	public static void cacheResult(GHAutomatorRepository ghAutomatorRepository) {
		getPersistence().cacheResult(ghAutomatorRepository);
	}

	/**
	* Caches the g h automator repositories in the entity cache if it is enabled.
	*
	* @param ghAutomatorRepositories the g h automator repositories
	*/
	public static void cacheResult(
		List<GHAutomatorRepository> ghAutomatorRepositories) {
		getPersistence().cacheResult(ghAutomatorRepositories);
	}

	/**
	* Creates a new g h automator repository with the primary key. Does not add the g h automator repository to the database.
	*
	* @param ghAutomatorRepositoryId the primary key for the new g h automator repository
	* @return the new g h automator repository
	*/
	public static GHAutomatorRepository create(long ghAutomatorRepositoryId) {
		return getPersistence().create(ghAutomatorRepositoryId);
	}

	/**
	* Removes the g h automator repository with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ghAutomatorRepositoryId the primary key of the g h automator repository
	* @return the g h automator repository that was removed
	* @throws NoSuchGHAutomatorRepositoryException if a g h automator repository with the primary key could not be found
	*/
	public static GHAutomatorRepository remove(long ghAutomatorRepositoryId)
		throws com.liferay.github.automator.exception.NoSuchGHAutomatorRepositoryException {
		return getPersistence().remove(ghAutomatorRepositoryId);
	}

	public static GHAutomatorRepository updateImpl(
		GHAutomatorRepository ghAutomatorRepository) {
		return getPersistence().updateImpl(ghAutomatorRepository);
	}

	/**
	* Returns the g h automator repository with the primary key or throws a {@link NoSuchGHAutomatorRepositoryException} if it could not be found.
	*
	* @param ghAutomatorRepositoryId the primary key of the g h automator repository
	* @return the g h automator repository
	* @throws NoSuchGHAutomatorRepositoryException if a g h automator repository with the primary key could not be found
	*/
	public static GHAutomatorRepository findByPrimaryKey(
		long ghAutomatorRepositoryId)
		throws com.liferay.github.automator.exception.NoSuchGHAutomatorRepositoryException {
		return getPersistence().findByPrimaryKey(ghAutomatorRepositoryId);
	}

	/**
	* Returns the g h automator repository with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ghAutomatorRepositoryId the primary key of the g h automator repository
	* @return the g h automator repository, or <code>null</code> if a g h automator repository with the primary key could not be found
	*/
	public static GHAutomatorRepository fetchByPrimaryKey(
		long ghAutomatorRepositoryId) {
		return getPersistence().fetchByPrimaryKey(ghAutomatorRepositoryId);
	}

	public static java.util.Map<java.io.Serializable, GHAutomatorRepository> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the g h automator repositories.
	*
	* @return the g h automator repositories
	*/
	public static List<GHAutomatorRepository> findAll() {
		return getPersistence().findAll();
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
	public static List<GHAutomatorRepository> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<GHAutomatorRepository> findAll(int start, int end,
		OrderByComparator<GHAutomatorRepository> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<GHAutomatorRepository> findAll(int start, int end,
		OrderByComparator<GHAutomatorRepository> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the g h automator repositories from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of g h automator repositories.
	*
	* @return the number of g h automator repositories
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static GHAutomatorRepositoryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<GHAutomatorRepositoryPersistence, GHAutomatorRepositoryPersistence> _serviceTracker =
		ServiceTrackerFactory.open(GHAutomatorRepositoryPersistence.class);
}