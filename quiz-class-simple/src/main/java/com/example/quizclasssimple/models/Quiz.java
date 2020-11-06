package com.example.quizclasssimple.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Quiz")
public class Quiz {

    @Id
    private int id;
    @Column(nullable = false, length = 191)
    private int type;
    @Column(nullable = false, length = 191)
    private int score;
    @Column(nullable = false, length = 191)
    private int published;

    @ManyToMany(mappedBy = "quizs")
    private Set<Take> employees = new HashSet<>();
}
