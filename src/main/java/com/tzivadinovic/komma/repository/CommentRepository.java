package com.tzivadinovic.komma.repository;

import com.tzivadinovic.komma.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByPost_IdOrderByCreatedDateDesc(Integer postId);

    Page<Comment> findAllByPost_IdOrderByCreatedDateDesc(Integer postId, Pageable pageable);
}