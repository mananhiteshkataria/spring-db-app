package com.practise.controller;
import java.util.List;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.practise.service.EmployeeService;

import com.practise.beans.Employee;

public class TestController {
public static void main(String[] args) {
	ApplicationContext ctx= new ClassPathXmlApplicationContext("beans.xml");
	// user service object and perform crud operation
	ClassPathXmlApplicationContext ctax = (ClassPathXmlApplicationContext)ctx;
	EmployeeService service=(EmployeeService)ctx.getBean("employeeService");
	
	// service needs to have methods
	
	Scanner scan= new Scanner(System.in);
	int option=0;
	 do {
		 System.out.println("Enter Option 1=Store 2=Fetch 3=FetchAll 4=Exit");
			option=scan.nextInt();
		if(option==1)
			{
				// add insert logic here
				Employee employee = new Employee();
				System.out.println("Enter id");
				employee.setId(scan.nextInt());
				
				System.out.println("Enter salary");
				employee.setSalary(scan.nextDouble());
				
				System.out.println("Enter name");
				employee.setName(scan.next());
				
				int status=service.store(employee);
		if(status>0)
				{
					System.out.println("Updated"+status+"row");
				}
		
		else {
					System.err.println("Not stored");
					
				}
	    }

	else if (option==2)
		{
			System.out.println("Enter id to search");
			Employee e = service.getEmployee(scan.nextInt());
			System.out.println
						(
						"Id = "+e.getId()+
						",Name = "+e.getName()+
						",Salary= "+e.getSalary()
						);
		}
	else if (option == 3)
	{
		List<Employee> employees =service.getEmployees();
		for (Employee e : employees) {
		System.out.println
		(
		"Id = "+e.getId()+
		",Name = "+e.getName()+
		",Salary= "+e.getSalary()
		);}
	}
		else if (option == 4 ) 
		{
			break;
		}
	else 
		
		System.out.println("Invalid Input");
		continue;
		
	}
	 while (option!=-1);
	 scan.close();
	 ctax.close();
	 return;
	}
}
