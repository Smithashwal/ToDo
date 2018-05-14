package com.todo.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.todo.model.UserAuthenticationToken;
import com.todo.model.Users;
import com.todo.service.UserAuthenticationTokenService;

@Path("/token")
public class UserAuthenticationTokenResource {

	@Autowired
	UserAuthenticationTokenService tokenService;
	
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserAuthenticationToken getTokenById(@PathParam("id") long tokenId) {
		return tokenService.getByTokenId(tokenId);
	}
	
	@GET
	@Path("/tokentest/{tokenString}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserAuthenticationToken getToken(@PathParam("tokenString") String token) {
		return tokenService.getByToken(token);
	}
	
	@POST
	@Path("/inserttoken")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void setToken(UserAuthenticationToken token) {
		tokenService.save(token);
	}
}
