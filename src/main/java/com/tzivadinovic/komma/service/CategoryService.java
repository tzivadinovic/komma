package com.tzivadinovic.komma.service;

import com.tzivadinovic.komma.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Page<Category> findAll(Pageable pageable);

    Category save(Category category);

    Category update(Category category);

    Category findById(Integer categoryId);

    void deleteById(Integer categoryId);

}