package com.amyz.employermanager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amyz.employermanager.model.Employee;
import com.amyz.employermanager.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:8080")
public class EmployeeController {
	//Injection par constructeur
//	private final EmployeeService employeeService;
//	public EmployeeController(EmployeeService employeeService) {
//		this.employeeService = employeeService;
//	}
	@Autowired
	EmployeeService employeeService;
	
	
	@GetMapping("/all")
	
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> employees = employeeService.listAllEmployee();
		return new ResponseEntity<>(employees, HttpStatus.OK);
		
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> findEmployee(@PathVariable("id") Long id){
		  Employee employee = employeeService.findEmployee(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
		
	}
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody @Valid Employee employee){
		Employee employee2 =employeeService.addEmployee(employee);
		return new ResponseEntity<>(employee2, HttpStatus.CREATED);
		
	}
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody @Valid Employee employee){
		Employee employee2 = employeeService.updateEmployee(employee);
		return new ResponseEntity<>(employee2,HttpStatus.OK);
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
		   employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	

}
