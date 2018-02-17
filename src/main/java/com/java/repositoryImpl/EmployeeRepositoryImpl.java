package com.java.repositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java.dto.Employee;
import com.java.repository.EmployeeRepository;

@Repository
public class EmployeeRepositoryImpl  implements EmployeeRepository
{
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	@Transactional()
	public int saveEmployee(Employee emp) throws Exception
	{
		System.out.println("hello");
		return jdbcTemplate.update("Insert Into employee(id, name, created_date) values(?,?,?)", new Object[] {emp.getId(), emp.getName(), emp.getCreated_date()});
	}

	@Override
	@Transactional
	public Employee getEmployeeDetails(int employeeId) throws Exception 
	{
		Employee emp=(Employee)jdbcTemplate.queryForObject("Select id, name,created_date  From employee where id=?", new Object[] {employeeId}, new BeanPropertyRowMapper<Employee>(Employee.class));
		return emp;
	}

	@Override
	@Transactional()
	public int updateEmployee(Employee emp) throws Exception 
	{
		return jdbcTemplate.update("Update employee set name=?, created_date=? where id=?", new Object[] { emp.getName(), emp.getCreated_date(),emp.getId()});
	}

	@Override
	@Transactional()
	public int deleteEmployee(int employeeId) throws Exception 
	{
		return jdbcTemplate.update("delete from employee where id=?", new Object[] { employeeId});
	}

}
