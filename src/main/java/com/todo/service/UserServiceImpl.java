package com.todo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.model.Users;
import com.todo.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public Users saveUser(Users user) {
	  return userRepository.save(user);
	}

	@Override
	public Users getByUserId(long userid) {
		return userRepository.findByUserid(userid);
	}

	
}
