package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RestTemplate restTemplate;

    private final String URL = "http://host.docker.internal:8087/employees";

    @Override
    public Employee saveEmployee(Employee employee) {
        Employee employeeResponse = restTemplate.postForObject(URL, employee, Employee.class);
        log.info("Response" + employeeResponse);
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> fetchEmployeeList() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        URI deleteURI = URI.create(URL+"/"+ employeeId);
        restTemplate.delete(deleteURI);
        employeeRepository.deleteById(employeeId);
    }
}
