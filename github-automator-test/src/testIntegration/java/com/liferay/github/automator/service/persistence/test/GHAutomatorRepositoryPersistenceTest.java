package com.liferay.github.automator.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.github.automator.exception.NoSuchGHAutomatorRepositoryException;
import com.liferay.github.automator.model.GHAutomatorRepository;
import com.liferay.github.automator.service.GHAutomatorRepositoryLocalServiceUtil;
import com.liferay.github.automator.service.persistence.GHAutomatorRepositoryPersistence;
import com.liferay.github.automator.service.persistence.GHAutomatorRepositoryUtil;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.TransactionalTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import org.junit.runner.RunWith;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class GHAutomatorRepositoryPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = GHAutomatorRepositoryUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<GHAutomatorRepository> iterator = _ghAutomatorRepositories.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		GHAutomatorRepository ghAutomatorRepository = _persistence.create(pk);

		Assert.assertNotNull(ghAutomatorRepository);

		Assert.assertEquals(ghAutomatorRepository.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		GHAutomatorRepository newGHAutomatorRepository = addGHAutomatorRepository();

		_persistence.remove(newGHAutomatorRepository);

		GHAutomatorRepository existingGHAutomatorRepository = _persistence.fetchByPrimaryKey(newGHAutomatorRepository.getPrimaryKey());

		Assert.assertNull(existingGHAutomatorRepository);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addGHAutomatorRepository();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		GHAutomatorRepository newGHAutomatorRepository = _persistence.create(pk);

		newGHAutomatorRepository.setUuid(RandomTestUtil.randomString());

		newGHAutomatorRepository.setUserId(RandomTestUtil.nextLong());

		newGHAutomatorRepository.setCreateDate(RandomTestUtil.nextDate());

		newGHAutomatorRepository.setGhRepositoryId(RandomTestUtil.randomString());

		newGHAutomatorRepository.setEnabled(RandomTestUtil.randomBoolean());

		_ghAutomatorRepositories.add(_persistence.update(
				newGHAutomatorRepository));

		GHAutomatorRepository existingGHAutomatorRepository = _persistence.findByPrimaryKey(newGHAutomatorRepository.getPrimaryKey());

		Assert.assertEquals(existingGHAutomatorRepository.getUuid(),
			newGHAutomatorRepository.getUuid());
		Assert.assertEquals(existingGHAutomatorRepository.getGhAutomatorRepositoryId(),
			newGHAutomatorRepository.getGhAutomatorRepositoryId());
		Assert.assertEquals(existingGHAutomatorRepository.getUserId(),
			newGHAutomatorRepository.getUserId());
		Assert.assertEquals(Time.getShortTimestamp(
				existingGHAutomatorRepository.getCreateDate()),
			Time.getShortTimestamp(newGHAutomatorRepository.getCreateDate()));
		Assert.assertEquals(existingGHAutomatorRepository.getGhRepositoryId(),
			newGHAutomatorRepository.getGhRepositoryId());
		Assert.assertEquals(existingGHAutomatorRepository.getEnabled(),
			newGHAutomatorRepository.getEnabled());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid(StringPool.BLANK);

		_persistence.countByUuid(StringPool.NULL);

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByGHRepositoryId() throws Exception {
		_persistence.countByGHRepositoryId(StringPool.BLANK);

		_persistence.countByGHRepositoryId(StringPool.NULL);

		_persistence.countByGHRepositoryId((String)null);
	}

	@Test
	public void testCountByGHRID_E() throws Exception {
		_persistence.countByGHRID_E(RandomTestUtil.randomBoolean());

		_persistence.countByGHRID_E(RandomTestUtil.randomBoolean());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		GHAutomatorRepository newGHAutomatorRepository = addGHAutomatorRepository();

		GHAutomatorRepository existingGHAutomatorRepository = _persistence.findByPrimaryKey(newGHAutomatorRepository.getPrimaryKey());

		Assert.assertEquals(existingGHAutomatorRepository,
			newGHAutomatorRepository);
	}

	@Test(expected = NoSuchGHAutomatorRepositoryException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<GHAutomatorRepository> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("GHAutomatorRepository",
			"uuid", true, "ghAutomatorRepositoryId", true, "userId", true,
			"createDate", true, "ghRepositoryId", true, "enabled", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		GHAutomatorRepository newGHAutomatorRepository = addGHAutomatorRepository();

		GHAutomatorRepository existingGHAutomatorRepository = _persistence.fetchByPrimaryKey(newGHAutomatorRepository.getPrimaryKey());

		Assert.assertEquals(existingGHAutomatorRepository,
			newGHAutomatorRepository);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		GHAutomatorRepository missingGHAutomatorRepository = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingGHAutomatorRepository);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		GHAutomatorRepository newGHAutomatorRepository1 = addGHAutomatorRepository();
		GHAutomatorRepository newGHAutomatorRepository2 = addGHAutomatorRepository();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newGHAutomatorRepository1.getPrimaryKey());
		primaryKeys.add(newGHAutomatorRepository2.getPrimaryKey());

		Map<Serializable, GHAutomatorRepository> ghAutomatorRepositories = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, ghAutomatorRepositories.size());
		Assert.assertEquals(newGHAutomatorRepository1,
			ghAutomatorRepositories.get(
				newGHAutomatorRepository1.getPrimaryKey()));
		Assert.assertEquals(newGHAutomatorRepository2,
			ghAutomatorRepositories.get(
				newGHAutomatorRepository2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, GHAutomatorRepository> ghAutomatorRepositories = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(ghAutomatorRepositories.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		GHAutomatorRepository newGHAutomatorRepository = addGHAutomatorRepository();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newGHAutomatorRepository.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, GHAutomatorRepository> ghAutomatorRepositories = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, ghAutomatorRepositories.size());
		Assert.assertEquals(newGHAutomatorRepository,
			ghAutomatorRepositories.get(
				newGHAutomatorRepository.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, GHAutomatorRepository> ghAutomatorRepositories = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(ghAutomatorRepositories.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		GHAutomatorRepository newGHAutomatorRepository = addGHAutomatorRepository();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newGHAutomatorRepository.getPrimaryKey());

		Map<Serializable, GHAutomatorRepository> ghAutomatorRepositories = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, ghAutomatorRepositories.size());
		Assert.assertEquals(newGHAutomatorRepository,
			ghAutomatorRepositories.get(
				newGHAutomatorRepository.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = GHAutomatorRepositoryLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<GHAutomatorRepository>() {
				@Override
				public void performAction(
					GHAutomatorRepository ghAutomatorRepository) {
					Assert.assertNotNull(ghAutomatorRepository);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		GHAutomatorRepository newGHAutomatorRepository = addGHAutomatorRepository();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(GHAutomatorRepository.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("ghAutomatorRepositoryId",
				newGHAutomatorRepository.getGhAutomatorRepositoryId()));

		List<GHAutomatorRepository> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		GHAutomatorRepository existingGHAutomatorRepository = result.get(0);

		Assert.assertEquals(existingGHAutomatorRepository,
			newGHAutomatorRepository);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(GHAutomatorRepository.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("ghAutomatorRepositoryId",
				RandomTestUtil.nextLong()));

		List<GHAutomatorRepository> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		GHAutomatorRepository newGHAutomatorRepository = addGHAutomatorRepository();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(GHAutomatorRepository.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"ghAutomatorRepositoryId"));

		Object newGhAutomatorRepositoryId = newGHAutomatorRepository.getGhAutomatorRepositoryId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("ghAutomatorRepositoryId",
				new Object[] { newGhAutomatorRepositoryId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingGhAutomatorRepositoryId = result.get(0);

		Assert.assertEquals(existingGhAutomatorRepositoryId,
			newGhAutomatorRepositoryId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(GHAutomatorRepository.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"ghAutomatorRepositoryId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("ghAutomatorRepositoryId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		GHAutomatorRepository newGHAutomatorRepository = addGHAutomatorRepository();

		_persistence.clearCache();

		GHAutomatorRepository existingGHAutomatorRepository = _persistence.findByPrimaryKey(newGHAutomatorRepository.getPrimaryKey());

		Assert.assertTrue(Objects.equals(
				existingGHAutomatorRepository.getGhRepositoryId(),
				ReflectionTestUtil.invoke(existingGHAutomatorRepository,
					"getOriginalGhRepositoryId", new Class<?>[0])));
	}

	protected GHAutomatorRepository addGHAutomatorRepository()
		throws Exception {
		long pk = RandomTestUtil.nextLong();

		GHAutomatorRepository ghAutomatorRepository = _persistence.create(pk);

		ghAutomatorRepository.setUuid(RandomTestUtil.randomString());

		ghAutomatorRepository.setUserId(RandomTestUtil.nextLong());

		ghAutomatorRepository.setCreateDate(RandomTestUtil.nextDate());

		ghAutomatorRepository.setGhRepositoryId(RandomTestUtil.randomString());

		ghAutomatorRepository.setEnabled(RandomTestUtil.randomBoolean());

		_ghAutomatorRepositories.add(_persistence.update(ghAutomatorRepository));

		return ghAutomatorRepository;
	}

	private List<GHAutomatorRepository> _ghAutomatorRepositories = new ArrayList<GHAutomatorRepository>();
	private GHAutomatorRepositoryPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}