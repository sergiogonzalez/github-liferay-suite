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

import com.liferay.github.automator.exception.NoSuchGHAutomatorRepositoryException;
import com.liferay.github.automator.model.GHAutomatorRepository;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the g h automator repository service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.github.automator.service.persistence.impl.GHAutomatorRepositoryPersistenceImpl
 * @see GHAutomatorRepositoryUtil
 * @generated
 */
@ProviderType
public interface GHAutomatorRepositoryPersistence extends BasePersistence<GHAutomatorRepository> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GHAutomatorRepositoryUtil} to access the g h automator repository persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the g h automator repositories where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching g h automator repositories
	*/
	public java.util.List<GHAutomatorRepository> findByUuid(
		java.lang.String uuid);

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
	public java.util.List<GHAutomatorRepository> findByUuid(
		java.lang.String uuid, int start, int end);

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
	public java.util.List<GHAutomatorRepository> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorRepository> orderByComparator);

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
	public java.util.List<GHAutomatorRepository> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorRepository> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first g h automator repository in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g h automator repository
	* @throws NoSuchGHAutomatorRepositoryException if a matching g h automator repository could not be found
	*/
	public GHAutomatorRepository findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorRepository> orderByComparator)
		throws NoSuchGHAutomatorRepositoryException;

	/**
	* Returns the first g h automator repository in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g h automator repository, or <code>null</code> if a matching g h automator repository could not be found
	*/
	public GHAutomatorRepository fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorRepository> orderByComparator);

	/**
	* Returns the last g h automator repository in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g h automator repository
	* @throws NoSuchGHAutomatorRepositoryException if a matching g h automator repository could not be found
	*/
	public GHAutomatorRepository findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorRepository> orderByComparator)
		throws NoSuchGHAutomatorRepositoryException;

	/**
	* Returns the last g h automator repository in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g h automator repository, or <code>null</code> if a matching g h automator repository could not be found
	*/
	public GHAutomatorRepository fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorRepository> orderByComparator);

	/**
	* Returns the g h automator repositories before and after the current g h automator repository in the ordered set where uuid = &#63;.
	*
	* @param ghAutomatorRepositoryId the primary key of the current g h automator repository
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g h automator repository
	* @throws NoSuchGHAutomatorRepositoryException if a g h automator repository with the primary key could not be found
	*/
	public GHAutomatorRepository[] findByUuid_PrevAndNext(
		long ghAutomatorRepositoryId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorRepository> orderByComparator)
		throws NoSuchGHAutomatorRepositoryException;

	/**
	* Removes all the g h automator repositories where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of g h automator repositories where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching g h automator repositories
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the g h automator repository where ghRepositoryId = &#63; or throws a {@link NoSuchGHAutomatorRepositoryException} if it could not be found.
	*
	* @param ghRepositoryId the gh repository ID
	* @return the matching g h automator repository
	* @throws NoSuchGHAutomatorRepositoryException if a matching g h automator repository could not be found
	*/
	public GHAutomatorRepository findByGHRepositoryId(
		java.lang.String ghRepositoryId)
		throws NoSuchGHAutomatorRepositoryException;

	/**
	* Returns the g h automator repository where ghRepositoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ghRepositoryId the gh repository ID
	* @return the matching g h automator repository, or <code>null</code> if a matching g h automator repository could not be found
	*/
	public GHAutomatorRepository fetchByGHRepositoryId(
		java.lang.String ghRepositoryId);

	/**
	* Returns the g h automator repository where ghRepositoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ghRepositoryId the gh repository ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching g h automator repository, or <code>null</code> if a matching g h automator repository could not be found
	*/
	public GHAutomatorRepository fetchByGHRepositoryId(
		java.lang.String ghRepositoryId, boolean retrieveFromCache);

	/**
	* Removes the g h automator repository where ghRepositoryId = &#63; from the database.
	*
	* @param ghRepositoryId the gh repository ID
	* @return the g h automator repository that was removed
	*/
	public GHAutomatorRepository removeByGHRepositoryId(
		java.lang.String ghRepositoryId)
		throws NoSuchGHAutomatorRepositoryException;

	/**
	* Returns the number of g h automator repositories where ghRepositoryId = &#63;.
	*
	* @param ghRepositoryId the gh repository ID
	* @return the number of matching g h automator repositories
	*/
	public int countByGHRepositoryId(java.lang.String ghRepositoryId);

	/**
	* Returns all the g h automator repositories where enabled = &#63;.
	*
	* @param enabled the enabled
	* @return the matching g h automator repositories
	*/
	public java.util.List<GHAutomatorRepository> findByGHRID_E(boolean enabled);

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
	public java.util.List<GHAutomatorRepository> findByGHRID_E(
		boolean enabled, int start, int end);

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
	public java.util.List<GHAutomatorRepository> findByGHRID_E(
		boolean enabled, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorRepository> orderByComparator);

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
	public java.util.List<GHAutomatorRepository> findByGHRID_E(
		boolean enabled, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorRepository> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first g h automator repository in the ordered set where enabled = &#63;.
	*
	* @param enabled the enabled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g h automator repository
	* @throws NoSuchGHAutomatorRepositoryException if a matching g h automator repository could not be found
	*/
	public GHAutomatorRepository findByGHRID_E_First(boolean enabled,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorRepository> orderByComparator)
		throws NoSuchGHAutomatorRepositoryException;

	/**
	* Returns the first g h automator repository in the ordered set where enabled = &#63;.
	*
	* @param enabled the enabled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g h automator repository, or <code>null</code> if a matching g h automator repository could not be found
	*/
	public GHAutomatorRepository fetchByGHRID_E_First(boolean enabled,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorRepository> orderByComparator);

	/**
	* Returns the last g h automator repository in the ordered set where enabled = &#63;.
	*
	* @param enabled the enabled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g h automator repository
	* @throws NoSuchGHAutomatorRepositoryException if a matching g h automator repository could not be found
	*/
	public GHAutomatorRepository findByGHRID_E_Last(boolean enabled,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorRepository> orderByComparator)
		throws NoSuchGHAutomatorRepositoryException;

	/**
	* Returns the last g h automator repository in the ordered set where enabled = &#63;.
	*
	* @param enabled the enabled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g h automator repository, or <code>null</code> if a matching g h automator repository could not be found
	*/
	public GHAutomatorRepository fetchByGHRID_E_Last(boolean enabled,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorRepository> orderByComparator);

	/**
	* Returns the g h automator repositories before and after the current g h automator repository in the ordered set where enabled = &#63;.
	*
	* @param ghAutomatorRepositoryId the primary key of the current g h automator repository
	* @param enabled the enabled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g h automator repository
	* @throws NoSuchGHAutomatorRepositoryException if a g h automator repository with the primary key could not be found
	*/
	public GHAutomatorRepository[] findByGHRID_E_PrevAndNext(
		long ghAutomatorRepositoryId, boolean enabled,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorRepository> orderByComparator)
		throws NoSuchGHAutomatorRepositoryException;

	/**
	* Removes all the g h automator repositories where enabled = &#63; from the database.
	*
	* @param enabled the enabled
	*/
	public void removeByGHRID_E(boolean enabled);

	/**
	* Returns the number of g h automator repositories where enabled = &#63;.
	*
	* @param enabled the enabled
	* @return the number of matching g h automator repositories
	*/
	public int countByGHRID_E(boolean enabled);

	/**
	* Caches the g h automator repository in the entity cache if it is enabled.
	*
	* @param ghAutomatorRepository the g h automator repository
	*/
	public void cacheResult(GHAutomatorRepository ghAutomatorRepository);

	/**
	* Caches the g h automator repositories in the entity cache if it is enabled.
	*
	* @param ghAutomatorRepositories the g h automator repositories
	*/
	public void cacheResult(
		java.util.List<GHAutomatorRepository> ghAutomatorRepositories);

	/**
	* Creates a new g h automator repository with the primary key. Does not add the g h automator repository to the database.
	*
	* @param ghAutomatorRepositoryId the primary key for the new g h automator repository
	* @return the new g h automator repository
	*/
	public GHAutomatorRepository create(long ghAutomatorRepositoryId);

	/**
	* Removes the g h automator repository with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ghAutomatorRepositoryId the primary key of the g h automator repository
	* @return the g h automator repository that was removed
	* @throws NoSuchGHAutomatorRepositoryException if a g h automator repository with the primary key could not be found
	*/
	public GHAutomatorRepository remove(long ghAutomatorRepositoryId)
		throws NoSuchGHAutomatorRepositoryException;

	public GHAutomatorRepository updateImpl(
		GHAutomatorRepository ghAutomatorRepository);

	/**
	* Returns the g h automator repository with the primary key or throws a {@link NoSuchGHAutomatorRepositoryException} if it could not be found.
	*
	* @param ghAutomatorRepositoryId the primary key of the g h automator repository
	* @return the g h automator repository
	* @throws NoSuchGHAutomatorRepositoryException if a g h automator repository with the primary key could not be found
	*/
	public GHAutomatorRepository findByPrimaryKey(long ghAutomatorRepositoryId)
		throws NoSuchGHAutomatorRepositoryException;

	/**
	* Returns the g h automator repository with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ghAutomatorRepositoryId the primary key of the g h automator repository
	* @return the g h automator repository, or <code>null</code> if a g h automator repository with the primary key could not be found
	*/
	public GHAutomatorRepository fetchByPrimaryKey(long ghAutomatorRepositoryId);

	@Override
	public java.util.Map<java.io.Serializable, GHAutomatorRepository> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the g h automator repositories.
	*
	* @return the g h automator repositories
	*/
	public java.util.List<GHAutomatorRepository> findAll();

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
	public java.util.List<GHAutomatorRepository> findAll(int start, int end);

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
	public java.util.List<GHAutomatorRepository> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorRepository> orderByComparator);

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
	public java.util.List<GHAutomatorRepository> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorRepository> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the g h automator repositories from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of g h automator repositories.
	*
	* @return the number of g h automator repositories
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}