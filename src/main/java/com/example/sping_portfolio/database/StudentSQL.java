/*package com.example.sping_portfolio.database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentSQL {

    @Autowired
    private StudentJPA jpa;


    public  List<Student>listAll() {
        return jpa.findAll();
    }


    public  List<Student>listLikeNative(String term) {
        String like_term = String.format("%%%s%%",term);  // Like required % rappers
        return jpa.findByLikeTermNative(like_term);
    }

    public void save(Student student) {
        jpa.save(student);

    }

    public Student get(long id) {
        return (jpa.findById(id).isPresent())
                ? jpa.findById(id).get()
                : null;
    }

    public void delete(long id) {
        jpa.deleteById(id);
    }
}
*/
