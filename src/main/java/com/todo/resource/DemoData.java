package com.todo.resource;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.todo.enom.RecordStatus;
import com.todo.exception.ToDoAppException;
import com.todo.exception.TransactionInfo;
import com.todo.model.Address;
import com.todo.model.ToDo;
import com.todo.model.UserAuthenticationToken;
import com.todo.model.Users;
import com.todo.repository.AddressRepository;
import com.todo.repository.TodoRepository;
import com.todo.repository.UserRepository;
import com.todo.service.AddressService;
import com.todo.service.ToDoService;
import com.todo.service.UserAuthenticationTokenService;
import com.todo.service.UserService;

@Path("/demodata")
public class DemoData {

	@Autowired
	UserService userService;

	@Autowired
	ToDoService toDoService;

	@Autowired
	AddressService addressService;

	@Autowired
	UserAuthenticationTokenService tokenService;

	@POST
	public Response addDummyData() {
		Users user = new Users();
		user.setUsername("SMitha");
		user.setEmail("s");
		user.setPassword("ashu");
		user = userService.saveUser(user);

		ToDo todo = new ToDo();
		todo.setTitle("T");
		todo.setDescription("dshjdhj");

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.MINUTE, 1);
		todo.setRemindDateTime(calendar.getTime());

		todo.setUser(user);
		toDoService.save(todo);

		Address address = new Address();
		address.setHouseNumber(1234);
		address.setCity("Tumkur");
		address.setState("karnataka");
		address.setUser(user);
		addressService.save(address);

		UserAuthenticationToken token = new UserAuthenticationToken();
		token.setToken("ABCD");
		token.setExpiryDateTime(new Date(2018, 4, 10));
		token.setStatus(RecordStatus.ACTIVE);
		token.setUser(user);
		tokenService.save(token);

		return Response.status(200).build();
	}

}
