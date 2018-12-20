package com.codingengines.json.object;

import com.codingengines.json.exception.ChildElementNotSupportedException;
import com.codingengines.json.io.JSONReadable;
import com.codingengines.json.io.JSONWritable;

/**
 * Created by Andrew on 2/18/2018.
 */
class BaseJSONPrimitive<P> extends JSONElement<String> implements JSONValue<P> {

	BaseJSONPrimitive(P p, JSONElement<?> parent) {
		super(parent);

		_p = p;
	}

	@Override
	public void put(String key, JSONWritable jsonWritable) {
		throw new ChildElementNotSupportedException();
	}

	@Override
	public JSONReadable get(String key, JSONReadable jsonReadable) {
		throw new ChildElementNotSupportedException();
	}

	@Override
	public P get() {
		return _p;
	}

	public String toJSON() {
		return _p.toString();
	}

	protected void toJSON(StringBuilder sb) {
		sb.append(_p);
	}

	@Override
	protected Character openChar() {
		return null;
	}

	@Override
	protected Character closeChar() {
		return null;
	}

	@Override
	protected JSONKey<String> getKey(String key) {
		return new JSONStringKey(key);
	}

	protected JSONValue<?> getChild(String key) {
		throw new ChildElementNotSupportedException();
	}

	protected <V> void putChild(String key, JSONValue<V> value) {
		throw new ChildElementNotSupportedException();
	}

	protected P _p;

}