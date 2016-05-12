package com.liferay.github.automator.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.github.automator.model.GHAutomatorRepository;

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
 * Provides the local service interface for GHAutomatorRepository. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Sergio González
 * @see GHAutomatorRepositoryLocalServiceUtil
 * @see com.liferay.github.automator.service.base.GHAutomatorRepositoryLocalServiceBaseImpl
 * @see com.liferay.github.automator.service.impl.GHAutomatorRepositoryLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface GHAutomatorRepositoryLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GHAutomatorRepositoryLocalServiceUtil} to access the g h automator repository local service. Add custom service methods to {@link com.liferay.github.automator.service.impl.GHAutomatorRepositoryLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isGHAutomatorRepositoryEnabled(java.lang.String repositoryId);

	/**
	* Adds the g h automator repository to the database. Also notifies the appropriate model listeners.
	*
	* @param ghAutomatorRepository the g h automator repository
	* @return the g h automator repository that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public GHAutomatorRepository addGHAutomatorRepository(
		GHAutomatorRepository ghAutomatorRepository);

	/**
	* Creates a new g h automator repository with the primary key. Does not add the g h automator repository to the database.
	*
	* @param ghAutomatorRepositoryId the primary key for the new g h automator repository
	* @return the new g h automator repository
	*/
	public GHAutomatorRepository createGHAutomatorRepository(
		long ghAutomatorRepositoryId);

	/**
	* Deletes the g h automator repository from the database. Also notifies the appropriate model listeners.
	*
	* @param ghAutomatorRepository the g h automator repository
	* @return the g h automator repository that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public GHAutomatorRepository deleteGHAutomatorRepository(
		GHAutomatorRepository ghAutomatorRepository);

	/**
	* Deletes the g h automator repository with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ghAutomatorRepositoryId the primary key of the g h automator repository
	* @return the g h automator repository that was removed
	* @throws PortalException if a g h automator repository with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public GHAutomatorRepository deleteGHAutomatorRepository(
		long ghAutomatorRepositoryId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public GHAutomatorRepository fetchGHAutomatorRepository(
		long ghAutomatorRepositoryId);

	/**
	* Returns the g h automator repository with the primary key.
	*
	* @param ghAutomatorRepositoryId the primary key of the g h automator repository
	* @return the g h automator repository
	* @throws PortalException if a g h automator repository with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public GHAutomatorRepository getGHAutomatorRepository(
		long ghAutomatorRepositoryId) throws PortalException;

	/**
	* Updates the g h automator repository in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ghAutomatorRepository the g h automator repository
	* @return the g h automator repository that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public GHAutomatorRepository updateGHAutomatorRepository(
		GHAutomatorRepository ghAutomatorRepository);

	public GHAutomatorRepository updateGHAutomatorRepository(long userId,
		java.lang.String repositoryId, boolean enabled);

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
	* Returns the number of g h automator repositories.
	*
	* @return the number of g h automator repositories
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getGHAutomatorRepositoriesCount();

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.github.automator.model.impl.GHAutomatorRepositoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.github.automator.model.impl.GHAutomatorRepositoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the g h automator repositories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.github.automator.model.impl.GHAutomatorRepositoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g h automator repositories
	* @param end the upper bound of the range of g h automator repositories (not inclusive)
	* @return the range of g h automator repositories
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<GHAutomatorRepository> getGHAutomatorRepositories(int start,
		int end);

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