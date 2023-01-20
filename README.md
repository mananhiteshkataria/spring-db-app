# Actual connectivity over here if you reffered from <a href="https://github.com/mananhiteshkataria/Spring-App">Spring-App</a> #
## Dependency Injection between the objects with simple and complex types ##
### You can have setter methods to supply the dependencies of simple or complex type ###

	Class MySQLDBImpl implements DBOperations
	{
		private String dbUrl;//simple type
	}
	
	class UserService
	{
		private DBOperation dbop;
	}
	
	<bean id="b1" class="com.practise.MySqlDBImpl">
		<property name="dbUrl" value ="jdbc:mysql://localhost:3306"/>
	</bean>
	
	<bean id="b2" class="com.practise.UserService">
		<property name="dbop" ref="b1" />
	</bean>
## Spring JDBC ##

-	It helps you to interact with any Relational Database 	systems like Oracle,Mysql,Derby,Sybase and so on

-	It gives you a configuration class (DriverManagerDataSource) to configure datasource information like username,password,url,driverClass,this class establishes database connection object for you using the configuration in XML

- It gives you a template class (JdbcTemplate) that uses DriverManagerDataSource to perform CRUD operations
  
### DriverManagerDataSource ###
It has 4 properties
-username
-password
-url
-driverclassName

### JdbcTemplate ###
It has a property called datasource which is referencing DriverManagerDataSource

### Steps ###
- Using Derby so configure it
- Project with dependencies - spring-context,spring-jdbcm derby-client
	- Employee class - id ,name & salary
- Interface EmployeeDao 
- Implementation EmployeeDaoImpl
- Employee Service Class
- XML Configuration
	- DriverManagerDataSource - username , password, url, driverClassName
	- JDBC Template - datasource
	- EmployeeDaoImpl
	- EmployeeService
- Main class that acts like Conroller

## JDBC Template ##

- update(sqlQuery,args)
- queryForObject(sqlQuery,rowMapperObject,Object),**Example :- sqlQuery="select * from employee where id = ?"**				
- query(sqlQuery,rowMapperObject)
- update : It is used to run insert , update & delete types of query
- queryForObject : It is used to run select query that can return one result, mainly used when you wan an object with a particulae id
- query : It is also used to run select quey but it returns multiple records , mainly used when you want multiple objects for a query.
- rowMapperObject : It is a class that implements RowMapper interface that takes care of converting sql records to java object , it has one method map(int 		rowNum,ResultSet rs) When select query is triggered a one or more rows will be returned which is handled by ResultSet & rowNum gives index number for each 	   ResultSet, on each map() invocation we can expect one java object.
