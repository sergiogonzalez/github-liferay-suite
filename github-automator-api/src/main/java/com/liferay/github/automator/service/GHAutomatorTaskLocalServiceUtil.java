package com.liferay.github.automator.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for GHAutomatorTask. This utility wraps
 * {@link com.liferay.github.automator.service.impl.GHAutomatorTaskLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Sergio González
 * @see GHAutomatorTaskLocalService
 * @see com.liferay.github.automator.service.base.GHAutomatorTaskLocalServiceBaseImpl
 * @see com.liferay.github.automator.service.impl.GHAutomatorTaskLocalServiceImpl
 * @generated
 */
@ProviderType
public class GHAutomatorTaskLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.github.automator.service.impl.GHAutomatorTaskLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static boolean isGHAutomatorRepositoryEnabled(
		java.lang.String repositoryId) {
		return getService().isGHAutomatorRepositoryEnabled(repositoryId);
	}

	public static boolean isGHAutomatorTaskEnabled(
		java.lang.String repositoryId, java.lang.String taskUuid) {
		return getService().isGHAutomatorTaskEnabled(repositoryId, taskUuid);
	}

	/**
	* Adds the g h automator task to the database. Also notifies the appropriate model listeners.
	*
	* @param ghAutomatorTask the g h automator task
	* @return the g h automator task that was added
	*/
	public static com.liferay.github.automator.model.GHAutomatorTask addGHAutomatorTask(
		com.liferay.github.automator.model.GHAutomatorTask ghAutomatorTask) {
		return getService().addGHAutomatorTask(ghAutomatorTask);
	}

	/**
	* Creates a new g h automator task with the primary key. Does not add the g h automator task to the database.
	*
	* @param ghAutomatorTaskId the primary key for the new g h automator task
	* @return the new g h automator task
	*/
	public static com.liferay.github.automator.model.GHAutomatorTask createGHAutomatorTask(
		long ghAutomatorTaskId) {
		return getService().createGHAutomatorTask(ghAutomatorTaskId);
	}

	/**
	* Deletes the g h automator task from the database. Also notifies the appropriate model listeners.
	*
	* @param ghAutomatorTask the g h automator task
	* @return the g h automator task that was removed
	*/
	public static com.liferay.github.automator.model.GHAutomatorTask deleteGHAutomatorTask(
		com.liferay.github.automator.model.GHAutomatorTask ghAutomatorTask) {
		return getService().deleteGHAutomatorTask(ghAutomatorTask);
	}

	/**
	* Deletes the g h automator task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ghAutomatorTaskId the primary key of the g h automator task
	* @return the g h automator task that was removed
	* @throws PortalException if a g h automator task with the primary key could not be found
	*/
	public static com.liferay.github.automator.model.GHAutomatorTask deleteGHAutomatorTask(
		long ghAutomatorTaskId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteGHAutomatorTask(ghAutomatorTaskId);
	}

	public static com.liferay.github.automator.model.GHAutomatorTask fetchGHAutomatorTask(
		long ghAutomatorTaskId) {
		return getService().fetchGHAutomatorTask(ghAutomatorTaskId);
	}

	/**
	* Returns the g h automator task with the primary key.
	*
	* @param ghAutomatorTaskId the primary key of the g h automator task
	* @return the g h automator task
	* @throws PortalException if a g h automator task with the primary key could not be found
	*/
	public static com.liferay.github.automator.model.GHAutomatorTask getGHAutomatorTask(
		long ghAutomatorTaskId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getGHAutomatorTask(ghAutomatorTaskId);
	}

	public static com.liferay.github.automator.model.GHAutomatorTask updateGHAutomatorRepository(
		long userId, java.lang.String repositoryId, boolean enabled) {
		return getService()
				   .updateGHAutomatorRepository(userId, repositoryId, enabled);
	}

	/**
	* Updates the g h automator task in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ghAutomatorTask the g h automator task
	* @return the g h automator task that was updated
	*/
	public static com.liferay.github.automator.model.GHAutomatorTask updateGHAutomatorTask(
		com.liferay.github.automator.model.GHAutomatorTask ghAutomatorTask) {
		return getService().updateGHAutomatorTask(ghAutomatorTask);
	}

	public static com.liferay.github.automator.model.GHAutomatorTask updateGHAutomatorTask(
		long userId, java.lang.String repositoryId, java.lang.String taskUuid,
		boolean enabled) {
		return getService()
				   .updateGHAutomatorTask(userId, repositoryId, taskUuid,
			enabled);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of g h automator tasks.
	*
	* @return the number of g h automator tasks
	*/
	public static int getGHAutomatorTasksCount() {
		return getService().getGHAutomatorTasksCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
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
	public static java.util.List<com.liferay.github.automator.model.GHAutomatorTask> getGHAutomatorTasks(
		int start, int end) {
		return getService().getGHAutomatorTasks(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static GHAutomatorTaskLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<GHAutomatorTaskLocalService, GHAutomatorTaskLocalService> _serviceTracker =
		ServiceTrackerFactory.open(GHAutomatorTaskLocalService.class);
}