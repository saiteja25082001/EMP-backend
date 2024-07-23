package com.backend.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.backend.www.exception.ResourceNotFound;
import com.backend.www.model.Employee;
import com.backend.www.repository.EmployeesRepository;

@Service
public class EmployeesService {
	@Autowired
	EmployeesRepository employeesRepository;
	
public List<Employee> getAllEmployees(){
		
	return employeesRepository.findAll();
	
	}

public Employee createEmployee(Employee employee) {
	
	return employeesRepository.save(employee);
}


public Employee getEmployeeById(long id) {
	
	return employeesRepository.findById(id).orElseThrow(() -> new ResourceNotFound("ID Does Not Exist"));
}

public ResponseEntity<Employee> updateEmployee(long id, Employee employee) {

Employee emp=employeesRepository.findById(id).orElseThrow(() -> new ResourceNotFound("ID Does Not Exist"));
	emp.setFirstName(employee.getFirstName());
	emp.setLastName(employee.getLastName());
	emp.setEmail(employee.getEmail());
Employee newEmp=employeesRepository.save(emp);
return ResponseEntity.ok(newEmp);	
}

public ResponseEntity<HttpStatus> deleteEmployee(long id) {
	
	Employee emp=employeesRepository.findById(id).orElseThrow(() -> new ResourceNotFound("id not found"));
	employeesRepository.delete(emp);
	
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}


}
