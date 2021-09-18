package com.tzivadinovic.komma.service;

import com.tzivadinovic.komma.entity.Post;
import com.tzivadinovic.komma.entity.User;
import com.tzivadinovic.komma.entity.dto.PostDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {

    List<Post> findAll();

    Page<Post> findAll(Pageable pageable);

    Post save(Post post);

    Post save(PostDTO dto, User user);

    Post update(Post post);

    Post findById(Integer postId);

    void deleteById(Integer postId);

    List<Post> findAllByCategory(String category);

    List<Post> findAllByUsername(String username);

    List<Post> findAllByTags(String tagName);

}