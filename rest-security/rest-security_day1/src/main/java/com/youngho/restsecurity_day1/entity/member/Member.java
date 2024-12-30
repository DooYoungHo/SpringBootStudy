package com.youngho.restsecurity_day1.entity.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Locale;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Member {
    private final String id;

    @Setter
    private String name;

    @Setter
    @JsonProperty("class")
    private String clazz;

    @Setter
    private Locale locale;

    public Member(String id, String name, String clazz, Locale locale) {
        this.id = id;
        this.name = name;
        this.clazz = clazz;
        this.locale = locale;
    }
}
