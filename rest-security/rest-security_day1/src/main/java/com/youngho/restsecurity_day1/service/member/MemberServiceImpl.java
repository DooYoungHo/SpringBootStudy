package com.youngho.restsecurity_day1.service.member;

import com.youngho.restsecurity_day1.entity.locale.Locale;
import com.youngho.restsecurity_day1.entity.member.Member;
import com.youngho.restsecurity_day1.exception.MemberAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    private final List<Member> memberList = new ArrayList<>();

    public MemberServiceImpl() {
        memberList.add(new Member("1", "신건영", "A", Locale.KO));
        memberList.add(new Member("2", "김건우", "B", Locale.EN));
        memberList.add(new Member("3", "선도형", "C", Locale.EN));
        memberList.add(new Member("4", "김희망", "D", Locale.JP));
        memberList.add(new Member("5", "이정규", "E", Locale.JP));
    }

    @Override
    public List<Member> getMembers() {
        return memberList;
    }

    @Override
    public Page<Member> getMembers(Pageable pageable) {
        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), memberList.size());

        if (start > memberList.size()) {
            return new PageImpl<>(new ArrayList<>(), pageable, memberList.size());
        }

        List<Member> subList = memberList.subList(start, end);
        return new PageImpl<>(subList, pageable, memberList.size());
    }

    @Override
    public Member getMember(String userId) {
        for (Member member : memberList) {
            if (member.getId().equalsIgnoreCase(userId)) {
                return member;
            }
        }
        return null;
    }

    @Override
    public void saveMember(Member member) {
        if (isExistMember(member)) {
            throw new MemberAlreadyExistsException("already exists member...");
        }
        memberList.add(member);
    }

    @Override
    public boolean isExistMember(Member member) {
        for (Member mem : memberList) {
            if (mem.getId().equalsIgnoreCase(member.getId())) {
                return true;
            }
        }
        return false;
    }
}
