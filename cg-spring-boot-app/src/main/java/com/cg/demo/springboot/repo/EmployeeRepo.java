package com.cg.demo.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.demo.springboot.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
