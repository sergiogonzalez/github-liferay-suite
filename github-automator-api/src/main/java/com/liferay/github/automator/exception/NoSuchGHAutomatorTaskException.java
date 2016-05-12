package com.liferay.github.automator.exception;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Sergio González
 */
@ProviderType
public class NoSuchGHAutomatorTaskException extends NoSuchModelException {

	public NoSuchGHAutomatorTaskException() {
	}

	public NoSuchGHAutomatorTaskException(String msg) {
		super(msg);
	}

	public NoSuchGHAutomatorTaskException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchGHAutomatorTaskException(Throwable cause) {
		super(cause);
	}

}