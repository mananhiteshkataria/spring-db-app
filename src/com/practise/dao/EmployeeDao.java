package com.practise.dao;

import java.util.List;

import com.practise.beans.Employee;

public interface EmployeeDao {
// crud
	public int save(Employee employee);
	public Employee getEmployee(int id);
	// we will add other methods later
	public List<Employee> getEmployees();
	/*
	 * Implement get employees in dao to select all the records
	 * Use JDBCTemplate:query(sqlQuery,ROwMapper) to get all the records
	 * Call this method from service
	 * Create an option in controller to see all the employees
	 * Use for loop in the controller to iterate list<Employee>
	 * 
	 */
}
