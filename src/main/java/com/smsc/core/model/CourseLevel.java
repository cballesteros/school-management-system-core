package com.smsc.core.model;

import jakarta.persistence.*;

import lombok.*;

@Data
@Entity
@Table(name = "course_level",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"course_id", "level_id"})})
public class CourseLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id")
    private Level level;

    // Constructors, getters, setters, and other methods

}

