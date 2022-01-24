package com.amyz.employermanager.service;

import java.util.List;

import com.amyz.employermanager.model.Employee;



public interface EmployeeService {
	Employee addEmployee(Employee employee);
	List<Employee> listAllEmployee();
	Employee updateEmployee(Employee employee);
	void deleteEmployee(Long id);
	Employee findEmployee(Long id);
	
	
	
	

}
