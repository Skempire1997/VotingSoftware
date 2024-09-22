package com.electioncommision.ivc.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.electioncommision.ivc.entity.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);
	
	Optional<Employee> findByEmployeeId(long id);
	
	List<Employee> findAllEMployee();
	 
	Employee updateEmployee(Employee employee);
	
	Employee updateEmployee(long id,Map<String, Object> updates);
	
	Employee deleteEmployee(long id);
}
