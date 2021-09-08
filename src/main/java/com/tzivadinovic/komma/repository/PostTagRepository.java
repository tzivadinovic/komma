package com.tzivadinovic.komma.repository;

import com.tzivadinovic.komma.entity.PostTag;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface PostTagRepository extends JpaRepository<PostTag, Integer> {

}