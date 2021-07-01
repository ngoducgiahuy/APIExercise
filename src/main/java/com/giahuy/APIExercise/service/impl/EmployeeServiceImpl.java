package com.giahuy.APIExercise.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giahuy.APIExercise.entity.Employee;
import com.giahuy.APIExercise.exception.EmployeeNotFoundException;
import com.giahuy.APIExercise.repository.EmployeeRepository;
import com.giahuy.APIExercise.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

	@Override
	public Employee getEmployeeById(long employeeId) {
		return employeeRepository.findById(employeeId)
								.orElseThrow(() -> employeeNotFoundException(employeeId));
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(long employeeId, Employee employeeNewData) {

		return employeeRepository.findById(employeeId).map(employee -> {
			employee.setName(employeeNewData.getName());
			employee.setPosition(employeeNewData.getPosition());
			return employeeRepository.save(employee);
		}).orElseThrow(() -> employeeNotFoundException(employeeId));
	}

	@Override
	public HashMap<String, String> deleteEmployeeById(long employeeId) {
		HashMap<String, String> result_message = new HashMap<String, String>();
		return employeeRepository.findById(employeeId).map(employee -> {
			employeeRepository.delete(employee);
			result_message.put("message", "Delete employee id " + employeeId + " successfully!");
			return result_message;
		}).orElseThrow(() -> employeeNotFoundException(employeeId));
	}
	
	
	public EmployeeNotFoundException employeeNotFoundException(long employeeID) {
		return new EmployeeNotFoundException("Employee with id = " + employeeID + "not found");
	}
}
