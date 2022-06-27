package com.rest.api.dbconfig;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rest.api.entity.User;

public class SessionFactoryProvider {

	public static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		try {

			if (sessionFactory == null) {
				Configuration cfg = new Configuration();
				cfg.addAnnotatedClass(User.class);
				cfg.setProperty("hibernate.connection.driver_class", DBINFO.DRIVER);
				cfg.setProperty("hibernate.connection.url", DBINFO.URL);
				cfg.setProperty("hibernate.connection.username", DBINFO.USERNAME);
				cfg.setProperty("hibernate.connection.password", DBINFO.PASSWORD);
				cfg.setProperty("hibernate.dialect", DBINFO.DIALECT);
				cfg.setProperty("hibernate.show_sql", DBINFO.SHOW_SQL);
				cfg.setProperty("hibernate.format_sql", DBINFO.FORMAT_SQL);
				cfg.setProperty("hibernate.hbm2ddl.auto", DBINFO.HBM2DDL_AUTO);

				sessionFactory = cfg.buildSessionFactory();

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
