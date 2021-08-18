package com.createiq.pw.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NO_CONTENT)
public class BookNameNotFoundException extends RuntimeException {

	public BookNameNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookNameNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public BookNameNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BookNameNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BookNameNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
