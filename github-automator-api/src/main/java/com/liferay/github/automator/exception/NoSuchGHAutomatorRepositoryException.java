package com.liferay.github.automator.exception;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Sergio González
 */
@ProviderType
public class NoSuchGHAutomatorRepositoryException extends NoSuchModelException {

	public NoSuchGHAutomatorRepositoryException() {
	}

	public NoSuchGHAutomatorRepositoryException(String msg) {
		super(msg);
	}

	public NoSuchGHAutomatorRepositoryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchGHAutomatorRepositoryException(Throwable cause) {
		super(cause);
	}

}