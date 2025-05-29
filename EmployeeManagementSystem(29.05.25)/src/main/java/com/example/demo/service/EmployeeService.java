package com.example.demo.service;

import com.example.demo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    public List<Employee> getAllEmployee(){
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101,"Saikat", 24));
        employees.add(new Employee(102,"Saikat1", 24));
        employees.add(new Employee(103,"Saikat2", 26));
        employees.add(new Employee(104,"Saikat3", 26));
        employees.add(new Employee(105,"Saikat4", 28));
        employees.add(new Employee(106,"Saikat5", 29));
        return employees;
    }
}
