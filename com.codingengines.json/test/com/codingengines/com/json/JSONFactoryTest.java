package com.codingengines.com.json;

import com.codingengines.json.object.JSONElement;
import com.codingengines.json.object.JSONFactory;
import com.codingengines.json.object.JSONObject;

import org.junit.Assert;
import org.junit.Test;

public class JSONFactoryTest {

	@Test
	public void testObject() throws Exception {
		String jsonText =
			"{ " +
				"\"obj\":{" +
					"\"child\": {" +
						"\"name\":\"value\"" +
					"}" +
				"}" +
			"}";

		JSONElement<?> jsonElement = JSONFactory.createJSONElement(jsonText);

		JSONObject jsonObject =
			jsonElement.get("obj", JSONObject.EMPTY_JSON_OBJECT);

		JSONObject childObject = jsonObject.get(
			"child", JSONObject.EMPTY_JSON_OBJECT);

		Assert.assertNotEquals("value", childObject.get("name", ""));

	}

}