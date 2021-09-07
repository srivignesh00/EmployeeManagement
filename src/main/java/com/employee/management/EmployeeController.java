package com.employee.management;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")
public class EmployeeController {
@Autowired
	EmployeeService employeeService;
	@GetMapping("/employee")
	List<employee_details> getEmployees()
	{
		return employeeService.getEmployees();
	}
	
	
	@DeleteMapping("/delete/{idEmployee}")
	void deleteEmployee(@PathVariable String idEmployee)
	{
		employeeService.deleteById(idEmployee);
	}
	
	@PutMapping("/update")
	void updateEmployee(@RequestBody employee_details employee)
	{
		 employeeService.updateEmployee(employee);
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<employee_details> addEmployee(@RequestBody employee_details employee)
	{
		return new ResponseEntity<>(employeeService.saveOrUpdateEmployee(employee),HttpStatus.CREATED);
	}
		
		
}

