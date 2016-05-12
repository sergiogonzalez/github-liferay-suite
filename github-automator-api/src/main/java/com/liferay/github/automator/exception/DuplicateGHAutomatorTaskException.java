package com.liferay.github.automator.exception;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Sergio González
 */
@ProviderType
public class DuplicateGHAutomatorTaskException extends PortalException {

	public DuplicateGHAutomatorTaskException() {
	}

	public DuplicateGHAutomatorTaskException(String msg) {
		super(msg);
	}

	public DuplicateGHAutomatorTaskException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateGHAutomatorTaskException(Throwable cause) {
		super(cause);
	}

}