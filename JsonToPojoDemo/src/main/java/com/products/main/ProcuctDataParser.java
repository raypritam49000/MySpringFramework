package com.products.main;

import java.util.List;

import com.google.gson.Gson;
import com.products.data.Product;

public class ProcuctDataParser {

	public static void main(String[] args) {
		
		
		String products = "[\r\n"
				+ "    {\r\n"
				+ "        \"pid\": 1,\r\n"
				+ "        \"pname\": \"java\",\r\n"
				+ "        \"price\": \"23.4\",\r\n"
				+ "        \"productImageNames\": \"fbicon.png\",\r\n"
				+ "        \"productImageUrl\": \"http://localhost:7000/imagesHub/fbicon.png\",\r\n"
				+ "        \"productImages\": null\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "        \"pid\": 2,\r\n"
				+ "        \"pname\": \"android\",\r\n"
				+ "        \"price\": \"45.6\",\r\n"
				+ "        \"productImageNames\": \"a.jpg\",\r\n"
				+ "        \"productImageUrl\": \"http://localhost:7000/imagesHub/a.jpg\",\r\n"
				+ "        \"productImages\": null\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "        \"pid\": 3,\r\n"
				+ "        \"pname\": \"php\",\r\n"
				+ "        \"price\": \"45.5\",\r\n"
				+ "        \"productImageNames\": \"hqdefault.jpg\",\r\n"
				+ "        \"productImageUrl\": \"http://localhost:7000/imagesHub/hqdefault.jpg\",\r\n"
				+ "        \"productImages\": null\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "        \"pid\": 4,\r\n"
				+ "        \"pname\": \"springboot\",\r\n"
				+ "        \"price\": \"100\",\r\n"
				+ "        \"productImageNames\": \"The Basics of Influencer Marketing (7).png\",\r\n"
				+ "        \"productImageUrl\": \"http://localhost:7000/imagesHub/The Basics of Influencer Marketing (7).png\",\r\n"
				+ "        \"productImages\": null\r\n"
				+ "    }\r\n"
				+ "]";
		
		Gson gson = new Gson();
		List<Product> productList = gson.fromJson(products, List.class);
		System.out.println(productList);
		
	}
	
}
