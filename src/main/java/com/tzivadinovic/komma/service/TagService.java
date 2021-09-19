package com.tzivadinovic.komma.service;

import com.tzivadinovic.komma.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagService {

    List<Tag> findAll();

    Page<Tag> findAll(Pageable pageable);

    Tag save(Tag tag);

    Tag update(Tag tag);

    Tag findById(Integer tagId);

    void deleteById(Integer tagId);

    List<String> findTagsForPost(Integer postId);

}