package com.practise.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.practise.beans.Employee;

public class RowImpl implements RowMapper<Employee> {
	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		Employee e = new Employee();
		e.setId(rs.getInt("id"));
		e.setName(rs.getString("name"));
		e.setSalary(rs.getDouble("salary"));
		return e;
	}
}
