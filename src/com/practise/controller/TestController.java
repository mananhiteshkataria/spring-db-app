package com.practise.controller;

import java.util.Scanner;

import org.apache.derby.tools.sysinfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.practise.service.EmployeeService;

import com.practise.beans.Employee;

public class TestController {
public static void main(String[] args) {
	ApplicationContext ctx= new ClassPathXmlApplicationContext("beans.xml");
	// user service object and perform crud operation
	
	EmployeeService service=(EmployeeService)ctx.getBean("employeeService");
	
	// service needs to have methods
	Scanner scan= new Scanner(System.in);
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
	
	ClassPathXmlApplicationContext ctax = (ClassPathXmlApplicationContext)ctx;
	ctax.close();
	
}
}
