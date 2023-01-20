package com.practise.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.practise.beans.Employee;
import com.practise.service.EmployeeService;

// we need to implement these methods
public class EmployeeDaoImpl implements EmployeeDao {
	
	private JdbcTemplate template; // make setter method
	// setter method to inject JdbcTemplate Object
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}


	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(Employee employee) {
		int status=template.update("insert into employee values (?,?,?)",
				employee.getId(),employee.getName(),employee.getSalary());
				return status; //status stores number of rows affected value
	}

}
