package com.codingengines.com.json;

import com.codingengines.json.object.JSONElement;
import com.codingengines.json.object.JSONFactory;

import org.junit.Assert;
import org.junit.Test;

public class JSONFactoryTest {

	@Test
	public void testObject() throws Exception {
		JSONElement<?> jsonElement = JSONFactory.createJSONElement(
			jsonText);

		System.out.println(jsonText);
		System.out.println(jsonElement.toJSON());

		Assert.assertNotNull(jsonElement);
	}

	private static final String simpleObjectJSONText =
		"{" +
			"\"key1\": true" +
		"}";

	private static final String jsonText =
		"{\n" +
		"\t\"array\":[\n" +
		"\t[],\n" +
		"\t[\"one\"],\n" +
		"\t\t[\"one\",\"two\"],\n" +
		"\t\t[\"one\",3],\n" +
		"\t\t[\"one\",true],\n" +
		"\t\t[\"one\",false],\n" +
		"\t\t[\"one\",null],\n" +
		"\t\t[\"one\",{}],\n" +
		"\t\t[\"one\",[]],\n" +
		"\t[2],\n" +
		"\t\t[2,\"two\"],\n" +
		"\t\t[2,3],\n" +
		"\t\t[2,true],\n" +
		"\t\t[2,false],\n" +
		"\t\t[2,null],\n" +
		"\t\t[2,{}],\n" +
		"\t\t[2,[]],\n" +
		"\t[true],\n" +
		"\t\t[true,\"two\"],\n" +
		"\t\t[true,3],\n" +
		"\t\t[true,true],\n" +
		"\t\t[true,false],\n" +
		"\t\t[true,null],\n" +
		"\t\t[true,{}],\n" +
		"\t\t[true,[]],\n" +
		"\t[false],\n" +
		"\t\t[false,\"two\"],\n" +
		"\t\t[false,3],\n" +
		"\t\t[false,true],\n" +
		"\t\t[false,false],\n" +
		"\t\t[false,null],\n" +
		"\t\t[false,{}],\n" +
		"\t\t[false,[]],\n" +
		"\t[null],\n" +
		"\t\t[null,\"two\"],\n" +
		"\t\t[null,3],\n" +
		"\t\t[null,true],\n" +
		"\t\t[null,false],\n" +
		"\t\t[null,null],\n" +
		"\t\t[null,{}],\n" +
		"\t\t[null,[]],\n" +
		"\t[{}],\n" +
		"\t\t[{},\"two\"],\n" +
		"\t\t[{},3],\n" +
		"\t\t[{},true],\n" +
		"\t\t[{},false],\n" +
		"\t\t[{},null],\n" +
		"\t\t[{},{}],\n" +
		"\t\t[{},[]],\n" +
		"\t[[]],\n" +
		"\t\t[[],\"two\"],\n" +
		"\t\t[[],3],\n" +
		"\t\t[[],true],\n" +
		"\t\t[[],false],\n" +
		"\t\t[[],null],\n" +
		"\t\t[[],{}],\n" +
		"\t\t[[],[]]\n" +
		"\t]," +
		"\t\"object\": [\n" +
		"\t{},\n" +
		"\t{\"string\":\"one\"},\n" +
		"\t\t{\"string\":\"one\",\"string2\":\"two\"},\n" +
		"\t\t{\"string\":\"one\",\"number\":3},\n" +
		"\t\t{\"string\":\"one\",\"true\":true},\n" +
		"\t\t{\"string\":\"one\",\"false\":false},\n" +
		"\t\t{\"string\":\"one\",\"null\":null},\n" +
		"\t\t{\"string\":\"one\",\"obj\":{}},\n" +
		"\t\t{\"string\":\"one\",\"array\":[]},\n" +
		"\t{\"number\":2},\n" +
		"\t\t{\"number\":2,\"string\":\"two\"},\n" +
		"\t\t{\"number\":2,\"number2\":3},\n" +
		"\t\t{\"number\":2,\"true\":true},\n" +
		"\t\t{\"number\":2,\"false\":false},\n" +
		"\t\t{\"number\":2,\"null\":null},\n" +
		"\t\t{\"number\":2,\"obj\":{}},\n" +
		"\t\t{\"number\":2,\"array\":[]},\n" +
		"\t{\"true\":true},\n" +
		"\t\t{\"true\":true,\"string\":\"two\"},\n" +
		"\t\t{\"true\":true,\"number\":3},\n" +
		"\t\t{\"true\":true,\"true2\":true},\n" +
		"\t\t{\"true\":true,\"false\":false},\n" +
		"\t\t{\"true\":true,\"null\":null},\n" +
		"\t\t{\"true\":true,\"obj\":{}},\n" +
		"\t\t{\"true\":true,\"array\":[]},\n" +
		"\t{\"false\":false},\n" +
		"\t\t{\"false\":false,\"string\":\"two\"},\n" +
		"\t\t{\"false\":false,\"number\":3},\n" +
		"\t\t{\"false\":false,\"true\":true},\n" +
		"\t\t{\"false\":false,\"false2\":false},\n" +
		"\t\t{\"false\":false,\"null\":null},\n" +
		"\t\t{\"false\":false,\"obj\":{}},\n" +
		"\t\t{\"false\":false,\"array\":[]},\n" +
		"\t{\"null\":null},\n" +
		"\t\t{\"null\":null,\"string\":\"two\"},\n" +
		"\t\t{\"null\":null,\"number\":3},\n" +
		"\t\t{\"null\":null,\"true\":true},\n" +
		"\t\t{\"null\":null,\"false\":false},\n" +
		"\t\t{\"null\":null,\"null2\":null},\n" +
		"\t\t{\"null\":null,\"obj\":{}},\n" +
		"\t\t{\"null\":null,\"array\":[]},\n" +
		"\t{\"obj\":{}},\n" +
		"\t\t{\"obj\":{},\"string\":\"two\"},\n" +
		"\t\t{\"obj\":{},\"number\":3},\n" +
		"\t\t{\"obj\":{},\"true\":true},\n" +
		"\t\t{\"obj\":{},\"false\":false},\n" +
		"\t\t{\"obj\":{},\"null\":null},\n" +
		"\t\t{\"obj\":{},\"obj2\":{}},\n" +
		"\t\t{\"obj\":{},\"array\":[]},\n" +
		"\t{\"array\":[]},\n" +
		"\t\t{\"array\":[],\"string\":\"two\"},\n" +
		"\t\t{\"array\":[],\"number\":3},\n" +
		"\t\t{\"array\":[],\"true\":true},\n" +
		"\t\t{\"array\":[],\"false\":false},\n" +
		"\t\t{\"array\":[],\"null\":null},\n" +
		"\t\t{\"array\":[],\"obj\":{}},\n" +
		"\t\t{\"array\":[],\"array2\":[]}\n" +
		"\t]\n" +
		"}";
}