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

package com.liferay.github.automator.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.github.automator.model.GHAutomatorTask;
import com.liferay.github.automator.service.GHAutomatorTaskLocalService;
import com.liferay.github.automator.service.persistence.GHAutomatorRepositoryPersistence;
import com.liferay.github.automator.service.persistence.GHAutomatorTaskPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the g h automator task local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.github.automator.service.impl.GHAutomatorTaskLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.github.automator.service.impl.GHAutomatorTaskLocalServiceImpl
 * @see com.liferay.github.automator.service.GHAutomatorTaskLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class GHAutomatorTaskLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements GHAutomatorTaskLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.github.automator.service.GHAutomatorTaskLocalServiceUtil} to access the g h automator task local service.
	 */

	/**
	 * Adds the g h automator task to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ghAutomatorTask the g h automator task
	 * @return the g h automator task that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public GHAutomatorTask addGHAutomatorTask(GHAutomatorTask ghAutomatorTask) {
		ghAutomatorTask.setNew(true);

		return ghAutomatorTaskPersistence.update(ghAutomatorTask);
	}

	/**
	 * Creates a new g h automator task with the primary key. Does not add the g h automator task to the database.
	 *
	 * @param ghAutomatorTaskId the primary key for the new g h automator task
	 * @return the new g h automator task
	 */
	@Override
	public GHAutomatorTask createGHAutomatorTask(long ghAutomatorTaskId) {
		return ghAutomatorTaskPersistence.create(ghAutomatorTaskId);
	}

	/**
	 * Deletes the g h automator task with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ghAutomatorTaskId the primary key of the g h automator task
	 * @return the g h automator task that was removed
	 * @throws PortalException if a g h automator task with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public GHAutomatorTask deleteGHAutomatorTask(long ghAutomatorTaskId)
		throws PortalException {
		return ghAutomatorTaskPersistence.remove(ghAutomatorTaskId);
	}

	/**
	 * Deletes the g h automator task from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ghAutomatorTask the g h automator task
	 * @return the g h automator task that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public GHAutomatorTask deleteGHAutomatorTask(
		GHAutomatorTask ghAutomatorTask) {
		return ghAutomatorTaskPersistence.remove(ghAutomatorTask);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(GHAutomatorTask.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return ghAutomatorTaskPersistence.findWithDynamicQuery(dynamicQuery);
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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return ghAutomatorTaskPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return ghAutomatorTaskPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return ghAutomatorTaskPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return ghAutomatorTaskPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public GHAutomatorTask fetchGHAutomatorTask(long ghAutomatorTaskId) {
		return ghAutomatorTaskPersistence.fetchByPrimaryKey(ghAutomatorTaskId);
	}

	/**
	 * Returns the g h automator task with the primary key.
	 *
	 * @param ghAutomatorTaskId the primary key of the g h automator task
	 * @return the g h automator task
	 * @throws PortalException if a g h automator task with the primary key could not be found
	 */
	@Override
	public GHAutomatorTask getGHAutomatorTask(long ghAutomatorTaskId)
		throws PortalException {
		return ghAutomatorTaskPersistence.findByPrimaryKey(ghAutomatorTaskId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(ghAutomatorTaskLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(GHAutomatorTask.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("ghAutomatorTaskId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(ghAutomatorTaskLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(GHAutomatorTask.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"ghAutomatorTaskId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(ghAutomatorTaskLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(GHAutomatorTask.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("ghAutomatorTaskId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return ghAutomatorTaskLocalService.deleteGHAutomatorTask((GHAutomatorTask)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return ghAutomatorTaskPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<GHAutomatorTask> getGHAutomatorTasks(int start, int end) {
		return ghAutomatorTaskPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of g h automator tasks.
	 *
	 * @return the number of g h automator tasks
	 */
	@Override
	public int getGHAutomatorTasksCount() {
		return ghAutomatorTaskPersistence.countAll();
	}

	/**
	 * Updates the g h automator task in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ghAutomatorTask the g h automator task
	 * @return the g h automator task that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public GHAutomatorTask updateGHAutomatorTask(
		GHAutomatorTask ghAutomatorTask) {
		return ghAutomatorTaskPersistence.update(ghAutomatorTask);
	}

	/**
	 * Returns the g h automator repository local service.
	 *
	 * @return the g h automator repository local service
	 */
	public com.liferay.github.automator.service.GHAutomatorRepositoryLocalService getGHAutomatorRepositoryLocalService() {
		return ghAutomatorRepositoryLocalService;
	}

	/**
	 * Sets the g h automator repository local service.
	 *
	 * @param ghAutomatorRepositoryLocalService the g h automator repository local service
	 */
	public void setGHAutomatorRepositoryLocalService(
		com.liferay.github.automator.service.GHAutomatorRepositoryLocalService ghAutomatorRepositoryLocalService) {
		this.ghAutomatorRepositoryLocalService = ghAutomatorRepositoryLocalService;
	}

	/**
	 * Returns the g h automator repository persistence.
	 *
	 * @return the g h automator repository persistence
	 */
	public GHAutomatorRepositoryPersistence getGHAutomatorRepositoryPersistence() {
		return ghAutomatorRepositoryPersistence;
	}

	/**
	 * Sets the g h automator repository persistence.
	 *
	 * @param ghAutomatorRepositoryPersistence the g h automator repository persistence
	 */
	public void setGHAutomatorRepositoryPersistence(
		GHAutomatorRepositoryPersistence ghAutomatorRepositoryPersistence) {
		this.ghAutomatorRepositoryPersistence = ghAutomatorRepositoryPersistence;
	}

	/**
	 * Returns the g h automator task local service.
	 *
	 * @return the g h automator task local service
	 */
	public GHAutomatorTaskLocalService getGHAutomatorTaskLocalService() {
		return ghAutomatorTaskLocalService;
	}

	/**
	 * Sets the g h automator task local service.
	 *
	 * @param ghAutomatorTaskLocalService the g h automator task local service
	 */
	public void setGHAutomatorTaskLocalService(
		GHAutomatorTaskLocalService ghAutomatorTaskLocalService) {
		this.ghAutomatorTaskLocalService = ghAutomatorTaskLocalService;
	}

	/**
	 * Returns the g h automator task persistence.
	 *
	 * @return the g h automator task persistence
	 */
	public GHAutomatorTaskPersistence getGHAutomatorTaskPersistence() {
		return ghAutomatorTaskPersistence;
	}

	/**
	 * Sets the g h automator task persistence.
	 *
	 * @param ghAutomatorTaskPersistence the g h automator task persistence
	 */
	public void setGHAutomatorTaskPersistence(
		GHAutomatorTaskPersistence ghAutomatorTaskPersistence) {
		this.ghAutomatorTaskPersistence = ghAutomatorTaskPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com.liferay.github.automator.model.GHAutomatorTask",
			ghAutomatorTaskLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.liferay.github.automator.model.GHAutomatorTask");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return GHAutomatorTaskLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return GHAutomatorTask.class;
	}

	protected String getModelClassName() {
		return GHAutomatorTask.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = ghAutomatorTaskPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.github.automator.service.GHAutomatorRepositoryLocalService.class)
	protected com.liferay.github.automator.service.GHAutomatorRepositoryLocalService ghAutomatorRepositoryLocalService;
	@BeanReference(type = GHAutomatorRepositoryPersistence.class)
	protected GHAutomatorRepositoryPersistence ghAutomatorRepositoryPersistence;
	@BeanReference(type = GHAutomatorTaskLocalService.class)
	protected GHAutomatorTaskLocalService ghAutomatorTaskLocalService;
	@BeanReference(type = GHAutomatorTaskPersistence.class)
	protected GHAutomatorTaskPersistence ghAutomatorTaskPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}