package com.todo;

import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.todo.enom.RecordStatus;
import com.todo.model.ToDo;
import com.todo.repository.TodoRepository;
import com.todo.service.ToDoService;

public class ToDoTimerTask extends TimerTask {

	@Autowired
	TodoRepository todoRepository;

	ToDo toDo;

	
	public void setTodoRepository(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public ToDoTimerTask(ToDo newToDo) {
		this.toDo = newToDo;
	}

	@Override
	public void run() {

		System.out.println("Sending an email" + toDo.getUser().getEmail() + toDo.getRemindDateTime() + toDo.getTitle());
		toDo.setStatus(RecordStatus.INACTIVE);
		todoRepository.save(toDo);
	}

}
