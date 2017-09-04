package com.spring.dto;

import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString @Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Employee {
	private int eid;
	private String ename;
	private double salary;
}
