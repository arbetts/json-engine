package com.codingengines.json.exception;

/**
 * Created by Andrew on 3/7/2018.
 */
public class ChildElementNotSupportedException extends RuntimeException {

	public ChildElementNotSupportedException() {
		super("child element not supported");
	}

	public ChildElementNotSupportedException(String message) {
		super(message);
	}

	public ChildElementNotSupportedException(String message, Throwable cause) {
		super(message, cause);
	}

	public ChildElementNotSupportedException(Throwable cause) {
		super(cause);
	}

}