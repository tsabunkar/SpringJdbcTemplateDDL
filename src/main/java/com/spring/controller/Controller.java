package com.spring.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.dao.EmployeeDao;
import com.spring.dto.Employee;


public class Controller {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("appcontext.xml");
		EmployeeDao empDao = (EmployeeDao)context.getBean("edao");
		
		System.out.println("-----Fetching record---ResultSetExtractor----");
		List<Employee> l1 = empDao.getAllEmployeeResultSetExtractor();
		for (Employee employee : l1) {
			System.out.println(employee);
		}
		
		System.out.println("-----Fetching record---RowMapper----");
	List<Employee> l2=empDao.getAllEmployeeRowMapper();
	for (Employee employee : l2) {
		System.out.println(employee);
	}
	}

}
