package com.tzivadinovic.komma.repository;

import com.tzivadinovic.komma.entity.Tag;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {

}