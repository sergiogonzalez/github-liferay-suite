package com.liferay.github.automator.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.github.automator.model.GHAutomatorTask;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for GHAutomatorTask. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Sergio González
 * @see GHAutomatorTaskLocalServiceUtil
 * @see com.liferay.github.automator.service.base.GHAutomatorTaskLocalServiceBaseImpl
 * @see com.liferay.github.automator.service.impl.GHAutomatorTaskLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface GHAutomatorTaskLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GHAutomatorTaskLocalServiceUtil} to access the g h automator task local service. Add custom service methods to {@link com.liferay.github.automator.service.impl.GHAutomatorTaskLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the g h automator task to the database. Also notifies the appropriate model listeners.
	*
	* @param ghAutomatorTask the g h automator task
	* @return the g h automator task that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public GHAutomatorTask addGHAutomatorTask(GHAutomatorTask ghAutomatorTask);

	/**
	* Creates a new g h automator task with the primary key. Does not add the g h automator task to the database.
	*
	* @param ghAutomatorTaskId the primary key for the new g h automator task
	* @return the new g h automator task
	*/
	public GHAutomatorTask createGHAutomatorTask(long ghAutomatorTaskId);

	/**
	* Deletes the g h automator task from the database. Also notifies the appropriate model listeners.
	*
	* @param ghAutomatorTask the g h automator task
	* @return the g h automator task that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public GHAutomatorTask deleteGHAutomatorTask(
		GHAutomatorTask ghAutomatorTask);

	/**
	* Deletes the g h automator task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ghAutomatorTaskId the primary key of the g h automator task
	* @return the g h automator task that was removed
	* @throws PortalException if a g h automator task with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public GHAutomatorTask deleteGHAutomatorTask(long ghAutomatorTaskId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public GHAutomatorTask fetchGHAutomatorTask(long ghAutomatorTaskId);

	/**
	* Returns the g h automator task with the primary key.
	*
	* @param ghAutomatorTaskId the primary key of the g h automator task
	* @return the g h automator task
	* @throws PortalException if a g h automator task with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public GHAutomatorTask getGHAutomatorTask(long ghAutomatorTaskId)
		throws PortalException;

	public GHAutomatorTask updateGHAutomatorRepository(long userId,
		java.lang.String repositoryId, boolean enabled);

	/**
	* Updates the g h automator task in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ghAutomatorTask the g h automator task
	* @return the g h automator task that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public GHAutomatorTask updateGHAutomatorTask(
		GHAutomatorTask ghAutomatorTask);

	public GHAutomatorTask updateGHAutomatorTask(long userId,
		java.lang.String repositoryId, java.lang.String taskUuid,
		boolean enabled);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Returns the number of g h automator tasks.
	*
	* @return the number of g h automator tasks
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getGHAutomatorTasksCount();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<GHAutomatorTask> getGHAutomatorTasks(int start, int end);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);
}