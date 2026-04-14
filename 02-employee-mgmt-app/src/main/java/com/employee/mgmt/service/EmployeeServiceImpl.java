package com.employee.mgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.mgmt.entity.Employee;
import com.employee.mgmt.repo.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
	private EmployeeRepository repo;

    @Override
    public List<Employee> getAll() {
        return repo.findAll();
    }

    @Override
    public void save(Employee emp) {
        repo.save(emp);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public Employee getById(int id) {
        return repo.findById(id).orElse(null);
    }
}