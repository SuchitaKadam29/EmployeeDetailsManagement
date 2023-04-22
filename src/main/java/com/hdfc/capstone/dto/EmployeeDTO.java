package com.hdfc.capstone.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {
	
	private int employeeId;
	private String employeeName;
	private Date dateOfBirth;

}
