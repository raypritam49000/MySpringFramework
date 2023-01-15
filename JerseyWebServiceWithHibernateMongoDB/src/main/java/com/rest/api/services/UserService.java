package com.rest.api.services;

import java.util.List;

import com.rest.api.entity.User;

public interface UserService {
	public abstract Boolean createUser(User user);
	public abstract Boolean updateUser(String id, User user);
	public abstract Boolean deleteUser(String id);
	public abstract User getUserById(String id);
	public abstract List<User> getAllUsers();
	
}
