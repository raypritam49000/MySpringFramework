package com.rest.services;

import com.rest.entity.User;
import com.rest.repository.UserRepositoryImpl;

public class UserServiceImpl implements UserService{
	
	private UserRepositoryImpl userRepository = new UserRepositoryImpl();

	@Override
	public User getUserByUsername(String username) {
		return this.userRepository.getUserByUsername(username);
	}

	@Override
	public Boolean createUser(User user) {
		return this.userRepository.createUser(user);
	}

}
