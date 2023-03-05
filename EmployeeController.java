package com.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.demo.model.Employee;
import com.demo.repository.EmployeeRepository;
//import com.demo.springboot.exception.ResourceNotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee()
	{
		return employeeRepository.findAll();
	}
	
	@GetMapping("/employees/details/{id}")
	public Employee getById(@PathVariable long id)
	{
		return employeeRepository.findById(id).orElseThrow();
	}

	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee)
	{
		return employeeRepository.save(employee);
	}
	
	/*
	 * @PutMapping("/employees/{id}") public void updateEmployee(@PathVariable long
	 * id, @RequestBody Employee employee) {
	 * 
	 * employeeRepository.updateById(id);
	 * 
	 * }
	 */
	
	
	  @PutMapping("/employees/{id}") public ResponseEntity<Employee>
	  updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails){
	  Employee employee = employeeRepository.findById(id).orElseThrow();
	  employee.setName(employeeDetails.getName());
	  employee.setEmail(employeeDetails.getEmail());
	  employee.setDesignation(employeeDetails.getDesignation());
	  employee.setPassword(employeeDetails.getPassword());
	  employee.setDob(employeeDetails.getDob());
	  employee.setBio(employeeDetails.getBio());
	  
	  Employee updatedEmployee = employeeRepository.save(employee);
	  
	  return ResponseEntity.ok(updatedEmployee); }
	 
	
	
	
	  @DeleteMapping("/employees/{id}") public void deleteEmployee(@PathVariable
	  long id) { employeeRepository.deleteById(id); }
	 

	
}
