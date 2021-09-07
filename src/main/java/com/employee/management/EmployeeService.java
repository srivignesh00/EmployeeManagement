package com.employee.management;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeService {
  List<employee_details> getEmployees();
  employee_details saveOrUpdateEmployee(employee_details employee);
 //
  void deleteById(String employeeId);
  void updateEmployee(employee_details employee);
}
