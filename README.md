# Actual connectivity over here if you referred from [Spring-App](https://github.com/mananhiteshkataria/Spring-App") #
## Dependency Injection between the objects with simple and complex types ##
### You can have setter methods to supply the dependencies of simple or complex type ###
``` java
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
```
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

## Spring ORM ##

ORM stands for Object Relational Mapping , which helps you to directly map java objects to the database table , it gives you the feature where you can directly store Java Objects and retrieve java objects without writing any SQL query.

## Features ##

- Provides inbuilt methods to store , update , delete & retrieve Java objects without SQL query
- Database table & Column names you don't have to use while perform crud operations
- Entity class are used to represent the table information for the java object , this helps to recognize the table names & columns while performing CRUD operations
- You will perform CRUD operations on entity class object

## Hibernate Template ##
 It is an inbuilt class that has methods to perform CRUD operations 

## Spring JDBC vs Spring ORM 

Both are used to interact with the database but Spring ORM has some advantages

<table>
<thead><th>Spring JDBC</th><th>Spring ORM</th></thead>
<tbody><tr>
<td>JDBC Template is used to perform operations</td>
<td>Hibernate Template is used to perform operations</td>
</tr>
<tr><td> JDBC Template uses sql query which are database dependent </td>
<td> Hibernate Template uses inbuilt methods that takes care of generating sql query based on underlying database</td></tr>
<tr><td>If DB changes you need to change query written in code</td>
<td> You don't need to change query because SQL is not used</td>
</tr>
<tr>
<td> Table and column names are used in query</td>
<td> Table and column names are used in entity class , the entity class object & its properties recognize the table and column details</td>
</tr>
<tr>
<td> You need to take care of converting SQL records to JAVA objects & vice versa i.e. row Mapper we used to convert  SQL records to objects</td>
<td>Hibernate Template methods will take care of converting JAva to Sql records and vice versa , you don't need any RowMapper here</td>
</tr>
</tbody>
</table>

## Spring Boot ##


It simplifies spring configurations in the application automatically with the inbuilt spring boot starter libraries, you don't need to have XML file at all any application related configuration you need can be configured in a property file in simple key value configuration spring boot takes care of configuring the application based on inbuilt spring boot starter libraries

Some of the starter libraries:
- Web :
 This does all the configuration required for web & rest applications like server configuration, front controller configuration, scanning all the @component, @service , @repository, @restcontroller classes to create their objects in the spring container.

- DataJPA : 
  This does all the configuration required for database beans like DriverManagerDataSource injecting to JdbcTemplate,HibernateTemplate & so on,it automatically reads application.properties for datasource informations like username , password , url, driverClassname etc.

- Spring Cloud : 
  This does configurations required for cloud environments like service discovery , load balancer and etc. 

## How Spring boot automates the configuration ##

It uses @SpringBootApplication annotation which takes care of auto configuring the application based on the library you have in project , a class must have @SpringBootApplication and this class must be loaded to trigger the automation

``` java
	@SpringBootAutomation
	public class AppStarter
	{
		main()
		{
			SpringApplication.run(AppStarter,class);//triggers Automation
		}
		
	}
```

The moment **AppStarter** is loaded it looks for all the libraries in the project & also **application.properties** to perform the configuration required.

Note : By default all the classes are scanned by looking the sub-package of the class @SpringBootApplication , hence you must have all the classes in the sub-package of the class having @SpringBootApplication.

@AutoWired : It is used to supply dependency to an object

@Component , @Service,@RestController,@Repository : These annotations are written on top of the class which lets spring to create the object and maintain in the spring container
``` java
			@Component
			class A{}
			@Component
			class B
			{
				@AutoWired
				private A obj;
			}
			@Service
			class C
			{
				@AutoWired
				private B objB;
				//object of B is injected to C object
			}
```
All the objects like A,B & C are created in spring container.


