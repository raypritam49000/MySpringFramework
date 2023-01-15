package com.rest.api.controller;

import java.util.Map;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import com.rest.api.entity.User;
import com.rest.api.jwt.services.AuthenticationTokenService;
import com.rest.api.jwt.services.UsernamePasswordValidator;
import com.rest.api.models.AuthenticationToken;
import com.rest.api.models.UserCredentials;
import com.rest.api.resources.AuthenticationTokenDetails;
import com.rest.api.resources.TokenBasedSecurityContext;

@Path("auth")
public class AuthenticationController {

	@Context
	private SecurityContext securityContext;

	@Inject
	private UsernamePasswordValidator usernamePasswordValidator;

	@Inject
	private AuthenticationTokenService authenticationTokenService;

	/**
	 * Validate user credentials and issue a token for the user.
	 *
	 * @param credentials
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@PermitAll
	public Response authenticate(UserCredentials credentials) {

		try {
			System.out.println(credentials);

			User user = usernamePasswordValidator.validateCredentials(credentials.getUsername(),
					credentials.getPassword());
			String token = authenticationTokenService.issueToken(user.getUsername(), user.getAuthorities());
			AuthenticationToken authenticationToken = new AuthenticationToken();
			authenticationToken.setToken(token);
			return Response.ok(authenticationToken).build();

		} catch (Exception e) {
			return Response.ok(Map.of("message", e.getMessage(), "success", false)).build();
		}
	}

	/**
	 * Refresh the authentication token for the current user.
	 *
	 * @return
	 */
	@POST
	@Path("refresh")
	@Produces(MediaType.APPLICATION_JSON)
	public Response refresh() {

		AuthenticationTokenDetails tokenDetails = ((TokenBasedSecurityContext) securityContext)
				.getAuthenticationTokenDetails();
		String token = authenticationTokenService.refreshToken(tokenDetails);

		AuthenticationToken authenticationToken = new AuthenticationToken();
		authenticationToken.setToken(token);
		return Response.ok(authenticationToken).build();
	}
}
