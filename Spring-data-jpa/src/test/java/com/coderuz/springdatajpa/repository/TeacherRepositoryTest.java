package com.coderuz.springdatajpa.repository;

import com.coderuz.springdatajpa.entity.Course;
import com.coderuz.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course course = Course.builder()
                .title("w3school.com")
                .credit(5)
                .build();
        Course courseJava = Course.builder()
                .title("javatpoint.com")
                .credit(9)
                .build();
        Course courseFront = Course.builder()
                .title("youtube.com")
                .credit(8)
                .build();


        List<Course> courses = new ArrayList<>();
        courses.add(course);
        courses.add(course);
        courses.add(course);

        Teacher teacher =Teacher.builder()
                .firstName("Ali")
                .lastName("Valiyev")
//                .courses(courses)
                .build();
        teacherRepository.save(teacher);
    }
}