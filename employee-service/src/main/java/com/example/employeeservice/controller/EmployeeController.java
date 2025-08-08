package com.example.employeeservice.controller;

import com.example.employeeservice.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return Arrays.asList(
                new Employee(1, "John Doe", "IT"),
                new Employee(2, "Jane Smith", "HR"),
                new Employee(3, "Alice Johnson", "Finance")
        );
    }
}
