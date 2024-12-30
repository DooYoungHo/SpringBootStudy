package com.youngho.restsecurity_day1.entity.project;

import java.time.LocalDate;
import lombok.Data;

@Data
public class Project {

    private String code;
    private LocalDate localDate;
    private ProjectType projectType;

    public Project(String code, ProjectType projectType) {
        this.code = code;
        this.localDate = LocalDate.now();
        this.projectType = projectType;
    }
}
