package com.tobeto.pair8.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tobeto.pair8.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Table(name = "users")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surName;

    @Column(name="email")
    private String email;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name="password")
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Rental> rentals;
}
