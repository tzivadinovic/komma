package com.tzivadinovic.komma.repository;

import com.tzivadinovic.komma.entity.Post;
import com.tzivadinovic.komma.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findAllByCategory_Name(String category);

    List<Post> findAllByUser_Username(String username);

    List<Post> findAllByTags_Name(String tagName);
}