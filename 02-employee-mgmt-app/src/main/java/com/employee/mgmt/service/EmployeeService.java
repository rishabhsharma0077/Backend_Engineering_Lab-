package com.employee.mgmt.service;

import java.util.List;

import com.employee.mgmt.entity.Employee;

public interface EmployeeService {
    List<Employee> getAll();
    void save(Employee emp);
    void delete(int id);
    Employee getById(int id);
}