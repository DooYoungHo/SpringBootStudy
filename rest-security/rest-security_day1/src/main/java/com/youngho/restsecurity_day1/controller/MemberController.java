package com.youngho.restsecurity_day1.controller;

import com.youngho.restsecurity_day1.entity.member.Member;
import com.youngho.restsecurity_day1.service.member.MemberService;
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
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/{memberId}")
    public ResponseEntity<Member> getMember(@PathVariable("memberId") String memberId) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.getMember(memberId));
    }

    @GetMapping("/members")
    public ResponseEntity<Page<Member>> getMembers(Pageable pageable) {
        Page<Member> members = memberService.getMembers(pageable);

        return ResponseEntity.status(HttpStatus.OK).body(members);
    }

    @PostMapping("/member")
    public ResponseEntity<Member> addMember(@RequestBody Member member) {

        memberService.saveMember(member);

        return ResponseEntity.status(HttpStatus.CREATED).body(member);
    }
}
