package com.fin.advisor.exception;

/**
 * @author rajesh.kumar
 * Custom Exception class for application.
 */
public class ApplicationException  extends RuntimeException {

	private static final long serialVersionUID = 312433445556664451L;
	private int statusCode;
	
	public ApplicationException(String message,int statusCode) {
		super(message);
		this.statusCode = statusCode;
	}

	public ApplicationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ApplicationException(String message, Exception exception,int statusCode) {
		super(message, exception);
		this.statusCode = statusCode;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
}
