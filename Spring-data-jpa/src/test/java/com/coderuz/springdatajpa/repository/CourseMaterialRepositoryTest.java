package com.coderuz.springdatajpa.repository;

import com.coderuz.springdatajpa.entity.Course;
import com.coderuz.springdatajpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course1 = Course.builder()
                .title("IT Developper")
                .credit(6)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.w3school.com")
                .course(course1)
                .build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void getAllCousesMaterial(){
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println("courseMaterials = " + courseMaterials);
    }
}