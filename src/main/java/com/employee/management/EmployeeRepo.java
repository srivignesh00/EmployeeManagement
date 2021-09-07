package com.employee.management;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepo extends MongoRepository<employee_details, String> {
		
}
