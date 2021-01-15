package com.fin.advisor.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author rajesh.kumar
 * Controller advice for handling exception.
 */
@ControllerAdvice
public class AppControllerAdvice {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	/**
	 * Global method to handle any sort of exception
	 * @param exception
	 * @return ResponseEntity
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<ExceptionResponse> handleException(Exception exception) {
		ExceptionResponse error = new ExceptionResponse();
		error.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage("Problem in processing request.");
		logger.error(exception.getMessage(), exception);
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * Global method to handle any ApplicationException
	 * @param exception
	 * @return ResponseEntity
	 */
	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<ExceptionResponse> authExceptionHandler(ApplicationException exception) {
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		ExceptionResponse error = new ExceptionResponse();
		error.setStatusCode(exception.getStatusCode());
		error.setMessage(exception.getMessage());
		logger.error(exception.getMessage(), exception);
		if( exception.getStatusCode() == 404) {
			httpStatus = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<>(error, httpStatus);
	}
}
