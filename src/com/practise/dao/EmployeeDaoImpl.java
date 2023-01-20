package com.practise.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.practise.beans.Employee;

// we need to implement these methods
public class EmployeeDaoImpl implements EmployeeDao {
	
	private JdbcTemplate template; // make setter method
	// setter method to inject JdbcTemplate Object
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public int save(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
