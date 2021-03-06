package com.tzivadinovic.komma.repository;

import com.tzivadinovic.komma.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findAllByCategory_Name(String category);

    Page<Post> findAllByUser_UsernameOrderByCreatedDateDesc(String username, Pageable pageable);

    List<Post> findAllByTags_Name(String tagName);

    Page<Post> findAllByPublishedTrueOrderByCreatedDateDesc(Pageable pageable);

    Page<Post> findAllByOrderByCreatedDateDesc(Pageable pageable);
}