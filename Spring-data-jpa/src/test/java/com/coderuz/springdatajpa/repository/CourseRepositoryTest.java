package com.coderuz.springdatajpa.repository;

import com.coderuz.springdatajpa.entity.Course;
import com.coderuz.springdatajpa.entity.Student;
import com.coderuz.springdatajpa.entity.Teacher;
import org.checkerframework.checker.index.qual.EnsuresLTLengthOfIf;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses);
    }
    @Test
    public void saveCourse(){
        Course course = Course.builder()
                .title("w3school.com")
                .credit(8)
                .build();
        courseRepository.save(course);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher =Teacher.builder()
                .firstName("Ulugbek")
                .lastName("Samigjanov")
                .build();
        Course course =Course.builder()
                .title("Java")
                .credit(5)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords = (Pageable) PageRequest.of(0,3);
        Pageable secondPageWithThreeRecords = (Pageable) PageRequest.of(0,3);

        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();
        long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        long totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();

        System.out.println("totalElements = " + totalElements);
        System.out.println("totalPages = " + totalPages);
        System.out.println("courses = " + courses);

    }

    @Test
    public void findallSorting(){
        Pageable sortByTitle = PageRequest.of(
                1,
                3,
                Sort.by("title")
        );
        Pageable sortByCreditDesc = PageRequest.of(
                0,
                3,
                Sort.by("credit").descending()
        );
        Pageable sortByTitleAndCreditDesc = PageRequest.of(
                0,
                3,
                Sort.by("title").descending().and(
                        Sort.by("credit")
                )
        );
        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("courses = " + courses);
    }

    @Test
    public void findByTitleContaining(){
        Pageable firstPageTenRecords =PageRequest.of(0,10);
        List<Course> courses = courseRepository.findByTitleContaining("D" , firstPageTenRecords).getContent();
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Student student =  Student.builder()
                .firstName("Malik")
                .lastName("Alijonov")
                .emailId("malik@gmail.com")
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Vohid")
                .lastName("Nazarov")
                .build();
        Course course1 =Course.builder()
                .title("Phyton")
                .credit(3)
                .teacher(teacher)
                .build();
        course1.addStudent(student);
        courseRepository.save(course1);
    }
}