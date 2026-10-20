package com.kdt.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    @Query("select p from Post p join fetch p.member")
    List<Post> findAllWithMember();
    @Query("select count(p) from Post p")
    long countPosts();
    @Query("select count(p) from Post p where p.title = :title")
    long countByTitle(@Param("title") String title);
}

