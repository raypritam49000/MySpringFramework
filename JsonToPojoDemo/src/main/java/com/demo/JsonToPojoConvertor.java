package com.demo;

import com.google.gson.Gson;

import javainuse.Root;

public class JsonToPojoConvertor {
	public static void main(String[] args) {
		String data = "{\r\n" + "	\"id\": \"0001\",\r\n" + "	\"type\": \"donut\",\r\n" + "	\"name\": \"Cake\",\r\n"
				+ "	\"ppu\": 0.55,\r\n" + "	\"batters\":\r\n" + "		{\r\n" + "			\"batter\":\r\n"
				+ "				[\r\n" + "					{ \"id\": \"1001\", \"type\": \"Regular\" },\r\n"
				+ "					{ \"id\": \"1002\", \"type\": \"Chocolate\" },\r\n"
				+ "					{ \"id\": \"1003\", \"type\": \"Blueberry\" },\r\n"
				+ "					{ \"id\": \"1004\", \"type\": \"Devil's Food\" }\r\n" + "				]\r\n"
				+ "		},\r\n" + "	\"topping\":\r\n" + "		[\r\n"
				+ "			{ \"id\": \"5001\", \"type\": \"None\" },\r\n"
				+ "			{ \"id\": \"5002\", \"type\": \"Glazed\" },\r\n"
				+ "			{ \"id\": \"5005\", \"type\": \"Sugar\" },\r\n"
				+ "			{ \"id\": \"5007\", \"type\": \"Powdered Sugar\" },\r\n"
				+ "			{ \"id\": \"5006\", \"type\": \"Chocolate with Sprinkles\" },\r\n"
				+ "			{ \"id\": \"5003\", \"type\": \"Chocolate\" },\r\n"
				+ "			{ \"id\": \"5004\", \"type\": \"Maple\" }\r\n" + "		]\r\n" + "}\r\n"
				+ "                               ";

		Gson gson = new Gson();
		Root root = gson.fromJson(data, Root.class);
		System.out.println(root);
		System.out.println(root.getTopping());
		System.out.println(root.getBatters());

	}
}
