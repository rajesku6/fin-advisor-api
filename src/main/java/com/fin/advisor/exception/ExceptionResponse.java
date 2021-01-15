package com.fin.advisor.exception;

/**
 * @author rajesh.kumar
 * Pojo class for exception response.
 */
public class ExceptionResponse {
	private int statusCode;
	private String message;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
