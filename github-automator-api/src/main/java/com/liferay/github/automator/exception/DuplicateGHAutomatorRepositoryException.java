package com.liferay.github.automator.exception;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Sergio González
 */
@ProviderType
public class DuplicateGHAutomatorRepositoryException extends PortalException {

	public DuplicateGHAutomatorRepositoryException() {
	}

	public DuplicateGHAutomatorRepositoryException(String msg) {
		super(msg);
	}

	public DuplicateGHAutomatorRepositoryException(
		String msg, Throwable cause) {

		super(msg, cause);
	}

	public DuplicateGHAutomatorRepositoryException(Throwable cause) {
		super(cause);
	}

}