package com.example.demo.controller;

import com.example.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    @GetMapping(value = "/get_data/{address}")
    public List<Student> getName(@PathVariable String address) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(101,"Saikt", 25, "Male", "Dhaka"));
        list.add(new Student(103, "Kanok", 26, "Male", "Dhaka"));
        list.add(new Student(102,"Anamika", 20, "Female", "Jessore"));
        list.add(new Student(103,"Pritom", 25, "Male", "Khluna"));

        return list.stream()
                .filter(student -> student.getAddress()
                .equals(address)).toList();
    }
}
