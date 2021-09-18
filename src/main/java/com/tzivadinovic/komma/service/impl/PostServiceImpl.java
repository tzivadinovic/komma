package com.tzivadinovic.komma.service.impl;

import com.tzivadinovic.komma.entity.Post;
import com.tzivadinovic.komma.entity.Tag;
import com.tzivadinovic.komma.entity.User;
import com.tzivadinovic.komma.entity.dto.PostDTO;
import com.tzivadinovic.komma.repository.PostRepository;
import com.tzivadinovic.komma.repository.TagRepository;
import com.tzivadinovic.komma.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final TagRepository tagRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Post findById(Integer postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new NoSuchElementException("PostService.notFound"));
    }

    @Override
    public Post save(PostDTO dto, User user) {
        Post post = new Post();
        post.setUser(user);
        post.setCategory(dto.getCategory());
//        post.setTags(dto.getTags());
        post.setContent(dto.getContent());
        post.setExcerpt(dto.getExcerpt());
        post.setTitle(dto.getTitle());
        return postRepository.save(post);
    }

    @Override
    public Post update(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void deleteById(Integer postId) {
        postRepository.deleteById(postId);
    }

    @Override
    public List<Post> findAllByCategory(String category) {
        return postRepository.findAllByCategory_Name(category);
    }

    @Override
    public List<Post> findAllByUsername(String username) {
        return postRepository.findAllByUser_Username(username);
    }

    @Override
    public List<Post> findAllByTags(String tagName) {
        Optional<Tag> tag = tagRepository.findByName(tagName);
        if (tag.isEmpty()) return new ArrayList<>();
        return postRepository.findAllByTags_Name(tagName);
    }


}