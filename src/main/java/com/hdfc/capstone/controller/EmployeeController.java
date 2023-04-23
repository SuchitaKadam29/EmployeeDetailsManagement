package com.hdfc.capstone.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.capstone.entity.Employee;
import com.hdfc.capstone.exception.EmployeeIdException;
import com.hdfc.capstone.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private static final Logger logger= LoggerFactory.getLogger(EmployeeController.class);


	@Autowired
	IEmployeeService empService;

	@GetMapping("/getEmployeebyId/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) throws EmployeeIdException {
		logger.info("Employee by ("+employeeId+")employeeId is called");
		return empService.getEmployeeById(employeeId);

	}

}

