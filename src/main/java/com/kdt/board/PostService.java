package com.kdt.board;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post save(Post post) {
        return this.postRepository.save(post);
    }

    public List<Post> findAll() {
        return this.postRepository.findAll();
    }

    public Post findById(Long id) {
        return this.postRepository.findById(id).orElse(null);
    }
    public void deletePost(Long id){
        Post post=this.postRepository.findById(id).orElse(null);
        if(post==null){
            System.out.println("error");
        }
        else this.postRepository.delete(post);
    }

    @Transactional(readOnly = true)
    public String findTitleWithLoginId(Long id) {
        Post post = this.postRepository.findById(id).orElse(null);
        if (post == null) {
            return "missing";
        }
        return post.getTitle() + "by" + post.getMember().getLoginId();
    }
    @Transactional(readOnly = true)
    public List<Post> findAllWithMember(){
        return this.postRepository.findAllWithMember();
    }
    @Transactional(readOnly = true)
    public long countPosts() {
        return this.postRepository.countPosts();
    }
    @Transactional(readOnly = true)
    public int countLoadedPosts() {
        List<Post> posts = this.postRepository.findAll();

        return posts.size();
    }
    @Transactional(readOnly = true)
    public long countByTitle(String title) {
        return this.postRepository.countByTitle(title);
    }

}