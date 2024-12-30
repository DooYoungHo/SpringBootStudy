package com.youngho.restsecurity_day1.entity.locale;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Locale {
    KO,
    EN,
    JP;

    @JsonCreator
    public static Locale fromString(String str) {
        for (Locale locale : Locale.values()) {
            if (locale.name().equals(str)) {
                return locale;
            }
        }
        return KO;
    }

    @JsonValue
    public String toJson() {
        return this.name().toLowerCase();
    }
}
