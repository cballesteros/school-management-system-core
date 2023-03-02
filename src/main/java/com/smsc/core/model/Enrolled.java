package com.smsc.core.model;

import jakarta.persistence.*;

import lombok.*;

@Data
@Entity
@Table(name = "enrolled")
public class Enrolled {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrolled_id")
    private Long enrolledId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_level_id")
    private CourseLevel courseLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    // Constructors, getters, setters, and other methods

}

