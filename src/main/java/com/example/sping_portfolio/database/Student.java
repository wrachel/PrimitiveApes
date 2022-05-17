//package com.example.sping_portfolio.database;
//import lombok.*;
//import org.springframework.format.annotation.DateTimeFormat;
//
//import javax.persistence.*;
//import javax.validation.constraints.*;
//import java.time.LocalDate;
//import java.time.Period;
//import java.time.ZoneId;
//import java.util.Date;
//
///*
//Person is a POJO, Plain Old Java Object.
//First set of annotations add functionality to POJO
//--- @Setter @Getter @ToString @NoArgsConstructor @RequiredArgsConstructor
//The last annotation connect to database
//--- @Entity
// */
//@Setter
//@Getter
//@ToString
//@NoArgsConstructor
//@RequiredArgsConstructor
//@Entity
//public class Student {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @Column( name = "table_number")
//    private int table_number;
//
//    @Column (name = "period")
//    private int period;
//
//    /*
//    @NonNull: Places this in @RequiredArgsConstructor
//    @Size(min=2, max=30): Allows names between 2 and 30 characters long.
//     */
//    @NonNull
//    @Size(min = 2, max = 30, message = "Name (2 to 30 chars)")
//    @Column (name = "name")
//    private String name;
//
//
//
//    /* Initializer used when setting database from an API */
//    public Student(String name, int table_number, int period_number) {
//        this.table_number = table_number;
//        this.name = name;
//        this.period = period_number;
//    }
//
//    /* A custom getter to return age from dob calculation */
//
//
//}