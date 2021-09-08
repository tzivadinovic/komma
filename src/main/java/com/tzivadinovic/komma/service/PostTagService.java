package com.tzivadinovic.komma.service;

import com.tzivadinovic.komma.entity.PostTag;

import java.util.List;

public interface PostTagService {

    List<PostTag> findAll();

    PostTag save(PostTag postTag);

    PostTag update(PostTag postTag);

    PostTag findById(Integer postTagId);

    void deleteById(Integer postTagId);

}