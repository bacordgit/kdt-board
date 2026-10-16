package com.kdt.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @GetMapping("/members")
    public String members(){
        StringBuilder lines=new StringBuilder();
        for(Member member:memberRepository.findAll()){
            lines.append(member.getId())
                    .append(" ")
                    .append(member.getLoginId())
                    .append(" ")
                    .append(member.getNickname())
                    .append("\n");
        }
        return lines.toString();
    }
    @GetMapping("/test/members")
    public String testMembers(){
        String nickname="kdt01";
        this.memberRepository.findByNickname(nickname);
        return "ok";
    }
}
