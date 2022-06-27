package com.rest.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.rest.db.config.EntityManagerProvider;
import com.rest.entity.User;

public class UserRepositoryImpl implements UserRepository {

	@Override
	public User getUserByUsername(String username) {

		EntityManager entityManager = EntityManagerProvider.getEntityManager();

		Query query = entityManager.createQuery("FROM User where username=: username");
		query.setParameter("username", username);

		User user = (User) query.getSingleResult();
		return user;
	}

	@Override
	public Boolean createUser(User user) {
		EntityManager entityManager = EntityManagerProvider.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		return true;
	}

}
