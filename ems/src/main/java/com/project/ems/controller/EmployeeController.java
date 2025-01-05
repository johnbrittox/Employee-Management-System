package com.project.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.ems.model.Employee;
import com.project.ems.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
		
	}
	@GetMapping("list")
	public List<Employee>getAllEmployees(){
		return employeeService.getAllEmployees();
		
	}
	@GetMapping("/get/{id}")
	public Employee getEmployeeByid(@PathVariable("id")int id) {
		
		return employeeService.getEmployeeById(id);
	}
	
	@PutMapping("/update/{id}")
	public Employee updateEmployee(@PathVariable int id,@RequestBody Employee employee) {
		return employeeService.updateEmployee(id, employee);
		
	}
	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable int id) {
		employeeService.deleteEmployee(id);
	}
}
