package com.example.dz1.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_ref")
@Getter
@Setter
@Builder
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
