package com.example.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.repo.EmployeeRepo;

@RestController

@RequestMapping("/secure/employee")
public class EmployeeController {

	@Autowired
	EmployeeRepo repo;
	
	@PostConstruct
	public void addDummyEmployee() {
		Employee emp=new Employee(10001, "Rohit Shetty", 25000f, "rohit@yahoo.com");
		if(!repo.existsById(emp.getEmployeeId())) {
		repo.save(emp);
		}
	}
	
	@GetMapping("/id/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return repo.getOne(id);
	}
	
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee emp) {
		return repo.save(emp);
	}
	@GetMapping("/all")
	public List<Employee> getAllEmployee(){
		return repo.findAll();
	}
	@DeleteMapping("/id/{id}")
	public ResponseEntity deleteEmployee(@PathVariable int id) {
		repo.deleteById(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee emp) {
		return repo.save(emp);
	}
	
	
	
}
