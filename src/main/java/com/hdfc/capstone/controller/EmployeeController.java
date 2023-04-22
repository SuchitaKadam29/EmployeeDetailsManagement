package com.hdfc.capstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.capstone.entity.Employee;
import com.hdfc.capstone.exception.EmployeeIdException;
import com.hdfc.capstone.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	IEmployeeService service;

	@GetMapping("/{employeeId}")
	public Employee getEmployeeById(int employeeId) throws EmployeeIdException {

		return service.getEmployeeById(employeeId);

	}

}
