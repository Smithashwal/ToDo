package com.todo.exception;

import com.todo.enom.NotificationType;

public class ToDoAppException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ErrorResponse errorResponse;
	
	
	public ToDoAppException(String errorMsg, int statusCode, NotificationType notificationType) {
		errorResponse = new ErrorResponse();
		errorResponse.setErrorMsg(errorMsg);
		errorResponse.setStatusCode(statusCode);
		errorResponse.setNotificationType(notificationType);
	}

	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(ErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}
	
	
}
