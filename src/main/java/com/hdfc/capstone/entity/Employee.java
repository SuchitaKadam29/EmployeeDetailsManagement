package com.hdfc.capstone.entity;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/*
 * Author -suchita kadam
 * created on - 21/04/2023
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Data
public class Employee {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Positive(message = "Employee ID must be a positive integer")
	@NotBlank(message = "Employee Id is required")
	private int employeeId;

	@NotBlank(message = "Employee name is required")
	private String employeeName;

	@NotNull(message = "Date of birth is required")
	private Date dateOfBirth;

}
