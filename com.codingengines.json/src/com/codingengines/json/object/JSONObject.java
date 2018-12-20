package com.codingengines.json.object;

import com.codingengines.json.io.JSONReadable;
import com.codingengines.json.io.JSONWritable;

/**
 * Created by Andrew on 2/17/2018.
 */
public class JSONObject extends JSONElement<String>
	implements JSONValue<JSONObject>{

	@Override
	public JSONObject get() {
		return this;
	}

	@Override
	public JSONReadable get(String key, JSONReadable jsonReadable) {
		JSONObject jsonObject = get(key, this);

		jsonReadable.read(jsonObject);

		return jsonReadable;
	}

	@Override
	public void put(String key, JSONWritable jsonWritable) {
		JSONObject jsonObject = new JSONObject();

		jsonWritable.write(jsonObject);

		put(key, jsonObject);
	}

	@Override
	protected JSONKey<String> getKey(String key) {
		return new JSONStringKey(key);
	}

	@Override
	protected Character openChar() {
		return '{';
	}

	@Override
	protected Character closeChar() {
		return '}';
	}

}