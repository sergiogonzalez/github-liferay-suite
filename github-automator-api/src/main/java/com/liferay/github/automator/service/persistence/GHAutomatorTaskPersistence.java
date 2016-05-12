package com.liferay.github.automator.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.github.automator.exception.NoSuchGHAutomatorTaskException;
import com.liferay.github.automator.model.GHAutomatorTask;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the g h automator task service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sergio González
 * @see com.liferay.github.automator.service.persistence.impl.GHAutomatorTaskPersistenceImpl
 * @see GHAutomatorTaskUtil
 * @generated
 */
@ProviderType
public interface GHAutomatorTaskPersistence extends BasePersistence<GHAutomatorTask> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GHAutomatorTaskUtil} to access the g h automator task persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the g h automator tasks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching g h automator tasks
	*/
	public java.util.List<GHAutomatorTask> findByUuid(java.lang.String uuid);

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
	public java.util.List<GHAutomatorTask> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<GHAutomatorTask> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator);

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
	public java.util.List<GHAutomatorTask> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first g h automator task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g h automator task
	* @throws NoSuchGHAutomatorTaskException if a matching g h automator task could not be found
	*/
	public GHAutomatorTask findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator)
		throws NoSuchGHAutomatorTaskException;

	/**
	* Returns the first g h automator task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	*/
	public GHAutomatorTask fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator);

	/**
	* Returns the last g h automator task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g h automator task
	* @throws NoSuchGHAutomatorTaskException if a matching g h automator task could not be found
	*/
	public GHAutomatorTask findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator)
		throws NoSuchGHAutomatorTaskException;

	/**
	* Returns the last g h automator task in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	*/
	public GHAutomatorTask fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator);

	/**
	* Returns the g h automator tasks before and after the current g h automator task in the ordered set where uuid = &#63;.
	*
	* @param ghAutomatorTaskId the primary key of the current g h automator task
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g h automator task
	* @throws NoSuchGHAutomatorTaskException if a g h automator task with the primary key could not be found
	*/
	public GHAutomatorTask[] findByUuid_PrevAndNext(long ghAutomatorTaskId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator)
		throws NoSuchGHAutomatorTaskException;

	/**
	* Removes all the g h automator tasks where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of g h automator tasks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching g h automator tasks
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns all the g h automator tasks where ghRepositoryId = &#63;.
	*
	* @param ghRepositoryId the gh repository ID
	* @return the matching g h automator tasks
	*/
	public java.util.List<GHAutomatorTask> findByGHRepositoryId(
		java.lang.String ghRepositoryId);

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
	public java.util.List<GHAutomatorTask> findByGHRepositoryId(
		java.lang.String ghRepositoryId, int start, int end);

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
	public java.util.List<GHAutomatorTask> findByGHRepositoryId(
		java.lang.String ghRepositoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator);

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
	public java.util.List<GHAutomatorTask> findByGHRepositoryId(
		java.lang.String ghRepositoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first g h automator task in the ordered set where ghRepositoryId = &#63;.
	*
	* @param ghRepositoryId the gh repository ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g h automator task
	* @throws NoSuchGHAutomatorTaskException if a matching g h automator task could not be found
	*/
	public GHAutomatorTask findByGHRepositoryId_First(
		java.lang.String ghRepositoryId,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator)
		throws NoSuchGHAutomatorTaskException;

	/**
	* Returns the first g h automator task in the ordered set where ghRepositoryId = &#63;.
	*
	* @param ghRepositoryId the gh repository ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	*/
	public GHAutomatorTask fetchByGHRepositoryId_First(
		java.lang.String ghRepositoryId,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator);

	/**
	* Returns the last g h automator task in the ordered set where ghRepositoryId = &#63;.
	*
	* @param ghRepositoryId the gh repository ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g h automator task
	* @throws NoSuchGHAutomatorTaskException if a matching g h automator task could not be found
	*/
	public GHAutomatorTask findByGHRepositoryId_Last(
		java.lang.String ghRepositoryId,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator)
		throws NoSuchGHAutomatorTaskException;

	/**
	* Returns the last g h automator task in the ordered set where ghRepositoryId = &#63;.
	*
	* @param ghRepositoryId the gh repository ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	*/
	public GHAutomatorTask fetchByGHRepositoryId_Last(
		java.lang.String ghRepositoryId,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator);

	/**
	* Returns the g h automator tasks before and after the current g h automator task in the ordered set where ghRepositoryId = &#63;.
	*
	* @param ghAutomatorTaskId the primary key of the current g h automator task
	* @param ghRepositoryId the gh repository ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g h automator task
	* @throws NoSuchGHAutomatorTaskException if a g h automator task with the primary key could not be found
	*/
	public GHAutomatorTask[] findByGHRepositoryId_PrevAndNext(
		long ghAutomatorTaskId, java.lang.String ghRepositoryId,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator)
		throws NoSuchGHAutomatorTaskException;

	/**
	* Removes all the g h automator tasks where ghRepositoryId = &#63; from the database.
	*
	* @param ghRepositoryId the gh repository ID
	*/
	public void removeByGHRepositoryId(java.lang.String ghRepositoryId);

	/**
	* Returns the number of g h automator tasks where ghRepositoryId = &#63;.
	*
	* @param ghRepositoryId the gh repository ID
	* @return the number of matching g h automator tasks
	*/
	public int countByGHRepositoryId(java.lang.String ghRepositoryId);

	/**
	* Returns all the g h automator tasks where ghTaskUuid = &#63;.
	*
	* @param ghTaskUuid the gh task uuid
	* @return the matching g h automator tasks
	*/
	public java.util.List<GHAutomatorTask> findByGHTaskUuid(
		java.lang.String ghTaskUuid);

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
	public java.util.List<GHAutomatorTask> findByGHTaskUuid(
		java.lang.String ghTaskUuid, int start, int end);

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
	public java.util.List<GHAutomatorTask> findByGHTaskUuid(
		java.lang.String ghTaskUuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator);

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
	public java.util.List<GHAutomatorTask> findByGHTaskUuid(
		java.lang.String ghTaskUuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first g h automator task in the ordered set where ghTaskUuid = &#63;.
	*
	* @param ghTaskUuid the gh task uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g h automator task
	* @throws NoSuchGHAutomatorTaskException if a matching g h automator task could not be found
	*/
	public GHAutomatorTask findByGHTaskUuid_First(java.lang.String ghTaskUuid,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator)
		throws NoSuchGHAutomatorTaskException;

	/**
	* Returns the first g h automator task in the ordered set where ghTaskUuid = &#63;.
	*
	* @param ghTaskUuid the gh task uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	*/
	public GHAutomatorTask fetchByGHTaskUuid_First(
		java.lang.String ghTaskUuid,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator);

	/**
	* Returns the last g h automator task in the ordered set where ghTaskUuid = &#63;.
	*
	* @param ghTaskUuid the gh task uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g h automator task
	* @throws NoSuchGHAutomatorTaskException if a matching g h automator task could not be found
	*/
	public GHAutomatorTask findByGHTaskUuid_Last(java.lang.String ghTaskUuid,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator)
		throws NoSuchGHAutomatorTaskException;

	/**
	* Returns the last g h automator task in the ordered set where ghTaskUuid = &#63;.
	*
	* @param ghTaskUuid the gh task uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	*/
	public GHAutomatorTask fetchByGHTaskUuid_Last(java.lang.String ghTaskUuid,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator);

	/**
	* Returns the g h automator tasks before and after the current g h automator task in the ordered set where ghTaskUuid = &#63;.
	*
	* @param ghAutomatorTaskId the primary key of the current g h automator task
	* @param ghTaskUuid the gh task uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g h automator task
	* @throws NoSuchGHAutomatorTaskException if a g h automator task with the primary key could not be found
	*/
	public GHAutomatorTask[] findByGHTaskUuid_PrevAndNext(
		long ghAutomatorTaskId, java.lang.String ghTaskUuid,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator)
		throws NoSuchGHAutomatorTaskException;

	/**
	* Removes all the g h automator tasks where ghTaskUuid = &#63; from the database.
	*
	* @param ghTaskUuid the gh task uuid
	*/
	public void removeByGHTaskUuid(java.lang.String ghTaskUuid);

	/**
	* Returns the number of g h automator tasks where ghTaskUuid = &#63;.
	*
	* @param ghTaskUuid the gh task uuid
	* @return the number of matching g h automator tasks
	*/
	public int countByGHTaskUuid(java.lang.String ghTaskUuid);

	/**
	* Returns the g h automator task where ghRepositoryId = &#63; and ghTaskUuid = &#63; or throws a {@link NoSuchGHAutomatorTaskException} if it could not be found.
	*
	* @param ghRepositoryId the gh repository ID
	* @param ghTaskUuid the gh task uuid
	* @return the matching g h automator task
	* @throws NoSuchGHAutomatorTaskException if a matching g h automator task could not be found
	*/
	public GHAutomatorTask findByGHRID_GHTUUID(
		java.lang.String ghRepositoryId, java.lang.String ghTaskUuid)
		throws NoSuchGHAutomatorTaskException;

	/**
	* Returns the g h automator task where ghRepositoryId = &#63; and ghTaskUuid = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ghRepositoryId the gh repository ID
	* @param ghTaskUuid the gh task uuid
	* @return the matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	*/
	public GHAutomatorTask fetchByGHRID_GHTUUID(
		java.lang.String ghRepositoryId, java.lang.String ghTaskUuid);

	/**
	* Returns the g h automator task where ghRepositoryId = &#63; and ghTaskUuid = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ghRepositoryId the gh repository ID
	* @param ghTaskUuid the gh task uuid
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	*/
	public GHAutomatorTask fetchByGHRID_GHTUUID(
		java.lang.String ghRepositoryId, java.lang.String ghTaskUuid,
		boolean retrieveFromCache);

	/**
	* Removes the g h automator task where ghRepositoryId = &#63; and ghTaskUuid = &#63; from the database.
	*
	* @param ghRepositoryId the gh repository ID
	* @param ghTaskUuid the gh task uuid
	* @return the g h automator task that was removed
	*/
	public GHAutomatorTask removeByGHRID_GHTUUID(
		java.lang.String ghRepositoryId, java.lang.String ghTaskUuid)
		throws NoSuchGHAutomatorTaskException;

	/**
	* Returns the number of g h automator tasks where ghRepositoryId = &#63; and ghTaskUuid = &#63;.
	*
	* @param ghRepositoryId the gh repository ID
	* @param ghTaskUuid the gh task uuid
	* @return the number of matching g h automator tasks
	*/
	public int countByGHRID_GHTUUID(java.lang.String ghRepositoryId,
		java.lang.String ghTaskUuid);

	/**
	* Returns all the g h automator tasks where ghRepositoryId = &#63; and enabled = &#63;.
	*
	* @param ghRepositoryId the gh repository ID
	* @param enabled the enabled
	* @return the matching g h automator tasks
	*/
	public java.util.List<GHAutomatorTask> findByGHRID_E(
		java.lang.String ghRepositoryId, boolean enabled);

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
	public java.util.List<GHAutomatorTask> findByGHRID_E(
		java.lang.String ghRepositoryId, boolean enabled, int start, int end);

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
	public java.util.List<GHAutomatorTask> findByGHRID_E(
		java.lang.String ghRepositoryId, boolean enabled, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator);

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
	public java.util.List<GHAutomatorTask> findByGHRID_E(
		java.lang.String ghRepositoryId, boolean enabled, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first g h automator task in the ordered set where ghRepositoryId = &#63; and enabled = &#63;.
	*
	* @param ghRepositoryId the gh repository ID
	* @param enabled the enabled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g h automator task
	* @throws NoSuchGHAutomatorTaskException if a matching g h automator task could not be found
	*/
	public GHAutomatorTask findByGHRID_E_First(
		java.lang.String ghRepositoryId, boolean enabled,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator)
		throws NoSuchGHAutomatorTaskException;

	/**
	* Returns the first g h automator task in the ordered set where ghRepositoryId = &#63; and enabled = &#63;.
	*
	* @param ghRepositoryId the gh repository ID
	* @param enabled the enabled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	*/
	public GHAutomatorTask fetchByGHRID_E_First(
		java.lang.String ghRepositoryId, boolean enabled,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator);

	/**
	* Returns the last g h automator task in the ordered set where ghRepositoryId = &#63; and enabled = &#63;.
	*
	* @param ghRepositoryId the gh repository ID
	* @param enabled the enabled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g h automator task
	* @throws NoSuchGHAutomatorTaskException if a matching g h automator task could not be found
	*/
	public GHAutomatorTask findByGHRID_E_Last(java.lang.String ghRepositoryId,
		boolean enabled,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator)
		throws NoSuchGHAutomatorTaskException;

	/**
	* Returns the last g h automator task in the ordered set where ghRepositoryId = &#63; and enabled = &#63;.
	*
	* @param ghRepositoryId the gh repository ID
	* @param enabled the enabled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	*/
	public GHAutomatorTask fetchByGHRID_E_Last(
		java.lang.String ghRepositoryId, boolean enabled,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator);

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
	public GHAutomatorTask[] findByGHRID_E_PrevAndNext(long ghAutomatorTaskId,
		java.lang.String ghRepositoryId, boolean enabled,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator)
		throws NoSuchGHAutomatorTaskException;

	/**
	* Removes all the g h automator tasks where ghRepositoryId = &#63; and enabled = &#63; from the database.
	*
	* @param ghRepositoryId the gh repository ID
	* @param enabled the enabled
	*/
	public void removeByGHRID_E(java.lang.String ghRepositoryId, boolean enabled);

	/**
	* Returns the number of g h automator tasks where ghRepositoryId = &#63; and enabled = &#63;.
	*
	* @param ghRepositoryId the gh repository ID
	* @param enabled the enabled
	* @return the number of matching g h automator tasks
	*/
	public int countByGHRID_E(java.lang.String ghRepositoryId, boolean enabled);

	/**
	* Returns all the g h automator tasks where ghTaskUuid = &#63; and enabled = &#63;.
	*
	* @param ghTaskUuid the gh task uuid
	* @param enabled the enabled
	* @return the matching g h automator tasks
	*/
	public java.util.List<GHAutomatorTask> findByGHTUUID_E(
		java.lang.String ghTaskUuid, boolean enabled);

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
	public java.util.List<GHAutomatorTask> findByGHTUUID_E(
		java.lang.String ghTaskUuid, boolean enabled, int start, int end);

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
	public java.util.List<GHAutomatorTask> findByGHTUUID_E(
		java.lang.String ghTaskUuid, boolean enabled, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator);

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
	public java.util.List<GHAutomatorTask> findByGHTUUID_E(
		java.lang.String ghTaskUuid, boolean enabled, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first g h automator task in the ordered set where ghTaskUuid = &#63; and enabled = &#63;.
	*
	* @param ghTaskUuid the gh task uuid
	* @param enabled the enabled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g h automator task
	* @throws NoSuchGHAutomatorTaskException if a matching g h automator task could not be found
	*/
	public GHAutomatorTask findByGHTUUID_E_First(java.lang.String ghTaskUuid,
		boolean enabled,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator)
		throws NoSuchGHAutomatorTaskException;

	/**
	* Returns the first g h automator task in the ordered set where ghTaskUuid = &#63; and enabled = &#63;.
	*
	* @param ghTaskUuid the gh task uuid
	* @param enabled the enabled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	*/
	public GHAutomatorTask fetchByGHTUUID_E_First(java.lang.String ghTaskUuid,
		boolean enabled,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator);

	/**
	* Returns the last g h automator task in the ordered set where ghTaskUuid = &#63; and enabled = &#63;.
	*
	* @param ghTaskUuid the gh task uuid
	* @param enabled the enabled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g h automator task
	* @throws NoSuchGHAutomatorTaskException if a matching g h automator task could not be found
	*/
	public GHAutomatorTask findByGHTUUID_E_Last(java.lang.String ghTaskUuid,
		boolean enabled,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator)
		throws NoSuchGHAutomatorTaskException;

	/**
	* Returns the last g h automator task in the ordered set where ghTaskUuid = &#63; and enabled = &#63;.
	*
	* @param ghTaskUuid the gh task uuid
	* @param enabled the enabled
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g h automator task, or <code>null</code> if a matching g h automator task could not be found
	*/
	public GHAutomatorTask fetchByGHTUUID_E_Last(java.lang.String ghTaskUuid,
		boolean enabled,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator);

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
	public GHAutomatorTask[] findByGHTUUID_E_PrevAndNext(
		long ghAutomatorTaskId, java.lang.String ghTaskUuid, boolean enabled,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator)
		throws NoSuchGHAutomatorTaskException;

	/**
	* Removes all the g h automator tasks where ghTaskUuid = &#63; and enabled = &#63; from the database.
	*
	* @param ghTaskUuid the gh task uuid
	* @param enabled the enabled
	*/
	public void removeByGHTUUID_E(java.lang.String ghTaskUuid, boolean enabled);

	/**
	* Returns the number of g h automator tasks where ghTaskUuid = &#63; and enabled = &#63;.
	*
	* @param ghTaskUuid the gh task uuid
	* @param enabled the enabled
	* @return the number of matching g h automator tasks
	*/
	public int countByGHTUUID_E(java.lang.String ghTaskUuid, boolean enabled);

	/**
	* Caches the g h automator task in the entity cache if it is enabled.
	*
	* @param ghAutomatorTask the g h automator task
	*/
	public void cacheResult(GHAutomatorTask ghAutomatorTask);

	/**
	* Caches the g h automator tasks in the entity cache if it is enabled.
	*
	* @param ghAutomatorTasks the g h automator tasks
	*/
	public void cacheResult(java.util.List<GHAutomatorTask> ghAutomatorTasks);

	/**
	* Creates a new g h automator task with the primary key. Does not add the g h automator task to the database.
	*
	* @param ghAutomatorTaskId the primary key for the new g h automator task
	* @return the new g h automator task
	*/
	public GHAutomatorTask create(long ghAutomatorTaskId);

	/**
	* Removes the g h automator task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ghAutomatorTaskId the primary key of the g h automator task
	* @return the g h automator task that was removed
	* @throws NoSuchGHAutomatorTaskException if a g h automator task with the primary key could not be found
	*/
	public GHAutomatorTask remove(long ghAutomatorTaskId)
		throws NoSuchGHAutomatorTaskException;

	public GHAutomatorTask updateImpl(GHAutomatorTask ghAutomatorTask);

	/**
	* Returns the g h automator task with the primary key or throws a {@link NoSuchGHAutomatorTaskException} if it could not be found.
	*
	* @param ghAutomatorTaskId the primary key of the g h automator task
	* @return the g h automator task
	* @throws NoSuchGHAutomatorTaskException if a g h automator task with the primary key could not be found
	*/
	public GHAutomatorTask findByPrimaryKey(long ghAutomatorTaskId)
		throws NoSuchGHAutomatorTaskException;

	/**
	* Returns the g h automator task with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ghAutomatorTaskId the primary key of the g h automator task
	* @return the g h automator task, or <code>null</code> if a g h automator task with the primary key could not be found
	*/
	public GHAutomatorTask fetchByPrimaryKey(long ghAutomatorTaskId);

	@Override
	public java.util.Map<java.io.Serializable, GHAutomatorTask> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the g h automator tasks.
	*
	* @return the g h automator tasks
	*/
	public java.util.List<GHAutomatorTask> findAll();

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
	public java.util.List<GHAutomatorTask> findAll(int start, int end);

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
	public java.util.List<GHAutomatorTask> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator);

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
	public java.util.List<GHAutomatorTask> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GHAutomatorTask> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the g h automator tasks from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of g h automator tasks.
	*
	* @return the number of g h automator tasks
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}