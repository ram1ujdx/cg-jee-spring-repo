package com.cg.demo.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.demo.springboot.model.Employee;
import com.cg.demo.springboot.repo.EmployeeRepo;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeRepo repo;
	
	@GetMapping(value = "/employee/{id}", produces = "application/json")
	@ResponseBody
	public Employee getEmployee(@PathVariable int id) {
		
		return repo.getOne(id);
		
	}
	
	@PostMapping("/employee")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Employee addEmployee(@RequestBody Employee emp) {
		return repo.save(emp);
	}
	
	@GetMapping("/employees")
	@ResponseBody
	public List<Employee> getAllEmployees(){
		return repo.findAll();
		}
	
}
