package com.tzivadinovic.komma.service;

import com.tzivadinovic.komma.entity.*;
import java.util.Collection;
import java.util.List;

public interface CategoryService {

	List<Category> findAll();

	Category save(Category category);

	Category update(Category category);

	Category findById(Integer categoryId);

	void deleteById(Integer categoryId);

}