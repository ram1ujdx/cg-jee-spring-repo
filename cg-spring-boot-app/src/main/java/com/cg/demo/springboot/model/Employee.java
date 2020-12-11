package com.cg.demo.springboot.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "employee_data")
public class Employee {

	@Id
	private int employeeId;
	private String employeeName;
	private String email;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Employee(int employeeId, String employeeName, String email) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.email = email;
	}



	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
