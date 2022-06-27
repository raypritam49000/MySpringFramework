package com.rest.api.dbconfig;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.ogm.cfg.OgmConfiguration;

import com.rest.api.entity.User;

public class SessionFactoryProvider {

	public static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		try {

			if (sessionFactory == null) {
				
				Configuration configuration = new OgmConfiguration();
 
				configuration.setProperty("hibernate.ogm.datastore.provider",DBINFO.PROVIDER);
				configuration.setProperty("hibernate.ogm.datastore.dialect", DBINFO.DIALECT);
				configuration.setProperty("hibernate.ogm.mongodb.host", DBINFO.HOST);
				configuration.setProperty("hibernate.ogm.mongodb.port", DBINFO.PORT);
				configuration.setProperty("hibernate.ogm.datastore.database", DBINFO.DATABASE_NAME);
				configuration.setProperty("hibernate.ogm.datastore.create_database", DBINFO.CREATE_DATABASE);
				
				configuration.addAnnotatedClass(User.class);
				
				sessionFactory = configuration.buildSessionFactory();
				
				return sessionFactory;
			} else {
				return sessionFactory;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sessionFactory;
	}

	public static void main(String[] args) {
		System.out.println(getSessionFactory());
	}
}
