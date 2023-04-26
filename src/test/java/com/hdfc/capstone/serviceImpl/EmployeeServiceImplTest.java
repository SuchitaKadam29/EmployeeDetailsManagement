package com.hdfc.capstone.serviceImpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hdfc.capstone.entity.Employee;
import com.hdfc.capstone.vo.EmployeeVO;


@SpringBootTest
class EmployeeServiceImplTest {

	@Autowired
	EmployeeServiceImpl employeeSeriveImpl;

	@Test
	void testGetEmployeeById() throws Exception {   
		EmployeeVO employee = employeeSeriveImpl.getEmployeeById(1);
		assertNotNull(employee);
		assertEquals(1, employee.getEmployeeId());
	}
}