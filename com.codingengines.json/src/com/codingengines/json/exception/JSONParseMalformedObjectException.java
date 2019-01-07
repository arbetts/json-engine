package com.codingengines.json.exception;

public class JSONParseMalformedObjectException extends RuntimeException {

	public JSONParseMalformedObjectException() {
		super("jsonText does not conform to JSON Grammar; " +
			"https://tools.ietf.org/html/rfc7159");
	}

	public JSONParseMalformedObjectException(String message) {
		super(message);
	}

	public JSONParseMalformedObjectException(String message, Throwable cause) {
		super(message, cause);
	}

	public JSONParseMalformedObjectException(Throwable cause) {
		super(cause);
	}

}