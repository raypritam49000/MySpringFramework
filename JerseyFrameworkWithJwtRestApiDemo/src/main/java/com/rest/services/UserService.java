package com.rest.services;

import com.rest.entity.User;

public interface UserService {
	public abstract User getUserByUsername(String username);
	public abstract Boolean createUser(User user);
}
