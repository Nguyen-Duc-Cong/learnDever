package com.example.quizclasssimple.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 191)
private String name;
    @Column(nullable = false, length = 191)
    private String email;

    @Column(nullable = false, length = 60)
    private String password;


    @Column(columnDefinition = "VARCHAR(20) NOT NULL DEFAULT 'ROLE_CUSTOMER'")
    private String role;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Quiz> quizzes;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Take> takes;

    public User() {
    }
}