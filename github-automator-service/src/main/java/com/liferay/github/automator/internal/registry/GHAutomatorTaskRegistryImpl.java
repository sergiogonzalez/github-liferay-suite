package com.liferay.github.automator.internal.registry;

import com.liferay.github.automator.service.GHAutomatorTaskLocalService;
import com.liferay.github.automator.task.GHAutomatorTask;
import com.liferay.github.automator.task.GHAutomatorTaskRegistry;
import com.liferay.osgi.service.tracker.collections.map.ServiceReferenceMapper;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMap;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMapFactory;
import com.liferay.portal.kernel.util.ListUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Sergio González
 */
@Component(service = GHAutomatorTaskRegistry.class)
public class GHAutomatorTaskRegistryImpl implements GHAutomatorTaskRegistry {

	@Override
	public List<GHAutomatorTask> getActiveTasks(String repositoryId) {
		List<GHAutomatorTask> activeTasks = new ArrayList<>();

		Set<String> ghAutomatorTaskUuids = _serviceTrackerMap.keySet();

		for (String ghAutomatorTaskUuid : ghAutomatorTaskUuids) {
			if (ghAutomatorTaskLocalService.isGHAutomatorTaskEnabled(
					repositoryId, ghAutomatorTaskUuid)) {

				activeTasks.add(
					_serviceTrackerMap.getService(ghAutomatorTaskUuid));
			}
		}

		return activeTasks;
	}

	@Override
	public List<GHAutomatorTask> getAllTasks() {
		return ListUtil.fromCollection(_serviceTrackerMap.values());
	}

	@Activate
	protected void activate(final BundleContext bundleContext) {
		_serviceTrackerMap = ServiceTrackerMapFactory.openSingleValueMap(
			bundleContext, GHAutomatorTask.class, null,
			new ServiceReferenceMapper<String, GHAutomatorTask>() {

				@Override
				public void map(
					ServiceReference<GHAutomatorTask> serviceReference,
					Emitter<String> emitter) {

					GHAutomatorTask ghAutomatorTask = bundleContext.getService(
						serviceReference);

					emitter.emit(ghAutomatorTask.getUuid());
				}

			});
	}

	@Deactivate
	protected void deactivate() {
		_serviceTrackerMap.close();
	}

	@Reference
	protected GHAutomatorTaskLocalService ghAutomatorTaskLocalService;

	private ServiceTrackerMap<String, GHAutomatorTask> _serviceTrackerMap;

}