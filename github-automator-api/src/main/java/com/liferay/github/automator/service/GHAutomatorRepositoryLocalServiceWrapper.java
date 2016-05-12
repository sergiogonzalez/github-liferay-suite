package com.liferay.github.automator.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GHAutomatorRepositoryLocalService}.
 *
 * @author Sergio González
 * @see GHAutomatorRepositoryLocalService
 * @generated
 */
@ProviderType
public class GHAutomatorRepositoryLocalServiceWrapper
	implements GHAutomatorRepositoryLocalService,
		ServiceWrapper<GHAutomatorRepositoryLocalService> {
	public GHAutomatorRepositoryLocalServiceWrapper(
		GHAutomatorRepositoryLocalService ghAutomatorRepositoryLocalService) {
		_ghAutomatorRepositoryLocalService = ghAutomatorRepositoryLocalService;
	}

	@Override
	public boolean isGHAutomatorRepositoryEnabled(java.lang.String repositoryId) {
		return _ghAutomatorRepositoryLocalService.isGHAutomatorRepositoryEnabled(repositoryId);
	}

	/**
	* Adds the g h automator repository to the database. Also notifies the appropriate model listeners.
	*
	* @param ghAutomatorRepository the g h automator repository
	* @return the g h automator repository that was added
	*/
	@Override
	public com.liferay.github.automator.model.GHAutomatorRepository addGHAutomatorRepository(
		com.liferay.github.automator.model.GHAutomatorRepository ghAutomatorRepository) {
		return _ghAutomatorRepositoryLocalService.addGHAutomatorRepository(ghAutomatorRepository);
	}

	/**
	* Creates a new g h automator repository with the primary key. Does not add the g h automator repository to the database.
	*
	* @param ghAutomatorRepositoryId the primary key for the new g h automator repository
	* @return the new g h automator repository
	*/
	@Override
	public com.liferay.github.automator.model.GHAutomatorRepository createGHAutomatorRepository(
		long ghAutomatorRepositoryId) {
		return _ghAutomatorRepositoryLocalService.createGHAutomatorRepository(ghAutomatorRepositoryId);
	}

	/**
	* Deletes the g h automator repository from the database. Also notifies the appropriate model listeners.
	*
	* @param ghAutomatorRepository the g h automator repository
	* @return the g h automator repository that was removed
	*/
	@Override
	public com.liferay.github.automator.model.GHAutomatorRepository deleteGHAutomatorRepository(
		com.liferay.github.automator.model.GHAutomatorRepository ghAutomatorRepository) {
		return _ghAutomatorRepositoryLocalService.deleteGHAutomatorRepository(ghAutomatorRepository);
	}

	/**
	* Deletes the g h automator repository with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ghAutomatorRepositoryId the primary key of the g h automator repository
	* @return the g h automator repository that was removed
	* @throws PortalException if a g h automator repository with the primary key could not be found
	*/
	@Override
	public com.liferay.github.automator.model.GHAutomatorRepository deleteGHAutomatorRepository(
		long ghAutomatorRepositoryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ghAutomatorRepositoryLocalService.deleteGHAutomatorRepository(ghAutomatorRepositoryId);
	}

	@Override
	public com.liferay.github.automator.model.GHAutomatorRepository fetchGHAutomatorRepository(
		long ghAutomatorRepositoryId) {
		return _ghAutomatorRepositoryLocalService.fetchGHAutomatorRepository(ghAutomatorRepositoryId);
	}

	/**
	* Returns the g h automator repository with the primary key.
	*
	* @param ghAutomatorRepositoryId the primary key of the g h automator repository
	* @return the g h automator repository
	* @throws PortalException if a g h automator repository with the primary key could not be found
	*/
	@Override
	public com.liferay.github.automator.model.GHAutomatorRepository getGHAutomatorRepository(
		long ghAutomatorRepositoryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ghAutomatorRepositoryLocalService.getGHAutomatorRepository(ghAutomatorRepositoryId);
	}

	/**
	* Updates the g h automator repository in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ghAutomatorRepository the g h automator repository
	* @return the g h automator repository that was updated
	*/
	@Override
	public com.liferay.github.automator.model.GHAutomatorRepository updateGHAutomatorRepository(
		com.liferay.github.automator.model.GHAutomatorRepository ghAutomatorRepository) {
		return _ghAutomatorRepositoryLocalService.updateGHAutomatorRepository(ghAutomatorRepository);
	}

	@Override
	public com.liferay.github.automator.model.GHAutomatorRepository updateGHAutomatorRepository(
		long userId, java.lang.String repositoryId, boolean enabled) {
		return _ghAutomatorRepositoryLocalService.updateGHAutomatorRepository(userId,
			repositoryId, enabled);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _ghAutomatorRepositoryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ghAutomatorRepositoryLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _ghAutomatorRepositoryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ghAutomatorRepositoryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _ghAutomatorRepositoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of g h automator repositories.
	*
	* @return the number of g h automator repositories
	*/
	@Override
	public int getGHAutomatorRepositoriesCount() {
		return _ghAutomatorRepositoryLocalService.getGHAutomatorRepositoriesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _ghAutomatorRepositoryLocalService.getOSGiServiceIdentifier();
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
		return _ghAutomatorRepositoryLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _ghAutomatorRepositoryLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _ghAutomatorRepositoryLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

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
	@Override
	public java.util.List<com.liferay.github.automator.model.GHAutomatorRepository> getGHAutomatorRepositories(
		int start, int end) {
		return _ghAutomatorRepositoryLocalService.getGHAutomatorRepositories(start,
			end);
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
		return _ghAutomatorRepositoryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _ghAutomatorRepositoryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public GHAutomatorRepositoryLocalService getWrappedService() {
		return _ghAutomatorRepositoryLocalService;
	}

	@Override
	public void setWrappedService(
		GHAutomatorRepositoryLocalService ghAutomatorRepositoryLocalService) {
		_ghAutomatorRepositoryLocalService = ghAutomatorRepositoryLocalService;
	}

	private GHAutomatorRepositoryLocalService _ghAutomatorRepositoryLocalService;
}