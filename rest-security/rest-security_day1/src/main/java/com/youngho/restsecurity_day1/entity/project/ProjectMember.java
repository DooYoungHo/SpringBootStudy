package com.youngho.restsecurity_day1.entity.project;

import lombok.Data;

@Data
public class ProjectMember {
    private String projectId;
    private String memberId;

    public ProjectMember(String projectId, String memberId) {
        this.projectId = projectId;
        this.memberId = memberId;
    }
}
