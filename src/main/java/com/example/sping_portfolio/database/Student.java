package com.example.sping_portfolio.database;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.*;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

@Setter
@Getter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @NotEmpty
    @Size(min=5)
    @Column(unique=true)
    @Email
    private String email;

    @NotEmpty
    private String password;

    // roles are stored in a "related" table
    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();

    @NonNull
    @Size(min = 1, message = "Name")
    private String name;

    private int table_number;


    private int period;

    /* Initializer used when setting data from an API */
    public Student(String name, int table_number, int period_number) {
        this.table_number = table_number;
        this.name = name;
        this.period = period_number;
    }



}