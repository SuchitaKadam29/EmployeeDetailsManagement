package com.hdfc.capstone.entity;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


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
	private int employeeId;

	private String employeeName;

	private Date dateOfBirth;

}

