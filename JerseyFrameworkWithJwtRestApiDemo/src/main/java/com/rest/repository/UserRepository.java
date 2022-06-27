package com.rest.repository;

import com.rest.entity.User;

public interface UserRepository {
	public abstract User getUserByUsername(String username);
	public abstract Boolean createUser(User user);
}
