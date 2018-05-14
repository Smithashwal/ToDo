package com.todo.service;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo.ToDoTimerTask;
import com.todo.enom.NotificationType;
import com.todo.enom.RecordStatus;
import com.todo.exception.TransactionInfo;
import com.todo.model.ToDo;
import com.todo.model.Users;
import com.todo.repository.TodoRepository;
import com.todo.repository.UserRepository;

@Service
@Transactional
public class ToDoServiceImpl implements ToDoService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	TodoRepository toDoRepository;

	@Autowired
	TransactionInfo transactionInfo;

	@Autowired
	ToDoService toDoService;
	@Autowired
	TodoRepository todoRepository;

	Timer timer = new Timer();

	@Override
	public ToDo save(ToDo todo) {

		Users user = todo.getUser();

		user = userRepository.findByUserid(user.getUserid());
		todo.setUser(user);

		if (todo.getRemindDateTime().before(new Date())) {
			transactionInfo.generateToDoException("Remind Date/time should not be before current date/time", 500,
					NotificationType.ERROR);
			// date/time");
		}

		if (todo.getTitle().isEmpty()) {
			transactionInfo.generateToDoException("Title cannot be empty", 500, NotificationType.ERROR);
		}

		ToDo savedToDo = toDoRepository.save(todo);
		ToDoTimerTask toDoTimerTask = new ToDoTimerTask(savedToDo);

		toDoTimerTask.setTodoRepository(todoRepository);

		timer.schedule(toDoTimerTask, todo.getRemindDateTime());

		return savedToDo;

	}

	@Override
	public ToDo findByToDoId(long todoid) {
		return toDoRepository.findByToDoId(todoid);
	}

	@Override
	public List<ToDo> getAllTitleAndActiveStatus(String title) {
		return toDoRepository.findByTitleAndStatus(title, RecordStatus.ACTIVE);
	}

	@Override
	public List<ToDo> getAllTitleAndInactiveStatus(String title) {
		return toDoRepository.findByTitleAndStatus(title, RecordStatus.INACTIVE);
	}

}
