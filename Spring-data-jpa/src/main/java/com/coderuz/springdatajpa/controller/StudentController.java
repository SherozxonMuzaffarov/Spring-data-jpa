package com.coderuz.springdatajpa.controller;


import com.coderuz.springdatajpa.entity.Student;
import com.coderuz.springdatajpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
@RequestMapping("/student")
public class StudentController {


    @Autowired
    StudentRepository studentRepository;


    @GetMapping()
    public ResponseEntity<?> getAllStudent(@RequestParam int page){
        Pageable pageable=  PageRequest.of(page,10);
        Page<Student> all = studentRepository.findAll(pageable);
        return ResponseEntity.ok(all);
    }
}
