package com.example.dz1.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

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

    @Column(name = "password")
    private String password;
    @Transient
    private String passwordConfirm;

    @Column(name = "role")
    private String role;

    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Collection<Role> roles;
}
