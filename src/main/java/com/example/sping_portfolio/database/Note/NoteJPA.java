package com.example.sping_portfolio.database.Note;

import com.example.sping_portfolio.database.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteJPA extends JpaRepository<Note, Long> {
    List<Note> findAllByStudent(Student s);
}
