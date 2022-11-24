package com.fronchak.domain.exceptions.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fronchak.domain.exceptions.ExceptionResponse;
import com.fronchak.domain.exceptions.ResourceNotFoundException;

@RestController
@ControllerAdvice
public class CustomizeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception e, WebRequest request) {
		ExceptionResponse response = makeResponse(e, request);
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	private ExceptionResponse makeResponse(Exception e, WebRequest request) {
		ExceptionResponse response = new ExceptionResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setMessage(e.getMessage());
		response.setDetails(request.getDescription(false));
		return response;
	}
	
	@ExceptionHandler(ResourceNotFoundException.class) 
	public final ResponseEntity<ExceptionResponse> handleResourceNotFoundException(ResourceNotFoundException e, WebRequest request) {
		ExceptionResponse response = makeResponse(e, request);
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
	
}
