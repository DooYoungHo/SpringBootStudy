package com.youngho.restsecurity_day1.service.project;

import com.youngho.restsecurity_day1.entity.project.Project;
import com.youngho.restsecurity_day1.entity.project.ProjectType;
import com.youngho.restsecurity_day1.exception.ProjectAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final List<Project> projectList = new ArrayList<>();

    public ProjectServiceImpl() {
        projectList.add(new Project("test_a", ProjectType.PRIVATE));
        projectList.add(new Project("test_b", ProjectType.PUBLIC));
    }

    @Override
    public Page<Project> getProjects(Pageable pageable) {
        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), projectList.size());

        if (start > projectList.size()) {
            return new PageImpl<>(new ArrayList<>(), pageable, projectList.size());
        }

        List<Project> subList = projectList.subList(start, end);
        return new PageImpl<>(subList, pageable, projectList.size());
    }

    @Override
    public Project getProject(String projectId) {
        for (Project project : projectList) {
            if (project.getCode().equals(projectId)) {
                return project;
            }
        }
        return null;
    }

    @Override
    public void saveProject(Project project) {
        if (isExistsProject(project)) {
            throw new ProjectAlreadyExistsException("This Project already exists");
        }

        projectList.add(project);
    }

    private boolean isExistsProject(Project project) {
        for (Project p : projectList) {
            if (p.getCode().equals(project.getCode())) {
                return true;
            }
        }
        return false;
    }
}
