package com.hdfc.capstone.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hdfc.capstone.exception.EmployeeIdException;
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(EmployeeIdException.class)
	  public ResponseEntity<String> exceptionHandler(EmployeeIdException e) {
	    return new ResponseEntity<String>("Invalid Employee Id", HttpStatus.EXPECTATION_FAILED);
	  }

}
