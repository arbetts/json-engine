package com.codingengines.json.io;

import com.codingengines.json.function.KeyConverter;
import com.codingengines.json.object.JSONArray;
import com.codingengines.json.object.JSONObject;

/**
 * Created by Andrew on 3/11/2018.
 */
public interface JSONInput<K> {

	default KeyConverter<K> getKeyConverter() {
		return s -> (K)s;
	}

	default Boolean get(String key, Boolean defaultValue) {
		return get(getKeyConverter().apply(key), defaultValue);
	}

	default Number get(String key, Number defaultValue) {
		return get(getKeyConverter().apply(key), defaultValue);
	}

	default String get(String key, String defaultValue) {
		return get(getKeyConverter().apply(key), defaultValue);
	}

	default JSONArray get(String key, JSONArray defaultValue) {
		return get(getKeyConverter().apply(key), defaultValue);
	}

	default JSONObject get(String key, JSONObject defaultValue) {
		return get(getKeyConverter().apply(key), defaultValue);
	}

	default JSONReadable get(String key, JSONReadable jsonReadable) {
		return get(getKeyConverter().apply(key), jsonReadable);
	}

	// key

	public Boolean get(K key, Boolean defaultValue);

	public Number get(K key, Number defaultValue);

	public String get(K key, String defaultValue);

	public JSONArray get(K key, JSONArray defaultValue);

	public JSONObject get(K key, JSONObject defaultValue);

	public JSONReadable get(K key, JSONReadable jsonReadable);

}