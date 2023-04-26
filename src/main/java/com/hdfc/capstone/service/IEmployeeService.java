package com.hdfc.capstone.service;

import com.hdfc.capstone.vo.EmployeeVO;


/*
 * Author -suchita kadam
 * created on - 22/04/2023
 */
public interface IEmployeeService {

//	public Employee getEmployeeById(int employeeId) throws EmployeeIdException;
	public EmployeeVO getEmployeeById(int employeeId) throws Exception;

}
