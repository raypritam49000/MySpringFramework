package com.rest.api.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import com.rest.api.entity.User;
import com.rest.api.jwt.services.UserService;
import com.rest.api.models.QueryUserResult;


@Path("users")
public class UserResource {

	@Context
	private UriInfo uriInfo;

	@Context
	private SecurityContext securityContext;

    @Inject
    private UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"ADMIN"})
    public Response getUsers() {

        List<QueryUserResult> queryUserResults = userService.findAll().stream()
                .map(this::toQueryUserResult)
                .collect(Collectors.toList());

        return Response.ok(queryUserResults).build();
    }

    @GET
    @Path("{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"ADMIN"})
    public Response getUser(@PathParam("userId") Long userId) {

        User user = userService.findById(userId).orElseThrow(NotFoundException::new);
        QueryUserResult queryUserResult = toQueryUserResult(user);
        return Response.ok(queryUserResult).build();
    }

    @GET
    @Path("me")
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public Response getAuthenticatedUser() {

        Principal principal = securityContext.getUserPrincipal();

        if (principal == null) {
            QueryUserResult queryUserResult = new QueryUserResult();
            queryUserResult.setUsername("anonymous");
            queryUserResult.setAuthorities(new HashSet<>());
            return Response.ok(queryUserResult).build();
        }

        User user = userService.findByUsernameOrEmail(principal.getName());
        QueryUserResult queryUserResult = toQueryUserResult(user);
        return Response.ok(queryUserResult).build();
    }

	/**
	 * Maps a {@link User} instance to a {@link QueryUserResult} instance.
	 *
	 * @param user
	 * @return
	 */
	private QueryUserResult toQueryUserResult(User user) {
		QueryUserResult queryUserResult = new QueryUserResult();
		queryUserResult.setId(user.getId());
		queryUserResult.setFirstName(user.getFirstName());
		queryUserResult.setLastName(user.getLastName());
		queryUserResult.setEmail(user.getEmail());
		queryUserResult.setUsername(user.getUsername());
		queryUserResult.setAuthorities(user.getAuthorities());
		queryUserResult.setActive(user.isActive());
		return queryUserResult;
	}
}