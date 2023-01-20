package com.practise.service;

import com.practise.dao.EmployeeDao;

public class EmployeeService {
	private EmployeeDao dao;

	public void setDao(EmployeeDao dao) {
		this.dao = dao;
	}
	
	// Employee Service must have all dao methods;
}
