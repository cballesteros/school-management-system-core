package com.smsc.core.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "area")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "area_id")
    private Long id;

    @Column(name = "area_name")
    private String areaName;
}

