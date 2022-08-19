package com.example.spring_boot_project.service;


import com.example.spring_boot_project.entity.Employee;
import com.example.spring_boot_project.repository.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class HelloService {
    @Autowired
    private HelloRepository repository;


    public Employee getEmployee(String id) {
// Search
        Map<String, Object> map = repository.findById(id);
// Get value from Map
        String employeeId = (String) map.get("id");
        String name = (String) map.get("name");
        int age = (Integer) map.get("age");
// Set the Employee class to a value
        Employee employee = new Employee();
        employee.setEmployeeId(employeeId);
        employee.setEmployeeName(name);
        employee.setEmployeeAge(age);
        return employee;
    }
}
