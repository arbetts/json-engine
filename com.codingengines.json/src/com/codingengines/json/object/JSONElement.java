package com.codingengines.json.object;

import com.codingengines.json.exception.CircularDependencyException;
import com.codingengines.json.function.KeyConverter;
import com.codingengines.json.io.JSONInput;
import com.codingengines.json.io.JSONOutput;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

/**
 * Created by Andrew on 2/18/2018.
 */
public abstract class JSONElement<K> implements
	Iterable<JSONPair<K, ?>>, JSONInput<K>, JSONOutput<K> {

	JSONElement() {
		children = new ArrayList<>();
	}

	JSONElement(JSONElement<?> parent) {
		this.parent = parent;
	}

	public Boolean get(K key, Boolean defaultValue) {
		JSONValue<?> value = getChild(key);

		if (value instanceof JSONBoolean) {
			return ((JSONBoolean)value).get();
		}

		return defaultValue;
	}

	public Number get(K key, Number defaultValue) {
		JSONValue<?> value = getChild(key);

		if (value instanceof JSONNumber) {
			return ((JSONNumber)value).get();
		}

		return defaultValue;
	}

	public String get(K key, String defaultValue) {
		JSONValue<?> value = getChild(key);

		if (value instanceof JSONString) {
			return ((JSONString)value).get();
		}

		return defaultValue;
	}

	public JSONArray get(K key, JSONArray defaultValue) {
		JSONValue<?> value = getChild(key);

		if (value instanceof JSONArray) {
			return ((JSONArray)value);
		}

		return defaultValue;
	}

	public JSONObject get(K key, JSONObject defaultValue) {
		JSONValue<?> value = getChild(key);

		if (value instanceof JSONObject) {
			return ((JSONObject)value);
		}

		return defaultValue;
	}

	public Iterator<JSONPair<K, ?>> iterator() {
		ListIterator<JSONPair<K, ?>> pairListIterator =
			children.listIterator();

		while (pairListIterator.hasNext()) {
			pairListIterator.next();
		}

		return new Iterator<JSONPair<K, ?>>() {

			@Override
			public boolean hasNext() {
				return pairListIterator.hasPrevious();
			}

			@Override
			public JSONPair<K, ?> next() {
				return pairListIterator.previous();
			}
		};
	}

	public void put(K key, Boolean value) {
		putChild(key, new JSONBoolean(value, this));
	}

	public void put(K key, Number value) {
		putChild(key, new JSONNumber(value, this));
	}

	public void put(K key, String value) {
		putChild(key, new JSONString(value, this));
	}

	public void put(K key, JSONArray value) {
		_checkParent(value);

		value.setParent(this);

		putChild(key, value);
	}

	public void put(K key, JSONObject value) {
		_checkParent(value);

		value.setParent(this);

		putChild(key, value);
	}

	public int size() {
		return children.size();
	}

	public String toJSON() {
		StringBuilder sb = new StringBuilder();

		toJSON(sb);

		return sb.toString();
	}

	public KeyConverter<K> getKeyConverter() {
		return s -> (K)s;
	}

	protected abstract Character closeChar();
	protected abstract JSONKey<K> getKey(K key);
	protected abstract Character openChar();

	protected JSONValue<?> getChild(K key) {
		Iterator<JSONPair<K, ?>> pairIterator = iterator();

		while (pairIterator.hasNext()) {
			JSONPair<K, ?> pair = pairIterator.next();

			if (pair.matches(key)) {
				return pair.value();
			}
		}

		return null;
	}

	protected JSONValue<?> getChildByIndex(int index) {
		JSONPair<K, ?> pair = children.get(index);

		return pair.value();
	}

	protected <V> void putChild(K key, JSONValue<V> value) {
		children.add(new JSONPairImpl<>(getKey(key), value));
	}

	protected <V> void putChildByIndex(int index, K key, JSONValue<V> value) {
		while (children.size() <= index) {
			children.add(null);
		}

		children.set(index, new JSONPairImpl<>(getKey(key), value));
	}

	protected void setParent(JSONElement<?> parent) {
		this.parent = parent;
	}

	protected void toJSON(StringBuilder sb) {
		Character open = openChar();

		if (open != null && parent == null) {
			sb.append(open);
		}

		for (int i = 0; i < children.size(); i++) {
			JSONPair<K, ?> pair = children.get(i);

			if (pair == null) {
				continue;
			}

			JSONKey<K> key = pair.key();
			JSONValue<?> value = pair.value();

			if (key.get() instanceof String) {
				sb.append('"');
				sb.append(key.get());
				sb.append('"');
				sb.append(":");
			}

			if (value instanceof JSONElement) {
				JSONElement<?> childElement = (JSONElement<?>)value;

				if (childElement.openChar() != null) {
					sb.append(childElement.openChar());
				}

				childElement.toJSON(sb);

				if (childElement.closeChar() != null) {
					sb.append(childElement.closeChar());
				}
			}
			else {
				sb.append(value.get());
			}

			if (i < children.size() - 1) {
				sb.append(',');
			}
		}

		Character close = closeChar();

		if (close != null && parent == null) {
			sb.append(close);
		}
	}

	private static class JSONPairImpl<K, V> implements JSONPair<K, V> {

		JSONPairImpl(JSONKey<K> jsonKey, JSONValue<V> jsonValue) {
			_jsonKey = jsonKey;
			_jsonValue = jsonValue;
		}

		public boolean matches(K key) {
			return Objects.equals(_jsonKey.get(), key);
		}

		public JSONKey<K> key() {
			return _jsonKey;
		}

		public JSONValue<V> value() {
			return _jsonValue;
		}

		private JSONKey<K> _jsonKey;
		private JSONValue<V> _jsonValue;

	}

	private void _checkParent(JSONElement<?> element) {
		JSONElement<?> parent = this.parent;

		while (parent != null) {
			if (parent == element) {
				throw new CircularDependencyException();
			}
		}
	}

	List<JSONPair<K, ?>> children;
	JSONElement<?> parent;

}