package com.practise.dao;

import com.practise.beans.Employee;

public interface EmployeeDao {
// crud
	public int save(Employee employee);
	public Employee getEmployee(int id);
	// we will add other methods later
}
