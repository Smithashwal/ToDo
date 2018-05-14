package com.todo.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.todo.model.Users;
import com.todo.service.LoginService;

@Path("/login")
public class LoginResource {

	@Autowired
	LoginService loginService;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AuthenticateEmailIdPassword(Users user) {
		
		 String generatedToken=loginService.validateEmailPassword(user.getEmail()	, user.getPassword());
		 return Response.status(200).entity(generatedToken).build();
	}
}

