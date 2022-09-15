package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> fetchEmployeeList() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee, Long employeeId)
    {
        Employee depDB = employeeRepository.findById(employeeId).get();

        if (Objects.nonNull(employee.getEmployeeFirstName()) && !"".equalsIgnoreCase(employee.getEmployeeFirstName())) {
            depDB.setEmployeeFirstName(employee.getEmployeeFirstName());
        }

        if (Objects.nonNull(employee.getEmployeeLastName()) && !"".equalsIgnoreCase(employee.getEmployeeLastName())) {
            depDB.setEmployeeLastName(employee.getEmployeeLastName());
        }

        if (Objects.nonNull(employee.getEmployeeAddress()) && !"".equalsIgnoreCase(employee.getEmployeeAddress())) {
            depDB.setEmployeeAddress(employee.getEmployeeAddress());
        }

        if (Objects.nonNull(employee.getEmployeeEmail()) && !"".equalsIgnoreCase(employee.getEmployeeEmail())) {
            depDB.setEmployeeEmail(employee.getEmployeeEmail());
        }



        return employeeRepository.save(depDB);
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
