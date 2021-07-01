package com.giahuy.APIExercise.restcontroller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giahuy.APIExercise.entity.Employee;
import com.giahuy.APIExercise.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> findAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/{employeeId}")
	public Employee findEmployeeByID(@PathVariable long employeeId) {
		return employeeService.getEmployeeById(employeeId);
	}
	
	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@PutMapping("/{employeeId}")
	public Employee replaceEmployee(@RequestBody Employee employee, @PathVariable long employeeId) {
		return employeeService.updateEmployee(employeeId, employee);
	}
	
	@DeleteMapping("/{employeeId}")
	public HashMap<String, String> deleteEmployeeByID(@PathVariable long employeeId){
		return employeeService.deleteEmployeeById(employeeId);
	}
	
}
