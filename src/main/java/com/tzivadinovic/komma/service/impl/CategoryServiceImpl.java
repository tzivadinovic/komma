package com.tzivadinovic.komma.service.impl;

import com.tzivadinovic.komma.entity.*;
import com.tzivadinovic.komma.repository.CategoryRepository;
import com.tzivadinovic.komma.service.CategoryService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
	private final CategoryRepository categoryRepository;

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findById(Integer categoryId) {
		return categoryRepository.findById(categoryId)
				.orElseThrow(() -> new NoSuchElementException("CategoryService.notFound"));
	}

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category update(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void deleteById(Integer categoryId) {
		categoryRepository.deleteById(categoryId);
	}


}