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

package com.liferay.github.automator.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GHAutomatorTaskLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see GHAutomatorTaskLocalService
 * @generated
 */
@ProviderType
public class GHAutomatorTaskLocalServiceWrapper
	implements GHAutomatorTaskLocalService,
		ServiceWrapper<GHAutomatorTaskLocalService> {
	public GHAutomatorTaskLocalServiceWrapper(
		GHAutomatorTaskLocalService ghAutomatorTaskLocalService) {
		_ghAutomatorTaskLocalService = ghAutomatorTaskLocalService;
	}

	/**
	* Adds the g h automator task to the database. Also notifies the appropriate model listeners.
	*
	* @param ghAutomatorTask the g h automator task
	* @return the g h automator task that was added
	*/
	@Override
	public com.liferay.github.automator.model.GHAutomatorTask addGHAutomatorTask(
		com.liferay.github.automator.model.GHAutomatorTask ghAutomatorTask) {
		return _ghAutomatorTaskLocalService.addGHAutomatorTask(ghAutomatorTask);
	}

	/**
	* Creates a new g h automator task with the primary key. Does not add the g h automator task to the database.
	*
	* @param ghAutomatorTaskId the primary key for the new g h automator task
	* @return the new g h automator task
	*/
	@Override
	public com.liferay.github.automator.model.GHAutomatorTask createGHAutomatorTask(
		long ghAutomatorTaskId) {
		return _ghAutomatorTaskLocalService.createGHAutomatorTask(ghAutomatorTaskId);
	}

	/**
	* Deletes the g h automator task from the database. Also notifies the appropriate model listeners.
	*
	* @param ghAutomatorTask the g h automator task
	* @return the g h automator task that was removed
	*/
	@Override
	public com.liferay.github.automator.model.GHAutomatorTask deleteGHAutomatorTask(
		com.liferay.github.automator.model.GHAutomatorTask ghAutomatorTask) {
		return _ghAutomatorTaskLocalService.deleteGHAutomatorTask(ghAutomatorTask);
	}

	/**
	* Deletes the g h automator task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ghAutomatorTaskId the primary key of the g h automator task
	* @return the g h automator task that was removed
	* @throws PortalException if a g h automator task with the primary key could not be found
	*/
	@Override
	public com.liferay.github.automator.model.GHAutomatorTask deleteGHAutomatorTask(
		long ghAutomatorTaskId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ghAutomatorTaskLocalService.deleteGHAutomatorTask(ghAutomatorTaskId);
	}

	@Override
	public com.liferay.github.automator.model.GHAutomatorTask fetchGHAutomatorTask(
		long ghAutomatorTaskId) {
		return _ghAutomatorTaskLocalService.fetchGHAutomatorTask(ghAutomatorTaskId);
	}

	/**
	* Returns the g h automator task with the primary key.
	*
	* @param ghAutomatorTaskId the primary key of the g h automator task
	* @return the g h automator task
	* @throws PortalException if a g h automator task with the primary key could not be found
	*/
	@Override
	public com.liferay.github.automator.model.GHAutomatorTask getGHAutomatorTask(
		long ghAutomatorTaskId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ghAutomatorTaskLocalService.getGHAutomatorTask(ghAutomatorTaskId);
	}

	@Override
	public com.liferay.github.automator.model.GHAutomatorTask updateGHAutomatorRepository(
		long userId, java.lang.String repositoryId, boolean enabled) {
		return _ghAutomatorTaskLocalService.updateGHAutomatorRepository(userId,
			repositoryId, enabled);
	}

	/**
	* Updates the g h automator task in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ghAutomatorTask the g h automator task
	* @return the g h automator task that was updated
	*/
	@Override
	public com.liferay.github.automator.model.GHAutomatorTask updateGHAutomatorTask(
		com.liferay.github.automator.model.GHAutomatorTask ghAutomatorTask) {
		return _ghAutomatorTaskLocalService.updateGHAutomatorTask(ghAutomatorTask);
	}

	@Override
	public com.liferay.github.automator.model.GHAutomatorTask updateGHAutomatorTask(
		long userId, java.lang.String repositoryId, java.lang.String taskUuid,
		boolean enabled) {
		return _ghAutomatorTaskLocalService.updateGHAutomatorTask(userId,
			repositoryId, taskUuid, enabled);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _ghAutomatorTaskLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ghAutomatorTaskLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _ghAutomatorTaskLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ghAutomatorTaskLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ghAutomatorTaskLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of g h automator tasks.
	*
	* @return the number of g h automator tasks
	*/
	@Override
	public int getGHAutomatorTasksCount() {
		return _ghAutomatorTaskLocalService.getGHAutomatorTasksCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _ghAutomatorTaskLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _ghAutomatorTaskLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.github.automator.model.impl.GHAutomatorTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _ghAutomatorTaskLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.github.automator.model.impl.GHAutomatorTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _ghAutomatorTaskLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns a range of all the g h automator tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.github.automator.model.impl.GHAutomatorTaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g h automator tasks
	* @param end the upper bound of the range of g h automator tasks (not inclusive)
	* @return the range of g h automator tasks
	*/
	@Override
	public java.util.List<com.liferay.github.automator.model.GHAutomatorTask> getGHAutomatorTasks(
		int start, int end) {
		return _ghAutomatorTaskLocalService.getGHAutomatorTasks(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _ghAutomatorTaskLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _ghAutomatorTaskLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public GHAutomatorTaskLocalService getWrappedService() {
		return _ghAutomatorTaskLocalService;
	}

	@Override
	public void setWrappedService(
		GHAutomatorTaskLocalService ghAutomatorTaskLocalService) {
		_ghAutomatorTaskLocalService = ghAutomatorTaskLocalService;
	}

	private GHAutomatorTaskLocalService _ghAutomatorTaskLocalService;
}