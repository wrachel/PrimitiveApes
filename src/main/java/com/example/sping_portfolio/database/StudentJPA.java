package com.example.sping_portfolio.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
Extends the JpaRepository interface from Spring Data JPA.
-- Java Persistent API (JPA) - Hibernate: map, store, update and retrieve database
-- JpaRepository defines standard CRUD methods
-- Via JPA the developer can retrieve database from relational databases to Java objects and vice versa.
 */
public interface StudentJPA extends JpaRepository<Student, Long> {

    // Custom JPA query
    @Query(
            value = "SELECT * FROM Student p WHERE p.name LIKE ?1",
            nativeQuery = true)
    List<Student> findByLikeTermNative(String term);
    /*
        https://www.baeldung.com/spring-data-jpa-query
     */
}