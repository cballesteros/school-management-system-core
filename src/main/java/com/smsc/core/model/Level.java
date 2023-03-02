package com.smsc.core.model;

import jakarta.persistence.*;

import lombok.*;

@Data
@Entity
@Table(name = "level")
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "level_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    // Constructors, getters, setters, and other methods

}

