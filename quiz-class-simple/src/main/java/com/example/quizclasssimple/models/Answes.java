package com.example.quizclasssimple.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Answes")
public class Answes {
    @Id
    private int id;
    @Column(nullable = false, length = 191)
    private int correct;
    @Column(nullable = false, length = 191)
    private String content;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "quizQuestion_id", referencedColumnName = "id")
    private QuizQuestion quizQuestion;

}
