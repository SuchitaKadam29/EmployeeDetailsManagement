package com.hdfc.capstone.serviceImpl;

import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.capstone.entity.Employee;
import com.hdfc.capstone.exception.EmployeeIdException;
import com.hdfc.capstone.repo.IEmployeeRepository;
import com.hdfc.capstone.service.IEmployeeService;
import com.hdfc.capstone.vo.EmployeeVO;

/*
 * Author -suchita kadam
 * created on - 24/04/2023
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	
	@Autowired
	IEmployeeRepository empRepo;
	
	

//	@Override
//	public Employee getEmployeeById(int employeeId) throws EmployeeIdException {
//		LOGGER.trace("Entering getEmployeeById() method");
//		LOGGER.debug("Authenticating Employee Id " + employeeId );
//		
//		Employee employee = empRepo.findById(employeeId).orElse(null);
//		if (employee != null) {
//			LOGGER.info(" got Employee by Id ");
//			return employee;
//		} else {
//			throw new EmployeeIdException("Invalid EmployeeID ");
//		}
//	}
	
	@Override
	public EmployeeVO getEmployeeById(int employeeId) throws Exception {
		LOGGER.trace("Entering getEmployeeById() method");
		LOGGER.debug("Authenticating Employee Id " + employeeId );
		
		Employee employee = empRepo.findById(employeeId).orElse(null);
		if (employee != null) {
			
			String encrypted= EmployeeServiceImpl.encrypt(employee.getDateOfBirth().toString());
			System.out.println("Encrypted value = "+encrypted);
			
			EmployeeVO employeeVO = new EmployeeVO();
			employeeVO.setEmployeeId(employee.getEmployeeId());
			employeeVO.setEmployeeName(employee.getEmployeeName());
			employeeVO.setDateOfBirth(encrypted);
			

			LOGGER.info(" got Employee by Id ");
			return employeeVO;
		} else {
			throw new EmployeeIdException("Invalid EmployeeID ");
		}
	}
	
	private static final String SECRET_KEY ="SecretKey";
	private static final String SALTVALUE ="suchita";

	public static String encrypt(String strToEncrypt) throws Exception {
		byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		IvParameterSpec ivspec = new IvParameterSpec(iv);
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALTVALUE.getBytes(), 65536, 256);
		SecretKey tmp = factory.generateSecret(spec);
		SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
		/* Returns encrypted value. */
		return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));

	}


}
