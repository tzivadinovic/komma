package com.tzivadinovic.komma.service.impl;

import com.tzivadinovic.komma.entity.PostTag;
import com.tzivadinovic.komma.repository.PostTagRepository;
import com.tzivadinovic.komma.service.PostTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PostTagServiceImpl implements PostTagService {
    private final PostTagRepository postTagRepository;

    @Override
    public List<PostTag> findAll() {
        return postTagRepository.findAll();
    }

    @Override
    public PostTag findById(Integer postTagId) {
        return postTagRepository.findById(postTagId)
                .orElseThrow(() -> new NoSuchElementException("PostTagService.notFound"));
    }

    @Override
    public PostTag save(PostTag postTag) {
        return postTagRepository.save(postTag);
    }

    @Override
    public PostTag update(PostTag postTag) {
        return postTagRepository.save(postTag);
    }

    @Override
    public void deleteById(Integer postTagId) {
        postTagRepository.deleteById(postTagId);
    }


}