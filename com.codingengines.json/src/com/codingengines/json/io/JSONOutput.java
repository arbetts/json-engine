package com.codingengines.json.io;

import com.codingengines.json.function.KeyConverter;
import com.codingengines.json.object.JSONArray;
import com.codingengines.json.object.JSONObject;

/**
 * Created by Andrew on 3/11/2018.
 */
public interface JSONOutput<K> {

	default KeyConverter<K> getKeyConverter() {
		return s -> (K)s;
	}

	default void put(String key, Boolean value) {
		put(getKeyConverter().apply(key), value);
	}

	default void put(String key, Number value) {
		put(getKeyConverter().apply(key), value);
	}

	default void put(String key, String value) {
		put(getKeyConverter().apply(key), value);
	}

	default void put(String key, JSONArray value) {
		put(getKeyConverter().apply(key), value);
	}

	default void put(String key, JSONObject value) {
		put(getKeyConverter().apply(key), value);
	}

	default void put(String key, JSONWritable jsonWritable) {
		put(getKeyConverter().apply(key), jsonWritable);
	}

	// key

	public void put(K key, Boolean value);

	public void put(K key, Number value);

	public void put(K key, String value);

	public void put(K key, JSONArray value);

	public void put(K key, JSONObject value);

	public void put(K key, JSONWritable jsonWritable);

}