package com.codingengines.com.json;

import com.codingengines.json.io.JSONWritable;
import com.codingengines.json.object.JSONFactory;
import com.codingengines.json.object.JSONArray;
import com.codingengines.json.object.JSONObject;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Andrew on 2/17/2018.
 */
public class JSONElementTest {

	@Test
	public void testObject() throws Exception {
		JSONObject jsonObject = JSONFactory.createJSONObject();

		jsonObject.put(
			"hello",
			" \" \\\" \u0000 through \u001f \n\t\b\r world \\");

		JSONArray jsonArray = JSONFactory.createJSONArray();

		jsonArray.put(true);
		jsonArray.put(5);
		jsonArray.put("a");
		jsonArray.put((String)null);

		JSONObject childJSONObject = JSONFactory.createJSONObject();

		childJSONObject.put("foo", "bar");

		jsonArray.put(childJSONObject);

		jsonObject.put("array", jsonArray);

		System.out.println(jsonObject.toJSON());
	}

	@Test
	public void testReadArray() throws Exception {
		JSONObject jsonObject = JSONFactory.createJSONObject();
		JSONArray jsonArray = JSONFactory.createJSONArray();

		jsonObject.put("foo", "bar");
		jsonArray.put(1, jsonObject);

		TestReadable jsonReadable = new TestReadable();

		jsonArray.get(1, jsonReadable);

		Assert.assertEquals("bar", jsonReadable.foo);
	}

	@Test
	public void testWriteArray() throws Exception {
		JSONArray jsonArray = JSONFactory.createJSONArray();

		JSONWritable jsonWritable = new TestWritable();

		jsonArray.put(1, jsonWritable);

		System.out.println(jsonArray.toJSON());
	}

	@Test
	public void testReadObject() throws Exception {
		JSONObject jsonObject = JSONFactory.createJSONObject();
		JSONObject parentObject = JSONFactory.createJSONObject();

		jsonObject.put("foo", "bar");
		parentObject.put("obj", jsonObject);

		TestReadable jsonReadable = new TestReadable();

		parentObject.get("obj", jsonReadable);

		Assert.assertEquals("bar", jsonReadable.foo);
	}

	@Test
	public void testWriteObject() throws Exception {
		JSONObject jsonObject = JSONFactory.createJSONObject();

		JSONWritable jsonWritable = new TestWritable();

		jsonObject.put("obj", jsonWritable);

		System.out.println(jsonObject.toJSON());
	}

}