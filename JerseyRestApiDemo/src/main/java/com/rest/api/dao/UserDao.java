package com.rest.api.dao;

import java.util.List;

import com.rest.api.entity.User;

public interface UserDao {
	public abstract Boolean createUser(User user);
	public abstract Boolean updateUser(Long id, User user);
	public abstract Boolean deleteUser(Long id);
	public abstract User getUserById(Long id);
	public abstract List<User> getAllUsers();
}
