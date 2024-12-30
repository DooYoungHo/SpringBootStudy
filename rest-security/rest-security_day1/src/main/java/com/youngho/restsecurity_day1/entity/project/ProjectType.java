package com.youngho.restsecurity_day1.entity.project;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ProjectType {
    PUBLIC,
    PRIVATE;

    @JsonCreator
    public static ProjectType fromString(String str) {
        for (ProjectType type : ProjectType.values()) {
            if (type.name().equalsIgnoreCase(str)) {
                return type;
            }
        }
        return PUBLIC;
    }

    @JsonValue
    public String toJson() {
        return this.name().toLowerCase();
    }
}
