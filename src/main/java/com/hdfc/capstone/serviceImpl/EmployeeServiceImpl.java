package com.hdfc.capstone.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.capstone.entity.Employee;
import com.hdfc.capstone.exception.EmployeeIdException;
import com.hdfc.capstone.repo.IEmployeeRepository;
import com.hdfc.capstone.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	
	@Autowired
	IEmployeeRepository empRepo;

	@Override
	public Employee getEmployeeById(int employeeId) throws EmployeeIdException {
		LOGGER.trace("Entering getEmployeeById() method");
		LOGGER.debug("Authenticating Employee Id " + employeeId );
		
		Employee employee = empRepo.findById(employeeId).orElse(null);
		if (employee != null) {
			LOGGER.info(" got Employee by Id ");
			return employee;
		} else {
			throw new EmployeeIdException("Invalid EmployeeID ");
		}
	}

}