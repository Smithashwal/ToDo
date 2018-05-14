package com.todo.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.todo.model.ToDo;
import com.todo.service.ToDoService;

@Path("/todo")
public class ToDoResource {

	@Autowired
	ToDoService toDoService;
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ToDo getTodoById(@PathParam("id") long todoid) {
		return toDoService.findByToDoId(todoid);
	}
	

	
	
}
