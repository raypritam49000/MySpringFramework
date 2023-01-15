package com.cache.demo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class HibernateUtils {

	public static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		try {
			if (sessionFactory == null) {
				Configuration cfg = new Configuration();
				// Database Configuartion
				cfg.setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				cfg.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/test");
				cfg.setProperty(Environment.USER, "root");
				cfg.setProperty(Environment.PASS, "1998");

				// Hibernate Configuration
				cfg.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
				cfg.setProperty(Environment.SHOW_SQL, "true");
				cfg.setProperty(Environment.FORMAT_SQL, "true");
				cfg.setProperty(Environment.HBM2DDL_AUTO, "update");
				cfg.setProperty(Environment.USE_SECOND_LEVEL_CACHE, "true");
				cfg.setProperty(Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.ehcache.EhCacheRegionFactory");

				// Mapping Entity Class
				cfg.addAnnotatedClass(Employee.class);
				// cfg.addAnnotatedClass(User.class);

				SessionFactory sessionFactory = cfg.buildSessionFactory();

				return sessionFactory;
			} else {
				return sessionFactory;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sessionFactory;
	}
}
