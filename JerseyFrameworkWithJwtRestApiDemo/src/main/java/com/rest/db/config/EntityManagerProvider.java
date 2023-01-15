package com.rest.db.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvider {

	public static EntityManager entityManager = null;

	public static synchronized EntityManager getEntityManager() {
		try {
			if (entityManager == null) {
				EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("user");
				entityManager = entityManagerFactory.createEntityManager();
				return entityManager;
			}
			else {
				return entityManager;	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entityManager;
	}

}
