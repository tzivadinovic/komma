package com.tzivadinovic.komma.service;

import com.tzivadinovic.komma.entity.Tag;

import java.util.List;

public interface TagService {

    List<Tag> findAll();

    Tag save(Tag tag);

    Tag update(Tag tag);

    Tag findById(Integer tagId);

    void deleteById(Integer tagId);

}