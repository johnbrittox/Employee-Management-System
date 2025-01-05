package com.project.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ems.exception.EmployeeNotFoundException;
import com.project.ems.model.Employee;
import com.project.ems.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {
@Autowired
EmployeeRepository employeeRepository;
	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll(); 
	}
	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
	Optional<Employee> optContainer=	 employeeRepository.findById(id);
	
	if (optContainer.isPresent()) {
		return optContainer.get();
	}
	else {
		throw new EmployeeNotFoundException("Employee not found with id : "+ id);
	}
	
	}
	@Override
	public Employee updateEmployee(int id, Employee employee) {
		// TODO Auto-generated method stub
		Optional<Employee> optContainer=	 employeeRepository.findById(id);
		
		if (optContainer.isPresent()) {
			Employee dbEmployee= optContainer.get();
			dbEmployee.setName(employee.getName());
			dbEmployee.setId(employee.getId());
			dbEmployee.setAge(employee.getAge());
			return employeeRepository.save(dbEmployee);
		}
		else {
			throw new EmployeeNotFoundException("Employee not found with id : "+ id);
		}
		
		}
	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> optContainer=	 employeeRepository.findById(id);
		
		if (optContainer.isPresent()) {
			employeeRepository.deleteById(id);
		}
		else {
			throw new EmployeeNotFoundException("Employee not found with id : "+ id);
		}
		
	}

}
