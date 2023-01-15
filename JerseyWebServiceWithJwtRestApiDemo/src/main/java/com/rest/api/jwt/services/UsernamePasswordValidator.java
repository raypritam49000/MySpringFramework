package com.rest.api.jwt.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.rest.api.entity.User;
import com.rest.api.exception.AuthenticationException;

/**
 * Component for validating user credentials.
 *
 * @author cassiomolin
 */
@ApplicationScoped
public class UsernamePasswordValidator {

	@Inject
	private UserService userService;

	@Inject
	private PasswordEncoder passwordEncoder;

	/**
	 * Validate username and password.
	 *
	 * @param username
	 * @param password
	 * @return
	 */
	public User validateCredentials(String username, String password) {

		User user = userService.findByUsernameOrEmail(username);

		if (user == null) {
//            // User cannot be found with the given username/email
			throw new AuthenticationException("Bad credentials.");
		}

		if (!user.isActive()) {
			// User is not active
			throw new AuthenticationException("The user is inactive.");
		}

		if (!passwordEncoder.checkPassword(password, user.getPassword())) {
			// Invalid password
			throw new AuthenticationException("Bad credentials.");
		}

		return user;

	}
}