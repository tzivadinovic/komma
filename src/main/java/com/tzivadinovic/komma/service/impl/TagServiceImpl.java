package com.tzivadinovic.komma.service.impl;

import com.tzivadinovic.komma.entity.*;
import com.tzivadinovic.komma.repository.TagRepository;
import com.tzivadinovic.komma.service.TagService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
	private final TagRepository tagRepository;

	@Override
	public List<Tag> findAll() {
		return tagRepository.findAll();
	}

	@Override
	public Tag findById(Integer tagId) {
		return tagRepository.findById(tagId)
				.orElseThrow(() -> new NoSuchElementException("TagService.notFound"));
	}

	@Override
	public Tag save(Tag tag) {
		return tagRepository.save(tag);
	}

	@Override
	public Tag update(Tag tag) {
		return tagRepository.save(tag);
	}

	@Override
	public void deleteById(Integer tagId) {
		tagRepository.deleteById(tagId);
	}


}