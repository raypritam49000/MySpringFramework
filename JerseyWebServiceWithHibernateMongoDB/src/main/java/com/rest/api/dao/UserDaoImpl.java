package com.rest.api.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.rest.api.dbconfig.SessionFactoryProvider;
import com.rest.api.entity.User;

public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

	@Override
	public Boolean createUser(User user) {
		boolean result = false;
		Session session = sessionFactory.openSession();
		System.out.println(session);
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		result = true;
		return result;
	}

	@Override
	public Boolean updateUser(String id, User user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		User existingUser = session.get(User.class, id);
		
		if(existingUser!=null && !existingUser.getName().equals("")) {
			existingUser.setEmail(user.getEmail());
			existingUser.setName(user.getName());
			session.save(existingUser);
			transaction.commit();
			return true;
		}
		
		return false;
	}

	@Override
	public Boolean deleteUser(String id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		User user = session.get(User.class, id);
		if (user != null && !user.getName().equals("")) {
			session.delete(user);
			transaction.commit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public User getUserById(String id) {
		Session session = sessionFactory.openSession();
		User user = session.get(User.class, id);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		Session session = sessionFactory.openSession();
		System.out.println(session);
		List<User> users = session.createQuery("FROM User",User.class).getResultList();
		return users;
	}

}
