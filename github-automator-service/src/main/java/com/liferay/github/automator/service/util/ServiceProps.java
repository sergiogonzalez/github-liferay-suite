package com.liferay.github.automator.service.util;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;
import com.liferay.portal.kernel.configuration.Filter;

import java.util.Properties;

/**
 * @author Sergio González
 * @generated
 */
@ProviderType
public class ServiceProps {
	public static void addProperties(Properties properties) {
		_instance._configuration.addProperties(properties);
	}

	public static boolean contains(String key) {
		return _instance._configuration.contains(key);
	}

	public static String get(String key) {
		return _instance._configuration.get(key);
	}

	public static String get(String key, Filter filter) {
		return _instance._configuration.get(key, filter);
	}

	public static String[] getArray(String key) {
		return _instance._configuration.getArray(key);
	}

	public static String[] getArray(String key, Filter filter) {
		return _instance._configuration.getArray(key, filter);
	}

	public static Properties getProperties() {
		return _instance._configuration.getProperties();
	}

	public static void removeProperties(Properties properties) {
		_instance._configuration.removeProperties(properties);
	}

	public static void set(String key, String value) {
		_instance._configuration.set(key, value);
	}

	private ServiceProps() {
		_configuration = ConfigurationFactoryUtil.getConfiguration(getClass()
																	   .getClassLoader(),
				"service");
	}

	private static ServiceProps _instance = new ServiceProps();
	private Configuration _configuration;
}