package com.hdfc.capstone.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdfc.capstone.entity.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

}
