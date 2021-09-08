package com.tzivadinovic.komma.repository;

import com.tzivadinovic.komma.entity.Post;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}