package com.practise.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.practise.service.EmployeeService;

public class TestController {
public static void main(String[] args) {
	ApplicationContext ctx= new ClassPathXmlApplicationContext("beans.xml");
	// user service object and perform crud operation
	
	EmployeeService service=(EmployeeService)ctx.getBean("employeeService");
	
	// service needs to have methods
	ClassPathXmlApplicationContext ctax = (ClassPathXmlApplicationContext)ctx;
	ctax.close();
	
}
}
