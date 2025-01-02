package com.youngho.restsecurity_day1.service.projectMember;

import com.youngho.restsecurity_day1.entity.member.Member;
import com.youngho.restsecurity_day1.service.member.MemberService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectMemberService {
    void addProjectMember(String projectId, String userId);
    Page<Member> getMembersByProjectId(Pageable pageable,String projectId, MemberService memberService);
}
