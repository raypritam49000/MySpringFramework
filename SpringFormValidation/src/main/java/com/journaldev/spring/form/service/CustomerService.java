package com.journaldev.spring.form.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Service;

import com.journaldev.spring.form.model.Customer;


@Service
public class CustomerService {
	
	@Autowired
	 HibernateTemplate hibernateTemplate;
	
	@Autowired
	HibernateTransactionManager transactionManager;
	
	
	public boolean save(Customer customer) {
		int id=(Integer) this.hibernateTemplate.save(customer);
		if(id>0) {
			return true;
		}else
		return false;
	}
	
	
	
	
	
}
