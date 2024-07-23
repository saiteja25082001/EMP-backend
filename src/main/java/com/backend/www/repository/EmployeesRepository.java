package com.backend.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.www.model.Employee;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee,Long> {

}
