package com.rest.api.dbconfig;

public interface DBINFO {
	public static final String DRIVER = PropertyReaderValue.getValue("db.driver");
	public static final String URL = PropertyReaderValue.getValue("db.url");
	public static final String USERNAME = PropertyReaderValue.getValue("db.username");
	public static final String PASSWORD = PropertyReaderValue.getValue("db.password");
}
