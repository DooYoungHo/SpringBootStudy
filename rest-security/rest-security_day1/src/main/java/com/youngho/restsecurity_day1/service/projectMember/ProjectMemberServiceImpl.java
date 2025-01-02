package com.youngho.restsecurity_day1.service.projectMember;

import com.youngho.restsecurity_day1.entity.member.Member;
import com.youngho.restsecurity_day1.entity.project.ProjectMember;
import com.youngho.restsecurity_day1.exception.ProjectMemberAlreadyExistsException;
import com.youngho.restsecurity_day1.service.member.MemberService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProjectMemberServiceImpl implements ProjectMemberService {

    private final List<ProjectMember> projectMemberList = new ArrayList<>();

    @Override
    public void addProjectMember(String projectId, String userId) {
        if (isExistsProjectMember(projectId, userId)) {
            throw new ProjectMemberAlreadyExistsException("ProjectMember Already Exists");
        }

        projectMemberList.add(new ProjectMember(projectId, userId));
    }

    @Override
    public Page<Member> getMembersByProjectId(Pageable pageable, String projectId, MemberService memberService) {

        List<Member> members = new ArrayList<>();

        for (ProjectMember pm : projectMemberList) {
            if (pm.getProjectId().equalsIgnoreCase(projectId)) {
                Member member = memberService.getMember(pm.getMemberId());
                if (member != null) {
                    members.add(member);
                }
            }
        }

        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), members.size());

        List<Member> subMembers;
        if (start >= members.size()) {
            subMembers = Collections.emptyList();
        } else {
            subMembers = members.subList(start, end);
        }

        return new PageImpl<>(subMembers, pageable, members.size());
    }

    private boolean isExistsProjectMember(String projectId, String memberId) {
        for (ProjectMember pm : projectMemberList) {
            if (pm.getMemberId().equalsIgnoreCase(memberId)
            && pm.getProjectId().equalsIgnoreCase(projectId)) {
                return true;
            }
        }
        return false;
    }
}
