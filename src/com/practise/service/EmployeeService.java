package com.practise.service;

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


	
}
