package com.example.sping_portfolio.database;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

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

    private int period;
    private int table_number = 1;

    @NonNull
    @Size(min = 1, message = "Student Name")
    private String name;



    /* Initializer used when setting data from an API */
    public Student(String name, int period) {
        this.name = name;
        this.period = period;

    }

    public Student (String name, int period, int table_number){
        this.name = name;
        this.period = period;
        this.table_number = table_number;
    }
}
