package com.example.quizclasssimple.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "quizQuestion")

public class QuizQuestion {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "answes_id", referencedColumnName = "id")
    private Answes answes;

    public QuizQuestion() {

    }
}
