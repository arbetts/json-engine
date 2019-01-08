package com.codingengines.json.object;

import com.codingengines.json.exception.ChildElementNotSupportedException;
import com.codingengines.json.function.KeyConverter;

/**
 * Created by Andrew on 2/18/2018.
 */
public class JSONArray extends JSONElement<Integer>
	implements JSONValue<JSONArray> {

	public static final JSONArray EMPTY_JSON_ARRAY = new JSONArray() {

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
	public KeyConverter<Integer> getKeyConverter() {
		return Integer::parseInt;
	}

	@Override
	public JSONArray get() {
		return this;
	}

	public void put(Boolean value) {
		put(size(), value);
	}

	public void put(Number value) {
		put(size(),value);
	}

	public void put(String value) {
		put(size(), value);
	}

	public void put(JSONArray value) {
		put(size(), value);
	}

	public void put(JSONObject value) {
		put(size(), value);
	}

	@Override
	protected Character openChar() {
		return '[';
	}

	@Override
	protected Character closeChar() {
		return ']';
	}

	@Override
	protected JSONKey<Integer> getKey(Integer key) {
		return new JSONIntegerKey(key);
	}

	protected JSONValue<?> getChild(Integer key) {
		if (key >= 0 && key < size()) {
			return getChildByIndex(key);
		}

		return null;
	}

	protected <V> void putChild(Integer key, JSONValue<V> value) {
		putChildByIndex(key, key, value);
	}

}