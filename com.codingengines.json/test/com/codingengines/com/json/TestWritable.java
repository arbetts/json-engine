package com.codingengines.com.json;

import com.codingengines.json.io.JSONOutput;
import com.codingengines.json.io.JSONWritable;

class TestWritable implements JSONWritable {

	@Override
	public void write(JSONOutput jsonOutput) {
		jsonOutput.put("foo", foo);
	}

	String foo = "bar";

}