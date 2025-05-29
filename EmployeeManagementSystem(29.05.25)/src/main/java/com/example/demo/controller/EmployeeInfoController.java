package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeInfoController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value="/info")
    public List<Employee> getinfo(){
        return employeeService
                .getAllEmployee();
    }

    @GetMapping(value="/info/{id}")
    public List<Employee> getinfobyID(
            @PathVariable int id){

        return employeeService
                .getAllEmployee()
                .stream()
                .filter(employee-> employee.getId()==id)
                .collect(Collectors.toList());
    }

    @GetMapping(value="/info/filter")
    public ResponseEntity<?> getinfobyIDandAge(
            @RequestParam int id,
            @RequestParam int age){

        List<Employee> result = employeeService
                .getAllEmployee()
                .stream()
                .filter(employee-> employee.getId()==id && employee.getAge()== age)
                .collect(Collectors.toList());

        if(result.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping(value = "/info/filter/{name}")
    public List<Employee> getinfobyName(
            @PathVariable String name){
        return employeeService
                .getAllEmployee()
                .stream()
                .filter(employee-> employee.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }


}
