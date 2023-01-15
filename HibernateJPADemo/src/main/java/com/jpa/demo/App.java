package com.jpa.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App {
	public static void main(String[] args) {
		User user = new User("Pritam Ray", "Ropar", "45000");
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trx = session.beginTransaction();
		session.save(user);
		 trx.commit();
	}
}
