package com.tzivadinovic.komma.service;

import com.tzivadinovic.komma.entity.Post;
import com.tzivadinovic.komma.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface PostService {

    List<Post> findAll();

    Page<Post> findAll(Pageable pageable);

    Post save(Post post);

    Post update(Post post);

    Post findById(Integer postId);

    void deleteById(Integer postId);

    List<Post> findAllByCategory(String category);

    List<Post> findAllByUsername(String username);

    List<Post> findAllByTags(String tagName);

}