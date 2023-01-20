package com.practise.service;

import java.util.List;

import com.practise.beans.Employee;
import com.practise.dao.EmployeeDao;

public class EmployeeService {
	private EmployeeDao dao;

	public void setDao(EmployeeDao dao) {
		this.dao = dao;
	}
	
	// Employee Service must call dao methods
	
	public int store(Employee employee)
	{
		return dao.save(employee);
	}
	
	// create method that calls employee of dao
	
	public Employee getEmployee (int id)
	{
		return dao.getEmployee(id);
	}
	
	public List<Employee> getEmployees()
	{
		return dao.getEmployees();
		
	}


	
}
