package com.tzivadinovic.komma.service;

import com.tzivadinovic.komma.entity.Post;

import java.util.List;

public interface PostService {

    List<Post> findAll();

    Post save(Post post);

    Post update(Post post);

    Post findById(Integer postId);

    void deleteById(Integer postId);

}