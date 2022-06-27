package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.RegisterDao;
import com.demo.entity.User;

@Service
public class RegisterServicesImpl implements RegisterServices{
	
	@Autowired
	private RegisterDao registerDao;

	public int saveUser(User user) {
		return this.registerDao.saveUser(user);
	}

}
