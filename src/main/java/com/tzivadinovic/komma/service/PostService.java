package com.tzivadinovic.komma.service;

import com.tzivadinovic.komma.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {

    List<Post> findAll();

    Page<Post> findAll(Pageable pageable);

    Post save(Post post);

    Post update(Post post);

    Post findById(Integer postId);

    void deleteById(Integer postId);

    List<Post> findAllByCategoryId(Integer categoryId);

    List<Post> findAllByUsername(String username);

}