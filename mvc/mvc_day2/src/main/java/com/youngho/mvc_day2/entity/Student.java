package com.youngho.mvc_day2.entity;

import lombok.Getter;
import lombok.Setter;

public class Student {

    @Getter
    private final String id;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private Integer score;

    @Getter
    @Setter
    private String evaluation;

    public Student(String id, String password, String name, String email, Integer score, String evaluation) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.score = score;
        this.evaluation = evaluation;
    }
}
