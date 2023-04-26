package com.hdfc.capstone.service;

import com.hdfc.capstone.vo.EmployeeVO;

public interface IEmployeeService {

//	public Employee getEmployeeById(int employeeId) throws EmployeeIdException;
	public EmployeeVO getEmployeeById(int employeeId) throws Exception;

}
