package com.employee.mgmt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.mgmt.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
