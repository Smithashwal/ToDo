package com.todo.service;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Autowired;

@Provider
public class TodoAppWebServiceFilter implements ContainerRequestFilter, ContainerResponseFilter {

	@Autowired
	UserAuthenticationTokenService tokenService;

	@Override
	public void filter(ContainerRequestContext request, ContainerResponseContext response) throws IOException {
	}

	@Override
	public void filter(ContainerRequestContext request) throws IOException {
		if(!request.getUriInfo().getPath().contains("demodata") && !request.getUriInfo().getPath().contains("login")) {
			if(!tokenService.isValidToken(request.getHeaderString("tokenString"))) {
				request.abortWith(Response.status(401).build());
			}
		}
		
	}

}
