package com.example.sping_portfolio.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentJPA extends JpaRepository<Student, Long> {


    // Custom JPA query
    @Query(
            value = "SELECT * FROM Student c WHERE c.name LIKE ?1",
            nativeQuery = true)
    List<Student> findByLikeTermNative(String term);
    /*
        https://www.baeldung.com/spring-data-jpa-query
     */
}