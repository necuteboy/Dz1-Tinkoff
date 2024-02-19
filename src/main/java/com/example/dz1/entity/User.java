package com.example.dz1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_ref")
public class User {
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "user_ref_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    private  Long id;
    @Column(name = "name")
    private  String name;
    @Column(name = "age")
    private  int age;
}
