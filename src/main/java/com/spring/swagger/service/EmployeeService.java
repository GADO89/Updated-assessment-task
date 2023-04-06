package com.spring.swagger.service;


import com.spring.swagger.entity.Employee;

import java.io.IOException;
import java.util.List;

public interface EmployeeService {
 
	public boolean saveEmployee(Employee employee) throws IOException;
	
	public List<Employee> getAllEmployees();
	
	public boolean deleteFile(Long id, String file);
}
