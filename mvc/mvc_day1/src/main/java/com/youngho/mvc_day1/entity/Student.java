package com.youngho.mvc_day1.entity;

import lombok.Setter;

@Setter
public class Student {

    private String id;

    private String password;

    private String name;

    private String email;

    private int score;

    private String evaluation;

    public Student(String id, String password, String name, String email, int score, String evaluation) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.score = score;
        this.evaluation = evaluation;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getScore() {
        return score;
    }

    public String getEvaluation() {
        return evaluation;
    }
}
