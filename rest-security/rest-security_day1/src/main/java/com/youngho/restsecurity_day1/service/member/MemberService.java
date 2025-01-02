package com.youngho.restsecurity_day1.service.member;

import com.youngho.restsecurity_day1.entity.member.Member;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberService {
    List<Member> getMembers();
    Page<Member> getMembers(Pageable pageable);
    Member getMember(String userId);
    void saveMember(Member member);
    boolean isExistMember(Member member);
}
