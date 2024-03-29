package com.rest.api.resources;

import java.security.Principal;
import java.util.Collections;
import java.util.Set;

import com.rest.api.entity.Authority;

public final class AuthenticatedUserDetails implements Principal {

	private final String username;
	private final Set<Authority> authorities;

	public AuthenticatedUserDetails(String username, Set<Authority> authorities) {
		this.username = username;
		this.authorities = Collections.unmodifiableSet(authorities);
	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getName() {
		return username;
	}
}