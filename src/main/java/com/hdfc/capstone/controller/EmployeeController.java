package com.hdfc.capstone.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.capstone.service.IEmployeeService;
import com.hdfc.capstone.vo.EmployeeVO;

import lombok.extern.slf4j.Slf4j;


/*
 * Author -suchita kadam
 * created on - 22/04/2023
 */
@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {
	
	private static final Logger logger= LoggerFactory.getLogger(EmployeeController.class);


	@Autowired
	IEmployeeService empService;

	@GetMapping("/getEmployeebyId/{employeeId}")
	public EmployeeVO getEmployeeById(@PathVariable int employeeId) throws Exception {
		logger.info("Employee by ("+employeeId+")employeeId is called");
		return empService.getEmployeeById(employeeId);

	}

}

