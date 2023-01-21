package com.practise.dao;
import java.util.List;
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
	public Employee getEmployee(int id) {
		Employee emp= null;
		String query = "select * from employee where id =?";
		emp=template.queryForObject(query,new RowImpl(),id);
		return emp;
	}

	@Override
	public int save(Employee employee) {
		int status=template.update("insert into employee values (?,?,?)",
				employee.getId(),employee.getName(),employee.getSalary());
				return status; //status stores number of rows affected value
	}


	@Override
	public List<Employee> getEmployees() {
		String queString= "select * from employee";
		return template.query(queString, new RowImpl());
	}
	
	





	

}
