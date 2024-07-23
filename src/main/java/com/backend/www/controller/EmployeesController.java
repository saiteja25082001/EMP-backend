package com.backend.www.controller;


import java.util.List;

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

import com.backend.www.model.Employee;
import com.backend.www.service.EmployeesService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/v1")
public class EmployeesController {
	
	@Autowired
	EmployeesService employeesService;
	
	@GetMapping ("/employees")
	public List<Employee> getAllEmployees(){
		
		return employeesService.getAllEmployees();
	}
	
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		
		return employeesService.createEmployee(employee);
		
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable long id) {
		
		return  employeesService.getEmployeeById(id);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employee){
		return  employeesService.updateEmployee(id,employee);
	}
	@DeleteMapping("employees/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
		return employeesService.deleteEmployee(id);
	}
	

}
