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

import java.util.*;
import java.util.stream.Collectors;

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
        return postRepository.findAllByPublishedTrueOrderByCreatedDateDesc(pageable);
    }

    @Override
    public Page<Post> findAllForAdmin(Pageable pageable) {
        return postRepository.findAllByOrderByCreatedDateDesc(pageable);
    }

    @Override
    public Post findById(Integer postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new NoSuchElementException("PostService.notFound"));
    }

    @Override
    public Post save(Post post) {
//        Post post = new Post();
//        post.setUser(user);
//        post.setCategory(dto.getCategory());
//        post.setTags(dto.getTags());
//        post.setContent(dto.getContent());
//        post.setExcerpt(dto.getExcerpt());
//        post.setTitle(dto.getTitle());
        return postRepository.save(post);
    }

    @Override
    public Post save(PostDTO dto, User user) {
        Post post = new Post();
        post.setCategory(dto.getCategory());
        post.setTags(Arrays.stream(dto.getTags()
                .split(",\\s*"))
                .map(tagRepository::findByName)
                .flatMap(Optional::stream)
                .collect(Collectors.toList()));
        post.setContent(dto.getContent());
        post.setExcerpt(dto.getExcerpt());
        post.setTitle(dto.getTitle());
        post.setUser(user);
//        String slugWithoutSpaces = dto.getTitle().replaceAll("[\\s+]", "-");
//        post.setUrlSlug(slugWithoutSpaces.toLowerCase().replaceAll("[^a-zA-Z0-9]", ""));
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
    public Page<Post> findAllByUsername(String username, Pageable pageable) {
        return postRepository.findAllByUser_UsernameOrderByCreatedDateDesc(username, pageable);
    }

    @Override
    public List<Post> findAllByTags(String tagName) {
        Optional<Tag> tag = tagRepository.findByName(tagName);
        if (tag.isEmpty()) return new ArrayList<>();
        return postRepository.findAllByTags_Name(tagName);
    }

    @Override
    public Post updatePostStatus(Integer postId) {
        Post post = findById(postId);
        post.setPublished(!post.getPublished());
        return postRepository.save(post);
    }


}