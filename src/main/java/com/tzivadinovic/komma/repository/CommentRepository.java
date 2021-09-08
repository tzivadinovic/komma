package com.tzivadinovic.komma.repository;

import com.tzivadinovic.komma.entity.Comment;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}