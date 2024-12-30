package com.youngho.restsecurity_day1.service.member;

import com.youngho.restsecurity_day1.entity.member.Member;
import java.util.List;

public interface MemberService {
    List<Member> getMembers();
}
