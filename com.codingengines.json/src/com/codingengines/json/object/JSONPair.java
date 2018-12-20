package com.codingengines.json.object;

/**
 * Created by Andrew on 3/10/2018.
 */
public interface JSONPair<K, V> {

	public boolean matches(K key);

	public JSONKey<K> key();

	public JSONValue<V> value();

}