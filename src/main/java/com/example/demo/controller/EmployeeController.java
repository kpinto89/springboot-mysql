package com.example.demo.controller;

import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.EmployeeService;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> fetchEmployeeList() {
        return employeeService.fetchEmployeeList();
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployeeById(employeeId);
        return "Employee deleted Successfully";
    }
}
