package com.rest.api.services;

import java.util.List;

import com.rest.api.dao.UserDao;
import com.rest.api.dao.UserDaoImpl;
import com.rest.api.entity.User;

public class UserServiceImpl implements UserService{
	
	private UserDao userDao = new UserDaoImpl();

	@Override
	public Boolean updateUser(Long id, User user) {
		return userDao.updateUser(id, user);
	}

	@Override
	public Boolean deleteUser(Long id) {
		return this.userDao.deleteUser(id);
	}

	@Override
	public User getUserById(Long id) {
		return this.userDao.getUserById(id);
	}

	@Override
	public List<User> getAllUsers() {
		return this.userDao.getAllUsers();
	}

	@Override
	public Boolean createUser(User user) {
		return this.userDao.createUser(user);
	}

}
