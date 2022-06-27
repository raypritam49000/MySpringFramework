package com.rest.api.exception;

public class InvalidAuthenticationTokenException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidAuthenticationTokenException(String message, Throwable cause) {
		super(message, cause);
	}
}
