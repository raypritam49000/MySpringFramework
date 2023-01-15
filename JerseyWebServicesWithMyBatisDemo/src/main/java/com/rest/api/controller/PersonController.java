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

import com.mybatis.model.Person;
import com.mybatis.services.PersonService;
import com.mybatis.services.impl.PersonServiceImpl;

@Path("/persons")
public class PersonController {

	private PersonService personService = new PersonServiceImpl();

	@GET
	@Path("/getAllPersons")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response fetchAll() {
		try {
			List<Person> persons = personService.getAllPersons();
			if (persons != null && persons.size() > 0) {
				return Response.status(Response.Status.OK)
						.entity(Map.of("message", "Person List", "body", persons, "success", true))
						.type(MediaType.APPLICATION_JSON).build();
			} else {
				return Response.status(Response.Status.NOT_FOUND)
						.entity(Map.of("message", "DATA NOT FOUND", "body", persons, "success", false))
						.type(MediaType.APPLICATION_JSON).build();
			}
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(Map.of("message", e.getMessage(), "success", false)).type(MediaType.APPLICATION_JSON)
					.build();
		}
	}

	@GET
	@Path("/getPersonById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getPerson(@PathParam("id") Integer id) {
		try {
			// User user = userService.getUserById(id);
			Person person = personService.getPerson(id);

			if (person != null && !person.getName().equals("")) {
				return Response.status(Response.Status.OK)
						.entity(Map.of("message", "Person List", "body", person, "success", true))
						.type(MediaType.APPLICATION_JSON).build();
			} else {
				return Response.status(Response.Status.NOT_FOUND)
						.entity(Map.of("message", "DATA NOT FOUND", "body", person, "success", false))
						.type(MediaType.APPLICATION_JSON).build();
			}

		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(Map.of("message", e.getMessage(), "success", false)).type(MediaType.APPLICATION_JSON)
					.build();
		}
	}

	@POST
	@Path("/createPerson")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createPerson(Person person) {
		try {
			if (person != null && !person.getName().equals("")) {
				Boolean isSaved = this.personService.save(person);

				if (isSaved) {
					return Response.status(Response.Status.OK)
							.entity(Map.of("message", "Create Person Successfully", "success", true))
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
	@Path("/updatePerson/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(Person person) {
		try {
			if (person != null && person.getId() != null && !person.getName().equals("")) {
				Boolean isUpdated = this.personService.updatePerson(person);

				if (isUpdated) {
					return Response.status(Response.Status.OK)
							.entity(Map.of("message", "Person Updated", "success", true))
							.type(MediaType.APPLICATION_JSON).build();
				} else {
					return Response.status(Response.Status.BAD_REQUEST)
							.entity(Map.of("message", "Error can occur while update user", "success", false))
							.type(MediaType.APPLICATION_JSON).build();
				}
			} else {
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
	@Path("/deletePerson/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") Integer id) {
		try {
			if (id != null) {
				Boolean isDeleted = this.personService.deletePersonById(id);

				if (isDeleted) {
					return Response.status(Response.Status.OK)
							.entity(Map.of("message", "Person Deleted", "success", true))
							.type(MediaType.APPLICATION_JSON).build();
				} else {
					return Response.status(Response.Status.BAD_REQUEST)
							.entity(Map.of("message", "Error can occure while delete Person !!!", "success", false))
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
