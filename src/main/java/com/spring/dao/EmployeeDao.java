package com.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.spring.dto.Employee;

import lombok.Setter;

public class EmployeeDao {
	@Setter
	private JdbcTemplate jdbcTemplate;
	
	String query = "select * from employee_table";
	
	
	public List<Employee> getAllEmployeeResultSetExtractor(){
		ResultSetExtractor<List<Employee>> rse = new ResultSetExtractor<List<Employee>>() {
			
			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Employee> l1 = new ArrayList<Employee>();
				while (rs.next()) {
					Employee emp = new Employee();
					emp.setEid(rs.getInt(1));
					emp.setEname(rs.getString(2));
					emp.setSalary(rs.getDouble(3));
					l1.add(emp);
					
				}
				return l1;
			}
		};//end of AnoyomousFun
		
		return jdbcTemplate.query(query, rse);
				
	}
	
	public List<Employee> getAllEmployeeRowMapper(){
		RowMapper<Employee> rm = new RowMapper<Employee>() {

			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				
					Employee emp = new Employee();
					emp.setEid(rs.getInt(1));
					emp.setEname(rs.getString(2));
					emp.setSalary(rs.getDouble(3));
					return emp;
			}
		};
		return jdbcTemplate.query(query, rm);
	}
	
	

}
