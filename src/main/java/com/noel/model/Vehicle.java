package com.noel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;


@Entity
public class Vehicle {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 50)
    private String id;

    @Column(length = 15)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(length = 30)
    private String owner;
}


//14:08