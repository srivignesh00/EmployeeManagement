package com.employee.management;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepo employeeRepo;
	@Override
	public List<employee_details> getEmployees() {
		
		List<employee_details> employees= new ArrayList();
		 employeeRepo.findAll().forEach(e->employees.add(e));
			return employees;
	}

	@Override
	public employee_details saveOrUpdateEmployee(employee_details employee) {
		
		employee_details ed= employeeRepo.save(employee);
		return ed;
	}
	
	@Override
	public void updateEmployee(employee_details employee) {
		employeeRepo.save(employee);
		
	}
	@Override
	public void deleteById(String employeeId) {
		employeeRepo.deleteById(employeeId);
		
	}

}
