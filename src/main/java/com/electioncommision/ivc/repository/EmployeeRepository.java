package com.electioncommision.ivc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electioncommision.ivc.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
