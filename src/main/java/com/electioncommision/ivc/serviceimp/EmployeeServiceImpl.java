package com.electioncommision.ivc.serviceimp;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electioncommision.ivc.entity.Employee;
import com.electioncommision.ivc.exceptionhandler.IdNotFoundException;
import com.electioncommision.ivc.repository.EmployeeRepository;
import com.electioncommision.ivc.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);

	}

	@Override
	public Optional<Employee> findByEmployeeId(long id) {
		Optional<Employee> optional=employeeRepository.findById(id);
		if (optional!=null) {
			return optional;
		} else {
			throw new IdNotFoundException("Employee not found with given "+id);
		}
	}

	@Override
	public List<Employee> findAllEMployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee updateEmployee(long id, Map<String, Object> updates) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee deleteEmployee(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
