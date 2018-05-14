package com.todo.service;

import java.util.List;

import com.todo.model.ToDo;

public interface ToDoService {

	public ToDo save(ToDo todo);
	
	public ToDo findByToDoId(long todoid);
	
	public List<ToDo> getAllTitleAndActiveStatus(String title);
	
	public List<ToDo> getAllTitleAndInactiveStatus(String title);
	
}
