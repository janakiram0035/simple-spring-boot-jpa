package com.java.repository;

import com.java.dto.Employee;

public interface EmployeeRepository 
{
	int saveEmployee(Employee emp) throws Exception;
	
	int updateEmployee(Employee emp) throws Exception;
	
	int deleteEmployee(int employeeId) throws Exception;
	
	Employee getEmployeeDetails(int employeeId) throws Exception;

}
