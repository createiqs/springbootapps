package com.createiq.pw.exceptionhandler;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.createiq.pw.domin.ErrorResponse;
import com.createiq.pw.exception.BookNameNotFoundException;

@ControllerAdvice
public class BookAPIExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<?> noSuchElementException(NoSuchElementException exception) {
		ErrorResponse errorResponse = new ErrorResponse("error", exception.getLocalizedMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BookNameNotFoundException.class)
	public ResponseEntity<?> bookNameNotFoundException(BookNameNotFoundException exception) {
		
		ErrorResponse errorResponse = new ErrorResponse("error", exception.getLocalizedMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}

}
