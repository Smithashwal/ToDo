package com.todo.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.enom.RecordStatus;
import com.todo.model.ToDo;
import com.todo.model.Users;

@Repository
public interface TodoRepository extends JpaRepository<ToDo, Serializable>{

	public ToDo findByToDoId(long id);
	
	public List<ToDo> findByStatusAndUser(Users user,RecordStatus status );
	
	public List<ToDo> findByUserAndRemindDateTime(Users user, Date remindDateTime);
	
	public List<ToDo> findByTitleAndStatus(String title, RecordStatus status);
	
	
}
