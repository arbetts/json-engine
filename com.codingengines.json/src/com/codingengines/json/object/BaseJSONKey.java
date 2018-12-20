package com.codingengines.json.object;

/**
 * Created by Andrew on 2/18/2018.
 */
public abstract class BaseJSONKey<K> implements JSONKey<K> {

	BaseJSONKey(K key) {
		_key = key;
	}

	public K get() {
		return _key;
	}

	private K _key;

}