package com.example.demo.service;

import com.example.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {
        Employee saveEmployee(Employee employee);
        List<Employee> fetchEmployeeList();
        void deleteEmployeeById(Long employeeId);
}
