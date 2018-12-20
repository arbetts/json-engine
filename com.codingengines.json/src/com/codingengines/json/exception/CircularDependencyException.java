package com.codingengines.json.exception;

/**
 * Created by Andrew on 3/10/2018.
 */
public class CircularDependencyException extends RuntimeException {

	public CircularDependencyException() {
		super("child element cannot be a parent of itself");
	}

	public CircularDependencyException(String message) {
		super(message);
	}

	public CircularDependencyException(String message, Throwable cause) {
		super(message, cause);
	}

	public CircularDependencyException(Throwable cause) {
		super(cause);
	}

}