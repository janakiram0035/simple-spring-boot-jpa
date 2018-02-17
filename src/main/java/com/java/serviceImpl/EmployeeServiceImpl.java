package com.java.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.Employee;
import com.java.repository.EmployeeRepository;
import com.java.service.EmployeeService;

@Service
public class EmployeeServiceImpl  implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public String saveEmployee(Employee emp) 
	{
		String status="FAILURE";
		int rowsInserted=0;
		try {
			rowsInserted = employeeRepository.saveEmployee(emp);
			
			if(rowsInserted>0)
			{
				status="SUCCESS";
				
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
			
			status=e.getMessage();
		}
		
		return status;
	}

	@Override
	public Employee getEmployeeDetails(int employeeId) 
	{
		Employee emp=null;
		try 
		{
			emp = employeeRepository.getEmployeeDetails(employeeId);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public String updateEmployee(Employee emp) 
	{
		int rowsUpdated=0;
		String status="FAILURE";
		try 
		{
			rowsUpdated=employeeRepository.updateEmployee(emp);
			
			if(rowsUpdated>0)
			{
				status="SUCCESS";
				
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String deleteEmployee(int employeeId) 
	{
		int rowsUpdated=0;
		String status="FAILURE";
		try 
		{
			rowsUpdated=employeeRepository.deleteEmployee(employeeId);
			
			if(rowsUpdated>0)
			{
				status="SUCCESS";
				
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return status;
	}

}
