package com.youngho.restsecurity_day1.controller;

import com.youngho.restsecurity_day1.entity.member.Member;
import com.youngho.restsecurity_day1.entity.project.Project;
import com.youngho.restsecurity_day1.service.member.MemberService;
import com.youngho.restsecurity_day1.service.project.ProjectService;
import com.youngho.restsecurity_day1.service.projectMember.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final MemberService memberService;
    private final ProjectMemberService projectMemberService;

    @GetMapping("/project/{projectCode}")
    public ResponseEntity<Project> getProject(@PathVariable("projectCode") String projectCode) {

        Project project = projectService.getProject(projectCode);

        return ResponseEntity.status(HttpStatus.OK).body(project);
    }

    @GetMapping("/projects")
    public ResponseEntity<Page<Project>> getProjects(Pageable pageable) {
        Page<Project> projects = projectService.getProjects(pageable);

        return ResponseEntity.status(HttpStatus.OK).body(projects);
    }

    @GetMapping("/project/{projectCode}/members")
    public ResponseEntity<Page<Member>> getProjectMembers(Pageable pageable, @PathVariable("projectCode") String projectCode) {
        Page<Member> projectMembers = projectMemberService.getMembersByProjectId(pageable, projectCode, memberService);

        return ResponseEntity.status(HttpStatus.OK).body(projectMembers);
    }

    @PostMapping("/project")
    public ResponseEntity<Project> saveProject(@RequestBody Project project) {
        projectService.saveProject(project);

        return ResponseEntity.status(HttpStatus.CREATED).body(project);
    }

    @PostMapping("/project/{projectCode}/{memberId}")
    public ResponseEntity<String> saveProjectMember(@PathVariable("projectCode") String projectCode,
        @PathVariable("memberId") String memberId) {
        projectMemberService.addProjectMember(projectCode, memberId);

        return ResponseEntity.status(HttpStatus.CREATED).body("success");
    }
}
