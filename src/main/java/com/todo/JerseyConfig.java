package com.todo;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.todo.exception.GenericExceptionMapper;
import com.todo.exception.TodoExceptionMapper;
import com.todo.resource.AddressResource;
import com.todo.resource.DemoData;
import com.todo.resource.LoginResource;
import com.todo.resource.ToDoResource;
import com.todo.resource.UserAuthenticationTokenResource;
import com.todo.resource.UserResource;
import com.todo.service.TodoAppWebServiceFilter;

@Component
public class JerseyConfig extends ResourceConfig{

	public JerseyConfig() {
		register(UserResource.class);
		register(ToDoResource.class);
		register(AddressResource.class);
		register(DemoData.class);
		register(TodoExceptionMapper.class);
		register(GenericExceptionMapper.class);
		register(UserAuthenticationTokenResource.class);
		register(TodoAppWebServiceFilter.class);
		register(LoginResource.class);
	}
	
}
