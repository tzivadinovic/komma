package com.tzivadinovic.komma.service.impl;

import com.tzivadinovic.komma.entity.Post;
import com.tzivadinovic.komma.entity.Tag;
import com.tzivadinovic.komma.repository.PostRepository;
import com.tzivadinovic.komma.repository.TagRepository;
import com.tzivadinovic.komma.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;
    private final PostRepository postRepository;

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public Page<Tag> findAll(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    @Override
    public Tag findById(Integer tagId) {
        return tagRepository.findById(tagId)
                .orElseThrow(() -> new NoSuchElementException("TagService.notFound"));
    }

    @Override
    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag update(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public void deleteById(Integer tagId) {
        tagRepository.deleteById(tagId);
    }

    @Override
    public List<String> findTagsForPost(Integer postId) {
        Post post = postRepository.getById(postId);
        return post.getTags()
                .stream()
                .map(Tag::getName)
                .collect(Collectors.toList());
    }


}