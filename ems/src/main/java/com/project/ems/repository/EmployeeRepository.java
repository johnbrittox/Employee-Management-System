package com.project.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ems.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
