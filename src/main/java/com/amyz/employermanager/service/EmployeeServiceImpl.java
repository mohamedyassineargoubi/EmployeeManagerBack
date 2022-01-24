package com.amyz.employermanager.service;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amyz.employermanager.exception.UserNotFoundException;
import com.amyz.employermanager.model.Employee;
import com.amyz.employermanager.repo.EmployeeRepo;

import antlr.collections.List;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepo employeeRepo;

	@Override
	public Employee addEmployee(Employee employee) {
	      employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
	}

	@Override
	public java.util.List<Employee> listAllEmployee() {
		
		return  employeeRepo.findAll();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		
		return employeeRepo.save(employee);
	}

	@Override
	public void deleteEmployee(Long id) {
	     employeeRepo.deleteEmployeeById(id);
		
	}

	@Override
	public Employee findEmployee(Long id) {
		return  employeeRepo.findEmployeeById(id)
				.orElseThrow(()-> new UserNotFoundException("User by id "+id+" was not found"));
	}

}
