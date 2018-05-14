package com.todo.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.todo.model.Users;
import com.todo.service.UserService;

@Path("/users")
public class UserResource {

	@Autowired
	UserService userService;
	// UserRepository userRepository;

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserId(@PathParam("id") long userid) {
		return Response.status(200).entity(userService.getByUserId(userid)).build();
	}

	@POST
	@Path("/insertuser")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void setUser(Users user) {
		userService.saveUser(user);
	}

}
