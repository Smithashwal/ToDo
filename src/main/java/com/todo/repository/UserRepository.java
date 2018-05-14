package com.todo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Serializable>{

	public Users findByUserid(long id);
	
	public List<Users> findByUsernameAndPassword(String username, String password);
	
	public Users findByEmail(String emailId);
	
	
}
