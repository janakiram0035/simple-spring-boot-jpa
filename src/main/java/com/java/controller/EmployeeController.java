package com.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.Employee;
import com.java.service.EmployeeService;

@RestController
public class EmployeeController
{
	/*@Autowired
	EmployeeService employeeService;*/
	
	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService empService) {
		this.employeeService=empService;
	}
	
	@RequestMapping(value="/employee/saveEmployee",consumes="application/json", method= {RequestMethod.POST})
	public String saveEmployee(HttpServletRequest request, HttpServletResponse reposne, HttpSession session, @RequestBody Employee employee) 
	{
		return employeeService.saveEmployee(employee);
	}
	
	@GetMapping(value="/employee/getEmployee/{employeeId}")
	public Object getEmployeeDetails(HttpServletRequest request, HttpServletResponse reposne, HttpSession session, @PathVariable("employeeId") int  employeeId) 
	{
		System.out.println(employeeId);
		return employeeService.getEmployeeDetails(employeeId);
	}
	
	@RequestMapping(value="/employee/updateEmployee/{employeeId}",method= {RequestMethod.GET,RequestMethod.POST })
	public Object updateEmployeeDetails(HttpServletRequest request, HttpServletResponse reposne, HttpSession session, @RequestBody Employee employee) 
	{
		return employeeService.updateEmployee(employee);
	}
	
	@RequestMapping(value="/employee/deleteEmployee/{employeeId}",method= {RequestMethod.GET,RequestMethod.POST })
	public Object deleteEmployeeDetails(HttpServletRequest request, HttpServletResponse reposne, HttpSession session, @PathVariable("employeeId") int  employeeId) 
	{
		return employeeService.deleteEmployee(employeeId);
	}
	
	@RequestMapping(value="/employee/hello",method= {RequestMethod.GET,RequestMethod.POST })
	public String sayHello(HttpServletRequest request, HttpServletResponse reposne, HttpSession session)
	{
		return "hello";
	}

}
