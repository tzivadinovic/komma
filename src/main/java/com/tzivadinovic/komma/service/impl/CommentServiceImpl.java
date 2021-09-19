package com.tzivadinovic.komma.service.impl;

import com.tzivadinovic.komma.entity.Comment;
import com.tzivadinovic.komma.repository.CommentRepository;
import com.tzivadinovic.komma.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(Integer commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new NoSuchElementException("CommentService.notFound"));
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment update(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteById(Integer commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    public List<Comment> findAllByPostId(Integer postId) {
        return commentRepository.findAllByPost_IdOrderByCreatedDateDesc(postId);
    }


}