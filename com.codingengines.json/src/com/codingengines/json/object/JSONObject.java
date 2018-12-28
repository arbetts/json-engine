package com.codingengines.json.object;

import com.codingengines.json.exception.ChildElementNotSupportedException;
import com.codingengines.json.io.JSONReadable;
import com.codingengines.json.io.JSONWritable;

/**
 * Created by Andrew on 2/17/2018.
 */
public class JSONObject extends JSONElement<String>
	implements JSONValue<JSONObject>{

	public static final JSONObject EMPTY_JSON_OBJECT = new JSONObject() {

		protected JSONValue<?> getChild(String key) {
			throw new ChildElementNotSupportedException();
		}

		protected JSONValue<?> getChildByIndex(int index) {
			throw new ChildElementNotSupportedException();
		}

		protected <V> void putChild(String key, JSONValue<V> value) {
			throw new ChildElementNotSupportedException();
		}

		protected <V> void putChildByIndex(
			int index, String key, JSONValue<V> value) {

			throw new ChildElementNotSupportedException();
		}

	};

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