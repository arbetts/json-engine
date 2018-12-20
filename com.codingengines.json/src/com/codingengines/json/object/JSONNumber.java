package com.codingengines.json.object;

/**
 * Created by Andrew on 2/18/2018.
 */
public final class JSONNumber extends BaseJSONPrimitive<Number> {

	JSONNumber(Number n, JSONElement<?> parent) {
		super(n, parent);
	}

}