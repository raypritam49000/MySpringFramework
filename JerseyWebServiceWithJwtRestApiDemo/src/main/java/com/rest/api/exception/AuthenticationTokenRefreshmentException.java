package com.rest.api.exception;

public class AuthenticationTokenRefreshmentException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AuthenticationTokenRefreshmentException(String message) {
		super(message);
	}

	public AuthenticationTokenRefreshmentException(String message, Throwable cause) {
		super(message, cause);
	}
}
