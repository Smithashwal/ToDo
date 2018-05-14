package com.todo.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class TodoExceptionMapper implements ExceptionMapper<ToDoAppException>{

	@Override
	public Response toResponse(ToDoAppException exception) {
		return Response.status(500).entity(exception.getErrorResponse()).type(MediaType.APPLICATION_JSON).build();
	}

	
	
}
