package com.practise.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.practise.beans.Employee;

// we need to implement these methods
public class EmployeeDaoImpl implements EmployeeDao {
	
	private JdbcTemplate template; // make setter method
	// setter method to inject JdbcTemplate Object
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}


	@Override
	public Employee getEmployee(int id) {
		Employee emp= null;
		String query = "select * from employee where id =?";
		class RowImpl implements RowMapper<Employee>
		{
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
		emp=template.queryForObject(query,new RowImpl(),id);
		return emp;
	}

	@Override
	public int save(Employee employee) {
		int status=template.update("insert into employee values (?,?,?)",
				employee.getId(),employee.getName(),employee.getSalary());
				return status; //status stores number of rows affected value
	}

}
