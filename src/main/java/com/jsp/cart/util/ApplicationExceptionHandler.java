package com.jsp.cart.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.cart.exception.CartNotFoundByIdExpection;

//@RestControllerAdvice
@ControllerAdvice
public class ApplicationExceptionHandler {
	@Autowired
	private ErrorStructure<String> structure;
	//normal way 
//	@ExceptionHandler
//	public ResponseEntity<String> handleCartNotFoundById(CartNotFoundByIdExpection ex) {
//		String msg = ex.getMessage();
//		return new ResponseEntity<String>(msg, HttpStatus.NOT_FOUND);
//	}
	//structure way
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleCartNotFoundById(CartNotFoundByIdExpection ex) {
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage(ex.getMessage());
		structure.setRootCause("The request user with the given Id is not found");
		return new ResponseEntity<ErrorStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	
}
