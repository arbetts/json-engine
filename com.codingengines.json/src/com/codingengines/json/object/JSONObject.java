package com.codingengines.json.object;

import com.codingengines.json.exception.ChildElementNotSupportedException;

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