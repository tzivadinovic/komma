package com.tzivadinovic.komma.service;

import com.tzivadinovic.komma.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> findAll();

    Comment save(Comment comment);

    Comment update(Comment comment);

    Comment findById(Integer commentId);

    void deleteById(Integer commentId);

    List<Comment> findAllByPostId(Integer postId);

}