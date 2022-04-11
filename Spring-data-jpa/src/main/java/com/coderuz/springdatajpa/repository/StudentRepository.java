package com.coderuz.springdatajpa.repository;

import com.coderuz.springdatajpa.entity.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // JpaRepository query creation

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String name);

    Student findByFirstNameAndLastName(String firstName, String lastName);

    //JPQL Query - it is based on class we created, not table on the database
    // getting student by his emailId
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailId(String email);

    //JPQL Query
    // getting student's firstName by his emailId
    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailId(String email);

    //Native Query
    // getting student by his emailId
    @Query(
            value = "SELECT * FROM  table_student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailIdNative(String email);

    //Native Named Param
    // getting student by his emailId
    @Query(
            value = "SELECT * FROM table_student s WHERE s.email_address =:emailId",
            nativeQuery = true
    )
    Student getStudentByEmailIdNativeNamedParam(@Param("emailId") String email);

    @Modifying
    @Transactional
    @Query(
            value = "update table_student set first_name = ?1 where email_address =?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName, String emailId);
}
