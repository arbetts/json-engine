package com.codingengines.com.json;

import com.codingengines.json.io.JSONInput;
import com.codingengines.json.io.JSONReadable;

class TestReadable implements JSONReadable {

	@Override
	public void read(JSONInput jsonInput) {
		foo = jsonInput.get("foo", "world");
	}

	String foo;

}