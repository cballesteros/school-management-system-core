package com.smsc.core.model;

import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id")
    private Long gradeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_level_id")
    private CourseLevel courseLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "date_of_grade")
    private LocalDate dateOfGrade;

    @Column(name = "grade")
    private Float grade;

    @Column(name = "comments")
    private String comments;

    // Constructors, getters, setters, and other methods

}

