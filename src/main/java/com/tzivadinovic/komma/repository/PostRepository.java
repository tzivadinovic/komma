package com.tzivadinovic.komma.repository;

import com.tzivadinovic.komma.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findAllByCategory_Name(String category);

    List<Post> findAllByUser_Username(String username);

    List<Post> findAllByTags_Name(String tagName);
}