package com.cache.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class App {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		System.out.println(factory);

		Session session1 = factory.openSession();
		Employee emp1 = (Employee) session1.load(Employee.class, 1);
		System.out.println(emp1.getId() + " " + emp1.getName() + " " + emp1.getSalary());
		session1.close();

		Session session2 = factory.openSession();
		Employee emp2 = (Employee) session2.load(Employee.class, 1);
		System.out.println(emp2.getId() + " " + emp2.getName() + " " + emp2.getSalary());
		session2.close();
		
		Session session3 = factory.openSession();
		Employee emp3 = (Employee) session3.load(Employee.class, 1);
		System.out.println(emp3.getId() + " " + emp3.getName() + " " + emp3.getSalary());
		session2.close();
		
		Session session4 = factory.openSession();
		Employee emp4 = (Employee) session4.load(Employee.class, 1);
		System.out.println(emp4.getId() + " " + emp4.getName() + " " + emp4.getSalary());
		session2.close();
	}
}
