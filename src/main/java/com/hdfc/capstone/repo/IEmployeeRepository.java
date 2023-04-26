package com.hdfc.capstone.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdfc.capstone.entity.Employee;
/*
 * Author -suchita kadam
 * created on - 22/04/2023
 */
@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

}
