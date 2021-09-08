package com.tzivadinovic.komma.repository;

import com.tzivadinovic.komma.entity.Category;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}