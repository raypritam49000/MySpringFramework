package com.rest.api.dbconfig;

public interface DBINFO {
	public static final String DRIVER = PropertyReaderValue.getValue("hibernate.connection.driver_class");
	public static final String URL = PropertyReaderValue.getValue("hibernate.connection.url");
	public static final String USERNAME = PropertyReaderValue.getValue("hibernate.connection.username");
	public static final String PASSWORD = PropertyReaderValue.getValue("hibernate.connection.password");
	public static final String DIALECT = PropertyReaderValue.getValue("hibernate.dialect");
	public static final String SHOW_SQL = PropertyReaderValue.getValue("hibernate.show_sql");
	public static final String FORMAT_SQL = PropertyReaderValue.getValue("hibernate.format_sql");
	public static final String HBM2DDL_AUTO = PropertyReaderValue.getValue("hibernate.hbm2ddl.auto");
}
