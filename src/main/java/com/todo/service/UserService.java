package com.todo.service;

import com.todo.model.Users;

public interface UserService {
	
	public Users saveUser(Users user);
	
	public Users getByUserId(long userid);

}
