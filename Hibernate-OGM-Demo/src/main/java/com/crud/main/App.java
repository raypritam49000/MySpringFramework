package com.crud.main;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.ogm.cfg.OgmConfiguration;

import com.crud.model.User;

public class App {
	public static void main(String[] args) {
		try {

			Configuration configuration = new OgmConfiguration();

			configuration.setProperty("hibernate.ogm.datastore.provider","org.hibernate.ogm.datastore.mongodb.impl.MongoDBDatastoreProvider");
			configuration.setProperty("hibernate.ogm.datastore.dialect", "org.hibernate.ogm.dialect.impl.OgmDialect");
			configuration.setProperty("hibernate.ogm.mongodb.host", "127.0.0.1");
			configuration.setProperty("hibernate.ogm.mongodb.port", "27017");
			configuration.setProperty("hibernate.ogm.datastore.database", "test");
			configuration.setProperty("hibernate.ogm.datastore.create_database", "true");
			
			configuration.addAnnotatedClass(User.class);

			SessionFactory sessionFactory = configuration.buildSessionFactory();

			System.out.println(sessionFactory);

			System.out.println(sessionFactory.openSession());

			Session session = sessionFactory.openSession();

			Transaction transaction = session.beginTransaction();
			session.save(new User("Pritam Ray","Ropar","34000"));
			transaction.commit();
			
			User user = session.get(User.class, "6269089aeb803739ba24d23f");
			System.out.println(user);
			
			List<User> users = session.createQuery("From User").getResultList();
			System.out.println(users);
			
		    users.forEach(user1 -> System.out.println(user));
			
			User user1 = session.find(User.class,"6269089aeb803739ba24d23f" );
			System.out.println(user1);
			
			EntityManager em = session.getEntityManagerFactory().createEntityManager();
			System.out.println(em);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
