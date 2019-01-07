package com.codingengines.json.exception;

public class JSONParseMalformedNameValueException extends RuntimeException {

	public JSONParseMalformedNameValueException() {
		super("jsonText does not conform to JSON Grammar; " +
			"https://tools.ietf.org/html/rfc7159");
	}

	public JSONParseMalformedNameValueException(String message) {
		super(message);
	}

	public JSONParseMalformedNameValueException(String message, Throwable cause) {
		super(message, cause);
	}

	public JSONParseMalformedNameValueException(Throwable cause) {
		super(cause);
	}

}