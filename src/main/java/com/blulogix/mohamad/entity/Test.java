package com.blulogix.mohamad.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "test_seq")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String name;
}
