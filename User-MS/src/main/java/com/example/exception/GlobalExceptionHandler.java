package com.example.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleexception(ResourceNotFoundException exception ,WebRequest webreq)
	{
		//creating instances
		//parameterized cons = >ErrorDetails(LocalDateTime timestamp, String message, String path, String errorCode)
		ErrorDetails err=new ErrorDetails(
				
				LocalDateTime.now(),           
				exception.getMessage(),
				webreq.getDescription(false),
				"USER_NOT_FOUND"
				
				);
				
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(EmailAlreadyExistException.class)
	public ResponseEntity<ErrorDetails> handleemailexp(EmailAlreadyExistException exception,WebRequest webreq)
	{
		ErrorDetails err=new ErrorDetails(
				LocalDateTime.now(),           
				exception.getMessage(),
				webreq.getDescription(false),
				"Email_already_exist");
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	
	//handler for another exceptions other than these 2 exception 
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> globalexp(Exception exception,WebRequest webreq)
	{
		ErrorDetails err=new ErrorDetails(
				LocalDateTime.now(),           
				exception.getMessage(),
				webreq.getDescription(false),
				"Internal_server_error");
		return new ResponseEntity<>(err,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//for validation exceptions
	
	@Override
	    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, 
	                                                                  HttpHeaders headers, 
	                                                                  HttpStatusCode status,
	                                                                  WebRequest request) {
	        Map<String, String> errors = new HashMap<>();
	        List<ObjectError> errorList = ex.getBindingResult().getAllErrors();

	        errorList.forEach((error) ->{
	            String fieldName = ((FieldError) error).getField();
	            String message = error.getDefaultMessage();
	            errors.put(fieldName, message);
	        });

	        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	    }
	
	
}
