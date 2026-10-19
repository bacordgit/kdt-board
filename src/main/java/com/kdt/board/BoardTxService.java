package com.kdt.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class BoardTxService {

    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    @Autowired
    public BoardTxService(MemberRepository memberRepository, PostRepository postRepository) {
        this.memberRepository = memberRepository;
        this.postRepository = postRepository;
    }

    @Transactional
    public String registerOk() {
        String loginId = "kdt" + System.currentTimeMillis();
        Member member = new Member();
        member.setLoginId(loginId);
        member.setNickname("kimbap");
        Member saved = this.memberRepository.save(member);

        Post post = new Post();
        post.setTitle("closed");
        post.setBody("no class");
        post.setMember(saved);
        this.postRepository.save(post);

        return "ok" + loginId;


    }
    @Transactional
    public String registerFail() {
        String loginId="kdt"+System.currentTimeMillis();
        Member member = new Member();
        member.setLoginId(loginId);
        member.setNickname("kimbap");
        Member saved=this.memberRepository.save(member);

        Post post = new Post();
        post.setTitle("closed");
        post.setBody("no class");
        post.setMember(saved);
        this.postRepository.save(post);

        System.out.println("tx fail"+loginId);
        throw new IllegalStateException(loginId);
    }
    public String failBySelf(){
        return this.registerFail();
    }
    public String registerOpen(){
        String loginId = "kdt"+System.currentTimeMillis();
        Member member = new Member();
        member.setLoginId(loginId);
        member.setNickname("kimbap");
        this.memberRepository.save(member);
        System.out.println("tx open"+loginId);
        throw new IllegalStateException(loginId);
    }
    @Transactional
    public String registerDirty() {
        String loginId = "dirty " + System.currentTimeMillis();
        Member member = new Member(loginId, "first");
        Member saved = this.memberRepository.save(member);
        System.out.println("dirty before " + saved.getNickname());
        saved.setNickname("second");
        System.out.println("dirty after " + saved.getNickname());
        return "dirty " + saved.getLoginId();

    }
    @Transactional
    public String registerFlushFail() {
        String loginId = "flush " + System.currentTimeMillis();
        Member saved = this.memberRepository.save(new Member(loginId, "before"));
        saved.setNickname("after");
        this.memberRepository.flush();
        System.out.println("flush returned " + loginId);
        throw new IllegalStateException(loginId);

    }
    @Transactional(readOnly = true)
    public String findTitleWithLoginId(Long id) {
        Post post = this.postRepository.findById(id).orElse(null);
        if (post == null) {
            return "missing";
        }
        return post.getTitle() + "by" + post.getMember().getLoginId();
    }


}