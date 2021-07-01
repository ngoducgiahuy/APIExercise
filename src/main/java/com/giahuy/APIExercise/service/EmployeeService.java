package com.giahuy.APIExercise.service;

import java.util.HashMap;
import java.util.List;

import com.giahuy.APIExercise.entity.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(long EmployeeID);

	public Employee saveEmployee(Employee Employee);

	public Employee updateEmployee(long EmployeeID, Employee Employee);

	public HashMap<String, String> deleteEmployeeById(long EmployeeID);
}
