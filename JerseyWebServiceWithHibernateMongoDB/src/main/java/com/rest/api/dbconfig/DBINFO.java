package com.rest.api.dbconfig;

public interface DBINFO {
	public static final String PROVIDER = PropertyReaderValue.getValue("hibernate.ogm.datastore.provider");
	public static final String DIALECT = PropertyReaderValue.getValue("hibernate.ogm.datastore.dialect");
	public static final String HOST = PropertyReaderValue.getValue("hibernate.ogm.mongodb.host");
	public static final String PORT = PropertyReaderValue.getValue("hibernate.ogm.mongodb.port");
	public static final String DATABASE_NAME = PropertyReaderValue.getValue("hibernate.ogm.datastore.database");
	public static final String CREATE_DATABASE = PropertyReaderValue.getValue("hibernate.ogm.datastore.create_database");
}
