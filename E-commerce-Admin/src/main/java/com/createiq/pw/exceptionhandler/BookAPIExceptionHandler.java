package com.createiq.pw.exceptionhandler;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.createiq.pw.domin.ErrorResponse;
import com.createiq.pw.exception.BookNameNotFoundException;

@ControllerAdvice
public class BookAPIExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		//ErrorResponse error = new ErrorResponse("validation Error", ex.getBindingResult().toString());

		
		 List<ErrorResponse> errorMessages = ex.getBindingResult().getFieldErrors().stream()
		            .map(err -> new ErrorResponse(err.getField(), err.getDefaultMessage()))
		            .collect(Collectors.toList());
		
		return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
	}

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
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exception(Exception exception) {
		ErrorResponse errorResponse = new ErrorResponse("error", exception.getLocalizedMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}

}
