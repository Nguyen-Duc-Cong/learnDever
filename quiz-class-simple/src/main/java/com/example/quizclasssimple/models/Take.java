package com.example.quizclasssimple.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="Take")
public class Take {

    @Id
    private int id;

    @Column(nullable = false, length = 6)
    private int status;
    @Column(nullable = false, length = 6)
    private int score;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "take_has_quiz",
            joinColumns = { @JoinColumn(name = "take_id") },
            inverseJoinColumns = { @JoinColumn(name = "quiz_id") }
    )
    Set<Quiz> quizs = new HashSet<>();

}
