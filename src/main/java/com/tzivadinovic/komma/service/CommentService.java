package com.tzivadinovic.komma.service;

import com.tzivadinovic.komma.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {

    List<Comment> findAll();

    Comment save(Comment comment);

    Comment update(Comment comment);

    Comment findById(Integer commentId);

    void deleteById(Integer commentId);

    List<Comment> findAllByPostId(Integer postId);

    Page<Comment> findAllByPostId(Integer postId, Pageable pageable);

}