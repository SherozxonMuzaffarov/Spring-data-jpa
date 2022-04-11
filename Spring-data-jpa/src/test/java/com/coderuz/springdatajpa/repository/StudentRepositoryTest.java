package com.coderuz.springdatajpa.repository;

import com.coderuz.springdatajpa.entity.Guardian;
import com.coderuz.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .firstName("Ali")
                .lastName("VAliyev")
                .emailId("alijon@gamil.com")
//                .guardianName("Alisher")
//                .guardianEmail("alisher@Gmail.com")
//                .guardianPhone("+998977778899")
                .build();
        studentRepository.save(student);
    }
    @Test
    public void getAllStudent(){
        List<Student> students= studentRepository.findAll();
        System.out.println("students = " + students);
    }

    // Guardian alohida class bolganda
    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Alisher")
                .email("Alisher@gmail.com")
                .phone("+998977778899")
                .build();
        Student student = Student.builder()
                .firstName("Ali")
                .lastName("Valiyev")
                .emailId("alijon@gamil.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void findByFirstName(){
        List<Student> students = studentRepository.findByFirstName("Ali");
        System.out.println("Students = " + students);
    }

    @Test
    public void findByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("al");
        System.out.println("Students = " + students);
    }

    @Test
    public void findByLastNameNotNull(){
        List<Student> students = studentRepository.findByLastNameNotNull();
        System.out.println("Students = " + students);
    }

    @Test
    public void findByGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("Alisher");
        System.out.println("Students = " + students);
    }

    @Test
    public void findByFirstNameAndLastName(){
        Student student = studentRepository.findByFirstNameAndLastName("Alisher", "Valiyev");
        System.out.println("Student = " + student);
    }

    @Test
    public  void getStudentByEmailId(){
        Student student = studentRepository.getStudentByEmailId("alisher@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void getStudentFirstNameByEmailId(){
        String name = studentRepository.getStudentFirstNameByEmailId("alisher@gmail.com");
        System.out.println("name = " + name);
    }

    @Test
    public void getStudentByEmailIdNative(){
        Student student = studentRepository.getStudentByEmailIdNative("alisher@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void getStudentByEmailIdNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailIdNativeNamedParam("alisher@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentNameByEmailId(){
        studentRepository.updateStudentNameByEmailId("Baxtiyor","alisher@gmail.com");
    }
}