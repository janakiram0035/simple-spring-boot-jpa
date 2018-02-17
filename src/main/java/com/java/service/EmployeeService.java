package com.java.service;

import com.java.dto.Employee;

public interface EmployeeService 
{
	String saveEmployee(Employee emp);
	
	String updateEmployee(Employee emp) ;
	
	String deleteEmployee(int employeeId) ;
	
	Employee getEmployeeDetails(int employeeId);

}
