package com.liferay.github.automator.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.github.automator.model.GHAutomatorTask;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the g h automator task service. This utility wraps {@link com.liferay.github.automator.service.persistence.impl.GHAutomatorTaskPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sergio González
 * @see GHAutomatorTaskPersistence
 * @see com.liferay.github.automator.service.persistence.impl.GHAutomatorTaskPersistenceImpl
 * @generated
 */
@ProviderType
public class GHAutomatorTaskUtil {
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
	public static void clearCache(GHAutomatorTask ghAutomatorTask) {
		getPersistence().clearCache(ghAutomatorTask);
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
	public static List<GHAutomatorTask> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GHAutomatorTask> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GHAutomatorTask> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<GHAutomatorTask> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static GHAutomatorTask update(GHAutomatorTask ghAutomatorTask) {
		return getPersistence().update(ghAutomatorTask);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static GHAutomatorTask update(GHAutomatorTask ghAutomatorTask,
		ServiceContext serviceContext) {
		return getPersistence().update(ghAutomatorTask, serviceContext);
	}

	/**
	* Returns all the g h automator tasks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching g h automator tasks
	*/
	public static List<GHAutomatorTask> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<GHAutomatorTask> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<GHAutomatorTask> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<GHAutomatorTask> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<GHAutomatorTask> findByUuid(java.lang.String uuid,
		int start, int end,
		OrderByComparator<GHAutomatorTask> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first g h automator task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g h automator task
	* @throws NoSuchGHAutomatorTaskException if a matching g h automator task could not be found
	*/
	public static GHAutomatorTask findByUuid_First(java.lang.String uuid,
		OrderByComparator<GHAutomatorTask> orderByComparator)
		throws com.liferay.github.automator.exception.NoSuchGHAutomatorTaskException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first g h automator task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	*/
	public static GHAutomatorTask fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<GHAutomatorTask> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last g h automator task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g h automator task
	* @throws NoSuchGHAutomatorTaskException if a matching g h automator task could not be found
	*/
	public static GHAutomatorTask findByUuid_Last(java.lang.String uuid,
		OrderByComparator<GHAutomatorTask> orderByComparator)
		throws com.liferay.github.automator.exception.NoSuchGHAutomatorTaskException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last g h automator task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	*/
	public static GHAutomatorTask fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<GHAutomatorTask> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static GHAutomatorTask[] findByUuid_PrevAndNext(
		long ghAutomatorTaskId, java.lang.String uuid,
		OrderByComparator<GHAutomatorTask> orderByComparator)
		throws com.liferay.github.automator.exception.NoSuchGHAutomatorTaskException {
		return getPersistence()
				   .findByUuid_PrevAndNext(ghAutomatorTaskId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the g h automator tasks where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of g h automator tasks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching g h automator tasks
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the g h automator tasks where ghRepositoryId = &#63;.
	*
	* @param ghRepositoryId the gh repository ID
	* @return the matching g h automator tasks
	*/
	public static List<GHAutomatorTask> findByGHRepositoryId(
		java.lang.String ghRepositoryId) {
		return getPersistence().findByGHRepositoryId(ghRepositoryId);
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
	public static List<GHAutomatorTask> findByGHRepositoryId(
		java.lang.String ghRepositoryId, int start, int end) {
		return getPersistence().findByGHRepositoryId(ghRepositoryId, start, end);
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
	public static List<GHAutomatorTask> findByGHRepositoryId(
		java.lang.String ghRepositoryId, int start, int end,
		OrderByComparator<GHAutomatorTask> orderByComparator) {
		return getPersistence()
				   .findByGHRepositoryId(ghRepositoryId, start, end,
			orderByComparator);
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
	public static List<GHAutomatorTask> findByGHRepositoryId(
		java.lang.String ghRepositoryId, int start, int end,
		OrderByComparator<GHAutomatorTask> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGHRepositoryId(ghRepositoryId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first g h automator task in the ordered set where ghRepositoryId = &#63;.
	*
	* @param ghRepositoryId the gh repository ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g h automator task
	* @throws NoSuchGHAutomatorTaskException if a matching g h automator task could not be found
	*/
	public static GHAutomatorTask findByGHRepositoryId_First(
		java.lang.String ghRepositoryId,
		OrderByComparator<GHAutomatorTask> orderByComparator)
		throws com.liferay.github.automator.exception.NoSuchGHAutomatorTaskException {
		return getPersistence()
				   .findByGHRepositoryId_First(ghRepositoryId, orderByComparator);
	}

	/**
	* Returns the first g h automator task in the ordered set where ghRepositoryId = &#63;.
	*
	* @param ghRepositoryId the gh repository ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	*/
	public static GHAutomatorTask fetchByGHRepositoryId_First(
		java.lang.String ghRepositoryId,
		OrderByComparator<GHAutomatorTask> orderByComparator) {
		return getPersistence()
				   .fetchByGHRepositoryId_First(ghRepositoryId,
			orderByComparator);
	}

	/**
	* Returns the last g h automator task in the ordered set where ghRepositoryId = &#63;.
	*
	* @param ghRepositoryId the gh repository ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g h automator task
	* @throws NoSuchGHAutomatorTaskException if a matching g h automator task could not be found
	*/
	public static GHAutomatorTask findByGHRepositoryId_Last(
		java.lang.String ghRepositoryId,
		OrderByComparator<GHAutomatorTask> orderByComparator)
		throws com.liferay.github.automator.exception.NoSuchGHAutomatorTaskException {
		return getPersistence()
				   .findByGHRepositoryId_Last(ghRepositoryId, orderByComparator);
	}

	/**
	* Returns the last g h automator task in the ordered set where ghRepositoryId = &#63;.
	*
	* @param ghRepositoryId the gh repository ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	*/
	public static GHAutomatorTask fetchByGHRepositoryId_Last(
		java.lang.String ghRepositoryId,
		OrderByComparator<GHAutomatorTask> orderByComparator) {
		return getPersistence()
				   .fetchByGHRepositoryId_Last(ghRepositoryId, orderByComparator);
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
	public static GHAutomatorTask[] findByGHRepositoryId_PrevAndNext(
		long ghAutomatorTaskId, java.lang.String ghRepositoryId,
		OrderByComparator<GHAutomatorTask> orderByComparator)
		throws com.liferay.github.automator.exception.NoSuchGHAutomatorTaskException {
		return getPersistence()
				   .findByGHRepositoryId_PrevAndNext(ghAutomatorTaskId,
			ghRepositoryId, orderByComparator);
	}

	/**
	* Removes all the g h automator tasks where ghRepositoryId = &#63; from the database.
	*
	* @param ghRepositoryId the gh repository ID
	*/
	public static void removeByGHRepositoryId(java.lang.String ghRepositoryId) {
		getPersistence().removeByGHRepositoryId(ghRepositoryId);
	}

	/**
	* Returns the number of g h automator tasks where ghRepositoryId = &#63;.
	*
	* @param ghRepositoryId the gh repository ID
	* @return the number of matching g h automator tasks
	*/
	public static int countByGHRepositoryId(java.lang.String ghRepositoryId) {
		return getPersistence().countByGHRepositoryId(ghRepositoryId);
	}

	/**
	* Returns all the g h automator tasks where ghTaskUuid = &#63;.
	*
	* @param ghTaskUuid the gh task uuid
	* @return the matching g h automator tasks
	*/
	public static List<GHAutomatorTask> findByGHTaskUuid(
		java.lang.String ghTaskUuid) {
		return getPersistence().findByGHTaskUuid(ghTaskUuid);
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
	public static List<GHAutomatorTask> findByGHTaskUuid(
		java.lang.String ghTaskUuid, int start, int end) {
		return getPersistence().findByGHTaskUuid(ghTaskUuid, start, end);
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
	public static List<GHAutomatorTask> findByGHTaskUuid(
		java.lang.String ghTaskUuid, int start, int end,
		OrderByComparator<GHAutomatorTask> orderByComparator) {
		return getPersistence()
				   .findByGHTaskUuid(ghTaskUuid, start, end, orderByComparator);
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
	public static List<GHAutomatorTask> findByGHTaskUuid(
		java.lang.String ghTaskUuid, int start, int end,
		OrderByComparator<GHAutomatorTask> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGHTaskUuid(ghTaskUuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first g h automator task in the ordered set where ghTaskUuid = &#63;.
	*
	* @param ghTaskUuid the gh task uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g h automator task
	* @throws NoSuchGHAutomatorTaskException if a matching g h automator task could not be found
	*/
	public static GHAutomatorTask findByGHTaskUuid_First(
		java.lang.String ghTaskUuid,
		OrderByComparator<GHAutomatorTask> orderByComparator)
		throws com.liferay.github.automator.exception.NoSuchGHAutomatorTaskException {
		return getPersistence()
				   .findByGHTaskUuid_First(ghTaskUuid, orderByComparator);
	}

	/**
	* Returns the first g h automator task in the ordered set where ghTaskUuid = &#63;.
	*
	* @param ghTaskUuid the gh task uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	*/
	public static GHAutomatorTask fetchByGHTaskUuid_First(
		java.lang.String ghTaskUuid,
		OrderByComparator<GHAutomatorTask> orderByComparator) {
		return getPersistence()
				   .fetchByGHTaskUuid_First(ghTaskUuid, orderByComparator);
	}

	/**
	* Returns the last g h automator task in the ordered set where ghTaskUuid = &#63;.
	*
	* @param ghTaskUuid the gh task uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g h automator task
	* @throws NoSuchGHAutomatorTaskException if a matching g h automator task could not be found
	*/
	public static GHAutomatorTask findByGHTaskUuid_Last(
		java.lang.String ghTaskUuid,
		OrderByComparator<GHAutomatorTask> orderByComparator)
		throws com.liferay.github.automator.exception.NoSuchGHAutomatorTaskException {
		return getPersistence()
				   .findByGHTaskUuid_Last(ghTaskUuid, orderByComparator);
	}

	/**
	* Returns the last g h automator task in the ordered set where ghTaskUuid = &#63;.
	*
	* @param ghTaskUuid the gh task uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	*/
	public static GHAutomatorTask fetchByGHTaskUuid_Last(
		java.lang.String ghTaskUuid,
		OrderByComparator<GHAutomatorTask> orderByComparator) {
		return getPersistence()
				   .fetchByGHTaskUuid_Last(ghTaskUuid, orderByComparator);
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
	public static GHAutomatorTask[] findByGHTaskUuid_PrevAndNext(
		long ghAutomatorTaskId, java.lang.String ghTaskUuid,
		OrderByComparator<GHAutomatorTask> orderByComparator)
		throws com.liferay.github.automator.exception.NoSuchGHAutomatorTaskException {
		return getPersistence()
				   .findByGHTaskUuid_PrevAndNext(ghAutomatorTaskId, ghTaskUuid,
			orderByComparator);
	}

	/**
	* Removes all the g h automator tasks where ghTaskUuid = &#63; from the database.
	*
	* @param ghTaskUuid the gh task uuid
	*/
	public static void removeByGHTaskUuid(java.lang.String ghTaskUuid) {
		getPersistence().removeByGHTaskUuid(ghTaskUuid);
	}

	/**
	* Returns the number of g h automator tasks where ghTaskUuid = &#63;.
	*
	* @param ghTaskUuid the gh task uuid
	* @return the number of matching g h automator tasks
	*/
	public static int countByGHTaskUuid(java.lang.String ghTaskUuid) {
		return getPersistence().countByGHTaskUuid(ghTaskUuid);
	}

	/**
	* Returns the g h automator task where ghRepositoryId = &#63; and ghTaskUuid = &#63; or throws a {@link NoSuchGHAutomatorTaskException} if it could not be found.
	*
	* @param ghRepositoryId the gh repository ID
	* @param ghTaskUuid the gh task uuid
	* @return the matching g h automator task
	* @throws NoSuchGHAutomatorTaskException if a matching g h automator task could not be found
	*/
	public static GHAutomatorTask findByGHRID_GHTUUID(
		java.lang.String ghRepositoryId, java.lang.String ghTaskUuid)
		throws com.liferay.github.automator.exception.NoSuchGHAutomatorTaskException {
		return getPersistence().findByGHRID_GHTUUID(ghRepositoryId, ghTaskUuid);
	}

	/**
	* Returns the g h automator task where ghRepositoryId = &#63; and ghTaskUuid = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ghRepositoryId the gh repository ID
	* @param ghTaskUuid the gh task uuid
	* @return the matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	*/
	public static GHAutomatorTask fetchByGHRID_GHTUUID(
		java.lang.String ghRepositoryId, java.lang.String ghTaskUuid) {
		return getPersistence().fetchByGHRID_GHTUUID(ghRepositoryId, ghTaskUuid);
	}

	/**
	* Returns the g h automator task where ghRepositoryId = &#63; and ghTaskUuid = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ghRepositoryId the gh repository ID
	* @param ghTaskUuid the gh task uuid
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	*/
	public static GHAutomatorTask fetchByGHRID_GHTUUID(
		java.lang.String ghRepositoryId, java.lang.String ghTaskUuid,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByGHRID_GHTUUID(ghRepositoryId, ghTaskUuid,
			retrieveFromCache);
	}

	/**
	* Removes the g h automator task where ghRepositoryId = &#63; and ghTaskUuid = &#63; from the database.
	*
	* @param ghRepositoryId the gh repository ID
	* @param ghTaskUuid the gh task uuid
	* @return the g h automator task that was removed
	*/
	public static GHAutomatorTask removeByGHRID_GHTUUID(
		java.lang.String ghRepositoryId, java.lang.String ghTaskUuid)
		throws com.liferay.github.automator.exception.NoSuchGHAutomatorTaskException {
		return getPersistence().removeByGHRID_GHTUUID(ghRepositoryId, ghTaskUuid);
	}

	/**
	* Returns the number of g h automator tasks where ghRepositoryId = &#63; and ghTaskUuid = &#63;.
	*
	* @param ghRepositoryId the gh repository ID
	* @param ghTaskUuid the gh task uuid
	* @return the number of matching g h automator tasks
	*/
	public static int countByGHRID_GHTUUID(java.lang.String ghRepositoryId,
		java.lang.String ghTaskUuid) {
		return getPersistence().countByGHRID_GHTUUID(ghRepositoryId, ghTaskUuid);
	}

	/**
	* Returns all the g h automator tasks where ghRepositoryId = &#63; and enabled = &#63;.
	*
	* @param ghRepositoryId the gh repository ID
	* @param enabled the enabled
	* @return the matching g h automator tasks
	*/
	public static List<GHAutomatorTask> findByGHRID_E(
		java.lang.String ghRepositoryId, boolean enabled) {
		return getPersistence().findByGHRID_E(ghRepositoryId, enabled);
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
	public static List<GHAutomatorTask> findByGHRID_E(
		java.lang.String ghRepositoryId, boolean enabled, int start, int end) {
		return getPersistence()
				   .findByGHRID_E(ghRepositoryId, enabled, start, end);
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
	public static List<GHAutomatorTask> findByGHRID_E(
		java.lang.String ghRepositoryId, boolean enabled, int start, int end,
		OrderByComparator<GHAutomatorTask> orderByComparator) {
		return getPersistence()
				   .findByGHRID_E(ghRepositoryId, enabled, start, end,
			orderByComparator);
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
	public static List<GHAutomatorTask> findByGHRID_E(
		java.lang.String ghRepositoryId, boolean enabled, int start, int end,
		OrderByComparator<GHAutomatorTask> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGHRID_E(ghRepositoryId, enabled, start, end,
			orderByComparator, retrieveFromCache);
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
	public static GHAutomatorTask findByGHRID_E_First(
		java.lang.String ghRepositoryId, boolean enabled,
		OrderByComparator<GHAutomatorTask> orderByComparator)
		throws com.liferay.github.automator.exception.NoSuchGHAutomatorTaskException {
		return getPersistence()
				   .findByGHRID_E_First(ghRepositoryId, enabled,
			orderByComparator);
	}

	/**
	* Returns the first g h automator task in the ordered set where ghRepositoryId = &#63; and enabled = &#63;.
	*
	* @param ghRepositoryId the gh repository ID
	* @param enabled the enabled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	*/
	public static GHAutomatorTask fetchByGHRID_E_First(
		java.lang.String ghRepositoryId, boolean enabled,
		OrderByComparator<GHAutomatorTask> orderByComparator) {
		return getPersistence()
				   .fetchByGHRID_E_First(ghRepositoryId, enabled,
			orderByComparator);
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
	public static GHAutomatorTask findByGHRID_E_Last(
		java.lang.String ghRepositoryId, boolean enabled,
		OrderByComparator<GHAutomatorTask> orderByComparator)
		throws com.liferay.github.automator.exception.NoSuchGHAutomatorTaskException {
		return getPersistence()
				   .findByGHRID_E_Last(ghRepositoryId, enabled,
			orderByComparator);
	}

	/**
	* Returns the last g h automator task in the ordered set where ghRepositoryId = &#63; and enabled = &#63;.
	*
	* @param ghRepositoryId the gh repository ID
	* @param enabled the enabled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	*/
	public static GHAutomatorTask fetchByGHRID_E_Last(
		java.lang.String ghRepositoryId, boolean enabled,
		OrderByComparator<GHAutomatorTask> orderByComparator) {
		return getPersistence()
				   .fetchByGHRID_E_Last(ghRepositoryId, enabled,
			orderByComparator);
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
	public static GHAutomatorTask[] findByGHRID_E_PrevAndNext(
		long ghAutomatorTaskId, java.lang.String ghRepositoryId,
		boolean enabled, OrderByComparator<GHAutomatorTask> orderByComparator)
		throws com.liferay.github.automator.exception.NoSuchGHAutomatorTaskException {
		return getPersistence()
				   .findByGHRID_E_PrevAndNext(ghAutomatorTaskId,
			ghRepositoryId, enabled, orderByComparator);
	}

	/**
	* Removes all the g h automator tasks where ghRepositoryId = &#63; and enabled = &#63; from the database.
	*
	* @param ghRepositoryId the gh repository ID
	* @param enabled the enabled
	*/
	public static void removeByGHRID_E(java.lang.String ghRepositoryId,
		boolean enabled) {
		getPersistence().removeByGHRID_E(ghRepositoryId, enabled);
	}

	/**
	* Returns the number of g h automator tasks where ghRepositoryId = &#63; and enabled = &#63;.
	*
	* @param ghRepositoryId the gh repository ID
	* @param enabled the enabled
	* @return the number of matching g h automator tasks
	*/
	public static int countByGHRID_E(java.lang.String ghRepositoryId,
		boolean enabled) {
		return getPersistence().countByGHRID_E(ghRepositoryId, enabled);
	}

	/**
	* Returns all the g h automator tasks where ghTaskUuid = &#63; and enabled = &#63;.
	*
	* @param ghTaskUuid the gh task uuid
	* @param enabled the enabled
	* @return the matching g h automator tasks
	*/
	public static List<GHAutomatorTask> findByGHTUUID_E(
		java.lang.String ghTaskUuid, boolean enabled) {
		return getPersistence().findByGHTUUID_E(ghTaskUuid, enabled);
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
	public static List<GHAutomatorTask> findByGHTUUID_E(
		java.lang.String ghTaskUuid, boolean enabled, int start, int end) {
		return getPersistence().findByGHTUUID_E(ghTaskUuid, enabled, start, end);
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
	public static List<GHAutomatorTask> findByGHTUUID_E(
		java.lang.String ghTaskUuid, boolean enabled, int start, int end,
		OrderByComparator<GHAutomatorTask> orderByComparator) {
		return getPersistence()
				   .findByGHTUUID_E(ghTaskUuid, enabled, start, end,
			orderByComparator);
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
	public static List<GHAutomatorTask> findByGHTUUID_E(
		java.lang.String ghTaskUuid, boolean enabled, int start, int end,
		OrderByComparator<GHAutomatorTask> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGHTUUID_E(ghTaskUuid, enabled, start, end,
			orderByComparator, retrieveFromCache);
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
	public static GHAutomatorTask findByGHTUUID_E_First(
		java.lang.String ghTaskUuid, boolean enabled,
		OrderByComparator<GHAutomatorTask> orderByComparator)
		throws com.liferay.github.automator.exception.NoSuchGHAutomatorTaskException {
		return getPersistence()
				   .findByGHTUUID_E_First(ghTaskUuid, enabled, orderByComparator);
	}

	/**
	* Returns the first g h automator task in the ordered set where ghTaskUuid = &#63; and enabled = &#63;.
	*
	* @param ghTaskUuid the gh task uuid
	* @param enabled the enabled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	*/
	public static GHAutomatorTask fetchByGHTUUID_E_First(
		java.lang.String ghTaskUuid, boolean enabled,
		OrderByComparator<GHAutomatorTask> orderByComparator) {
		return getPersistence()
				   .fetchByGHTUUID_E_First(ghTaskUuid, enabled,
			orderByComparator);
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
	public static GHAutomatorTask findByGHTUUID_E_Last(
		java.lang.String ghTaskUuid, boolean enabled,
		OrderByComparator<GHAutomatorTask> orderByComparator)
		throws com.liferay.github.automator.exception.NoSuchGHAutomatorTaskException {
		return getPersistence()
				   .findByGHTUUID_E_Last(ghTaskUuid, enabled, orderByComparator);
	}

	/**
	* Returns the last g h automator task in the ordered set where ghTaskUuid = &#63; and enabled = &#63;.
	*
	* @param ghTaskUuid the gh task uuid
	* @param enabled the enabled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	*/
	public static GHAutomatorTask fetchByGHTUUID_E_Last(
		java.lang.String ghTaskUuid, boolean enabled,
		OrderByComparator<GHAutomatorTask> orderByComparator) {
		return getPersistence()
				   .fetchByGHTUUID_E_Last(ghTaskUuid, enabled, orderByComparator);
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
	public static GHAutomatorTask[] findByGHTUUID_E_PrevAndNext(
		long ghAutomatorTaskId, java.lang.String ghTaskUuid, boolean enabled,
		OrderByComparator<GHAutomatorTask> orderByComparator)
		throws com.liferay.github.automator.exception.NoSuchGHAutomatorTaskException {
		return getPersistence()
				   .findByGHTUUID_E_PrevAndNext(ghAutomatorTaskId, ghTaskUuid,
			enabled, orderByComparator);
	}

	/**
	* Removes all the g h automator tasks where ghTaskUuid = &#63; and enabled = &#63; from the database.
	*
	* @param ghTaskUuid the gh task uuid
	* @param enabled the enabled
	*/
	public static void removeByGHTUUID_E(java.lang.String ghTaskUuid,
		boolean enabled) {
		getPersistence().removeByGHTUUID_E(ghTaskUuid, enabled);
	}

	/**
	* Returns the number of g h automator tasks where ghTaskUuid = &#63; and enabled = &#63;.
	*
	* @param ghTaskUuid the gh task uuid
	* @param enabled the enabled
	* @return the number of matching g h automator tasks
	*/
	public static int countByGHTUUID_E(java.lang.String ghTaskUuid,
		boolean enabled) {
		return getPersistence().countByGHTUUID_E(ghTaskUuid, enabled);
	}

	/**
	* Caches the g h automator task in the entity cache if it is enabled.
	*
	* @param ghAutomatorTask the g h automator task
	*/
	public static void cacheResult(GHAutomatorTask ghAutomatorTask) {
		getPersistence().cacheResult(ghAutomatorTask);
	}

	/**
	* Caches the g h automator tasks in the entity cache if it is enabled.
	*
	* @param ghAutomatorTasks the g h automator tasks
	*/
	public static void cacheResult(List<GHAutomatorTask> ghAutomatorTasks) {
		getPersistence().cacheResult(ghAutomatorTasks);
	}

	/**
	* Creates a new g h automator task with the primary key. Does not add the g h automator task to the database.
	*
	* @param ghAutomatorTaskId the primary key for the new g h automator task
	* @return the new g h automator task
	*/
	public static GHAutomatorTask create(long ghAutomatorTaskId) {
		return getPersistence().create(ghAutomatorTaskId);
	}

	/**
	* Removes the g h automator task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ghAutomatorTaskId the primary key of the g h automator task
	* @return the g h automator task that was removed
	* @throws NoSuchGHAutomatorTaskException if a g h automator task with the primary key could not be found
	*/
	public static GHAutomatorTask remove(long ghAutomatorTaskId)
		throws com.liferay.github.automator.exception.NoSuchGHAutomatorTaskException {
		return getPersistence().remove(ghAutomatorTaskId);
	}

	public static GHAutomatorTask updateImpl(GHAutomatorTask ghAutomatorTask) {
		return getPersistence().updateImpl(ghAutomatorTask);
	}

	/**
	* Returns the g h automator task with the primary key or throws a {@link NoSuchGHAutomatorTaskException} if it could not be found.
	*
	* @param ghAutomatorTaskId the primary key of the g h automator task
	* @return the g h automator task
	* @throws NoSuchGHAutomatorTaskException if a g h automator task with the primary key could not be found
	*/
	public static GHAutomatorTask findByPrimaryKey(long ghAutomatorTaskId)
		throws com.liferay.github.automator.exception.NoSuchGHAutomatorTaskException {
		return getPersistence().findByPrimaryKey(ghAutomatorTaskId);
	}

	/**
	* Returns the g h automator task with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ghAutomatorTaskId the primary key of the g h automator task
	* @return the g h automator task, or <code>null</code> if a g h automator task with the primary key could not be found
	*/
	public static GHAutomatorTask fetchByPrimaryKey(long ghAutomatorTaskId) {
		return getPersistence().fetchByPrimaryKey(ghAutomatorTaskId);
	}

	public static java.util.Map<java.io.Serializable, GHAutomatorTask> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the g h automator tasks.
	*
	* @return the g h automator tasks
	*/
	public static List<GHAutomatorTask> findAll() {
		return getPersistence().findAll();
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
	public static List<GHAutomatorTask> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<GHAutomatorTask> findAll(int start, int end,
		OrderByComparator<GHAutomatorTask> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<GHAutomatorTask> findAll(int start, int end,
		OrderByComparator<GHAutomatorTask> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the g h automator tasks from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of g h automator tasks.
	*
	* @return the number of g h automator tasks
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static GHAutomatorTaskPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<GHAutomatorTaskPersistence, GHAutomatorTaskPersistence> _serviceTracker =
		ServiceTrackerFactory.open(GHAutomatorTaskPersistence.class);
}