package com.rest.api.dbconfig;

import java.io.InputStream;
import java.util.Properties;

public class PropertyReaderValue {

	public static String getValue(String key) {
		String value = null;
		try {
			Properties properties = new Properties();
			InputStream in = PropertyReaderValue.class.getClassLoader().getResourceAsStream("db.properties");
			properties.load(in);
			value = properties.getProperty(key.trim());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
}
