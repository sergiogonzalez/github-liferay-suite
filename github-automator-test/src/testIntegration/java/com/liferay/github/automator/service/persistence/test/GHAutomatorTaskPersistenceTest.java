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

package com.liferay.github.automator.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.github.automator.exception.NoSuchGHAutomatorTaskException;
import com.liferay.github.automator.model.GHAutomatorTask;
import com.liferay.github.automator.service.GHAutomatorTaskLocalServiceUtil;
import com.liferay.github.automator.service.persistence.GHAutomatorTaskPersistence;
import com.liferay.github.automator.service.persistence.GHAutomatorTaskUtil;

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
public class GHAutomatorTaskPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = GHAutomatorTaskUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<GHAutomatorTask> iterator = _ghAutomatorTasks.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		GHAutomatorTask ghAutomatorTask = _persistence.create(pk);

		Assert.assertNotNull(ghAutomatorTask);

		Assert.assertEquals(ghAutomatorTask.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		GHAutomatorTask newGHAutomatorTask = addGHAutomatorTask();

		_persistence.remove(newGHAutomatorTask);

		GHAutomatorTask existingGHAutomatorTask = _persistence.fetchByPrimaryKey(newGHAutomatorTask.getPrimaryKey());

		Assert.assertNull(existingGHAutomatorTask);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addGHAutomatorTask();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		GHAutomatorTask newGHAutomatorTask = _persistence.create(pk);

		newGHAutomatorTask.setUuid(RandomTestUtil.randomString());

		newGHAutomatorTask.setUserId(RandomTestUtil.nextLong());

		newGHAutomatorTask.setCreateDate(RandomTestUtil.nextDate());

		newGHAutomatorTask.setGhRepositoryId(RandomTestUtil.randomString());

		newGHAutomatorTask.setGhTaskUuid(RandomTestUtil.randomString());

		newGHAutomatorTask.setEnabled(RandomTestUtil.randomBoolean());

		_ghAutomatorTasks.add(_persistence.update(newGHAutomatorTask));

		GHAutomatorTask existingGHAutomatorTask = _persistence.findByPrimaryKey(newGHAutomatorTask.getPrimaryKey());

		Assert.assertEquals(existingGHAutomatorTask.getUuid(),
			newGHAutomatorTask.getUuid());
		Assert.assertEquals(existingGHAutomatorTask.getGhAutomatorTaskId(),
			newGHAutomatorTask.getGhAutomatorTaskId());
		Assert.assertEquals(22,
			newGHAutomatorTask.getUserId());
		Assert.assertEquals(Time.getShortTimestamp(
				existingGHAutomatorTask.getCreateDate()),
			Time.getShortTimestamp(newGHAutomatorTask.getCreateDate()));
		Assert.assertEquals(existingGHAutomatorTask.getGhRepositoryId(),
			newGHAutomatorTask.getGhRepositoryId());
		Assert.assertEquals(existingGHAutomatorTask.getGhTaskUuid(),
			newGHAutomatorTask.getGhTaskUuid());
		Assert.assertEquals(existingGHAutomatorTask.getEnabled(),
			newGHAutomatorTask.getEnabled());
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
	public void testCountByGHTaskUuid() throws Exception {
		_persistence.countByGHTaskUuid(StringPool.BLANK);

		_persistence.countByGHTaskUuid(StringPool.NULL);

		_persistence.countByGHTaskUuid((String)null);
	}

	@Test
	public void testCountByGHRID_GHTUUID() throws Exception {
		_persistence.countByGHRID_GHTUUID(StringPool.BLANK, StringPool.BLANK);

		_persistence.countByGHRID_GHTUUID(StringPool.NULL, StringPool.NULL);

		_persistence.countByGHRID_GHTUUID((String)null, (String)null);
	}

	@Test
	public void testCountByGHRID_E() throws Exception {
		_persistence.countByGHRID_E(StringPool.BLANK,
			RandomTestUtil.randomBoolean());

		_persistence.countByGHRID_E(StringPool.NULL,
			RandomTestUtil.randomBoolean());

		_persistence.countByGHRID_E((String)null, RandomTestUtil.randomBoolean());
	}

	@Test
	public void testCountByGHTUUID_E() throws Exception {
		_persistence.countByGHTUUID_E(StringPool.BLANK,
			RandomTestUtil.randomBoolean());

		_persistence.countByGHTUUID_E(StringPool.NULL,
			RandomTestUtil.randomBoolean());

		_persistence.countByGHTUUID_E((String)null,
			RandomTestUtil.randomBoolean());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		GHAutomatorTask newGHAutomatorTask = addGHAutomatorTask();

		GHAutomatorTask existingGHAutomatorTask = _persistence.findByPrimaryKey(newGHAutomatorTask.getPrimaryKey());

		Assert.assertEquals(existingGHAutomatorTask, newGHAutomatorTask);
	}

	@Test(expected = NoSuchGHAutomatorTaskException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<GHAutomatorTask> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("GHAutomatorTask", "uuid",
			true, "ghAutomatorTaskId", true, "userId", true, "createDate",
			true, "ghRepositoryId", true, "ghTaskUuid", true, "enabled", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		GHAutomatorTask newGHAutomatorTask = addGHAutomatorTask();

		GHAutomatorTask existingGHAutomatorTask = _persistence.fetchByPrimaryKey(newGHAutomatorTask.getPrimaryKey());

		Assert.assertEquals(existingGHAutomatorTask, newGHAutomatorTask);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		GHAutomatorTask missingGHAutomatorTask = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingGHAutomatorTask);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		GHAutomatorTask newGHAutomatorTask1 = addGHAutomatorTask();
		GHAutomatorTask newGHAutomatorTask2 = addGHAutomatorTask();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newGHAutomatorTask1.getPrimaryKey());
		primaryKeys.add(newGHAutomatorTask2.getPrimaryKey());

		Map<Serializable, GHAutomatorTask> ghAutomatorTasks = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, ghAutomatorTasks.size());
		Assert.assertEquals(newGHAutomatorTask1,
			ghAutomatorTasks.get(newGHAutomatorTask1.getPrimaryKey()));
		Assert.assertEquals(newGHAutomatorTask2,
			ghAutomatorTasks.get(newGHAutomatorTask2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, GHAutomatorTask> ghAutomatorTasks = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(ghAutomatorTasks.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		GHAutomatorTask newGHAutomatorTask = addGHAutomatorTask();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newGHAutomatorTask.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, GHAutomatorTask> ghAutomatorTasks = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, ghAutomatorTasks.size());
		Assert.assertEquals(newGHAutomatorTask,
			ghAutomatorTasks.get(newGHAutomatorTask.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, GHAutomatorTask> ghAutomatorTasks = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(ghAutomatorTasks.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		GHAutomatorTask newGHAutomatorTask = addGHAutomatorTask();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newGHAutomatorTask.getPrimaryKey());

		Map<Serializable, GHAutomatorTask> ghAutomatorTasks = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, ghAutomatorTasks.size());
		Assert.assertEquals(newGHAutomatorTask,
			ghAutomatorTasks.get(newGHAutomatorTask.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = GHAutomatorTaskLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<GHAutomatorTask>() {
				@Override
				public void performAction(GHAutomatorTask ghAutomatorTask) {
					Assert.assertNotNull(ghAutomatorTask);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		GHAutomatorTask newGHAutomatorTask = addGHAutomatorTask();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(GHAutomatorTask.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("ghAutomatorTaskId",
				newGHAutomatorTask.getGhAutomatorTaskId()));

		List<GHAutomatorTask> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		GHAutomatorTask existingGHAutomatorTask = result.get(0);

		Assert.assertEquals(existingGHAutomatorTask, newGHAutomatorTask);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(GHAutomatorTask.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("ghAutomatorTaskId",
				RandomTestUtil.nextLong()));

		List<GHAutomatorTask> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		GHAutomatorTask newGHAutomatorTask = addGHAutomatorTask();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(GHAutomatorTask.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"ghAutomatorTaskId"));

		Object newGhAutomatorTaskId = newGHAutomatorTask.getGhAutomatorTaskId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("ghAutomatorTaskId",
				new Object[] { newGhAutomatorTaskId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingGhAutomatorTaskId = result.get(0);

		Assert.assertEquals(existingGhAutomatorTaskId, newGhAutomatorTaskId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(GHAutomatorTask.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"ghAutomatorTaskId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("ghAutomatorTaskId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		GHAutomatorTask newGHAutomatorTask = addGHAutomatorTask();

		_persistence.clearCache();

		GHAutomatorTask existingGHAutomatorTask = _persistence.findByPrimaryKey(newGHAutomatorTask.getPrimaryKey());

		Assert.assertTrue(Objects.equals(
				existingGHAutomatorTask.getGhRepositoryId(),
				ReflectionTestUtil.invoke(existingGHAutomatorTask,
					"getOriginalGhRepositoryId", new Class<?>[0])));
		Assert.assertTrue(Objects.equals(
				existingGHAutomatorTask.getGhTaskUuid(),
				ReflectionTestUtil.invoke(existingGHAutomatorTask,
					"getOriginalGhTaskUuid", new Class<?>[0])));
	}

	protected GHAutomatorTask addGHAutomatorTask() throws Exception {
		long pk = RandomTestUtil.nextLong();

		GHAutomatorTask ghAutomatorTask = _persistence.create(pk);

		ghAutomatorTask.setUuid(RandomTestUtil.randomString());

		ghAutomatorTask.setUserId(RandomTestUtil.nextLong());

		ghAutomatorTask.setCreateDate(RandomTestUtil.nextDate());

		ghAutomatorTask.setGhRepositoryId(RandomTestUtil.randomString());

		ghAutomatorTask.setGhTaskUuid(RandomTestUtil.randomString());

		ghAutomatorTask.setEnabled(RandomTestUtil.randomBoolean());

		_ghAutomatorTasks.add(_persistence.update(ghAutomatorTask));

		return ghAutomatorTask;
	}

	private List<GHAutomatorTask> _ghAutomatorTasks = new ArrayList<GHAutomatorTask>();
	private GHAutomatorTaskPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}