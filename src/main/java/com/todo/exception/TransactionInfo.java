package com.todo.exception;

import org.springframework.stereotype.Component;

import com.todo.enom.NotificationType;

@Component
public class TransactionInfo {

	public void generateToDoException(String message, int statusCode, NotificationType notificationType) {
		throw new ToDoAppException(message, statusCode, notificationType);
	}
}
