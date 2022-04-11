package com.coderuz.springdatajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {

    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private Long teacherId;
    private String firstName;
    private String lastName;

//    @OneToMany(   // har doim @ManyToOne ishlatgan afzal many tomonda
//            cascade = CascadeType.ALL
//    )
//    @JoinColumn(
//            name = "teacher_id",    //course table da teacher_id column yaratiladi
//            referencedColumnName = "teacherId"
//    )
//    private List<Course> courses;
}
