package com.youngho.restsecurity_day1.service.project;

import com.youngho.restsecurity_day1.entity.project.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectService {
    Page<Project> getProjects(Pageable pageable);
    Project getProject(String projectId);
    void saveProject(Project project);
}
