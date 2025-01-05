package com.project.ems.service;

import java.util.List;

import com.project.ems.model.Employee;

public interface EmployeeService {
	public Employee saveEmployee(Employee employee);
	public List<Employee>getAllEmployees();
	public Employee getEmployeeById(int id);
	public Employee updateEmployee(int id, Employee employee);
	public void deleteEmployee(int id);

}
