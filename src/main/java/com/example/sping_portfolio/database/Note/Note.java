package com.example.sping_portfolio.database.Note;

import com.example.sping_portfolio.database.Student;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    @NotNull
    @Column(columnDefinition="TEXT")
    private String text;
}
