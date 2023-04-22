package com.hdfc.capstone.service;

import com.hdfc.capstone.entity.Employee;
import com.hdfc.capstone.exception.EmployeeIdException;

public interface IEmployeeService {

	public Employee getEmployeeById(int employeeId) throws EmployeeIdException;

}
