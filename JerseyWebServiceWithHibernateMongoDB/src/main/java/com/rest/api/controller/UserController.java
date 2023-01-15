package com.rest.api.controller;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rest.api.entity.User;
import com.rest.api.services.UserService;
import com.rest.api.services.UserServiceImpl;

@Path("/users")
public class UserController {

	private UserService userService = new UserServiceImpl();

	@GET
	@Path("/getAllUsers")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response fetchAll() {
		try {
			List<User> users = userService.getAllUsers();
			if (users != null && users.size() > 0) {
				return Response.status(Response.Status.OK)
						.entity(Map.of("message", "User List", "body", users, "success", true))
						.type(MediaType.APPLICATION_JSON).build();
			} else {
				return Response.status(Response.Status.NOT_FOUND)
						.entity(Map.of("message", "DATA NOT FOUND", "body", users, "success", false))
						.type(MediaType.APPLICATION_JSON).build();
			}
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(Map.of("message", e.getMessage(), "success", false)).type(MediaType.APPLICATION_JSON)
					.build();
		}
	}

	@GET
	@Path("/getUserById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("id") String id) {
		try {
			User user = userService.getUserById(id);

			if (user != null && !user.getEmail().equals("")) {
				return Response.status(Response.Status.OK)
						.entity(Map.of("message", "User List", "body", user, "success", true))
						.type(MediaType.APPLICATION_JSON).build();
			} else {
				return Response.status(Response.Status.NOT_FOUND)
						.entity(Map.of("message", "DATA NOT FOUND", "body", user, "success", false))
						.type(MediaType.APPLICATION_JSON).build();
			}

		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(Map.of("message", e.getMessage(), "success", false)).type(MediaType.APPLICATION_JSON)
					.build();
		}
	}

	@POST
	@Path("/createUser")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(User user) {
		try {
			if (user != null && !user.getEmail().equals("")) {
				Boolean isSaved = this.userService.createUser(user);

				if (isSaved) {
					return Response.status(Response.Status.OK)
							.entity(Map.of("message", "Create User Successfully", "success", true))
							.type(MediaType.APPLICATION_JSON).build();
				} else {
					return Response.status(Response.Status.BAD_REQUEST)
							.entity(Map.of("message", "All Fields are required!!", "success", false))
							.type(MediaType.APPLICATION_JSON).build();
				}

			} else {
				return Response.status(Response.Status.BAD_REQUEST)
						.entity(Map.of("message", "BAD_REQUEST", "success", false)).type(MediaType.APPLICATION_JSON)
						.build();
			}
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(Map.of("message", e.getMessage(), "success", false)).type(MediaType.APPLICATION_JSON)
					.build();
		}
	}

	@PUT
	@Path("/updateUser/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") String id, User user) {
		try {
			if (id!=null && user != null && !user.getEmail().equals("")) {
				Boolean isUpdated = this.userService.updateUser(id, user);

				if (isUpdated) {
					return Response.status(Response.Status.OK)
							.entity(Map.of("message", "User Updated", "success", true))
							.type(MediaType.APPLICATION_JSON).build();
				} else {
					return Response.status(Response.Status.BAD_REQUEST)
							.entity(Map.of("message", "Error can occur while update user", "success", false))
							.type(MediaType.APPLICATION_JSON).build();
				}
			}
			else {
				return Response.status(Response.Status.BAD_REQUEST)
						.entity(Map.of("message", "All Fields are required!!", "success", false))
						.type(MediaType.APPLICATION_JSON).build();	
			}

		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(Map.of("message", e.getMessage(), "success", false)).type(MediaType.APPLICATION_JSON)
					.build();
		}
	}

	@DELETE
	@Path("/deleteUser/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") String id) {
		try {
			if (id != null) {
				Boolean isDeleted = this.userService.deleteUser(id);

				if (isDeleted) {
					return Response.status(Response.Status.OK)
							.entity(Map.of("message", "User Deleted", "success", true)).type(MediaType.APPLICATION_JSON)
							.build();
				} else {
					return Response.status(Response.Status.BAD_REQUEST)
							.entity(Map.of("message", "Error can occure while delete User !!!", "success", false))
							.type(MediaType.APPLICATION_JSON).build();
				}
			} else {
				return Response.status(Response.Status.BAD_REQUEST)
						.entity(Map.of("message", "Id are required!!", "success", false))
						.type(MediaType.APPLICATION_JSON).build();
			}
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(Map.of("message", e.getMessage(), "success", false)).type(MediaType.APPLICATION_JSON)
					.build();
		}

	}
}
