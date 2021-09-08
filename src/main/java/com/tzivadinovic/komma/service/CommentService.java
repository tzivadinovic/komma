package com.tzivadinovic.komma.service;

import com.tzivadinovic.komma.entity.*;
import java.util.Collection;
import java.util.List;

public interface CommentService {

	List<Comment> findAll();

	Comment save(Comment comment);

	Comment update(Comment comment);

	Comment findById(Integer commentId);

	void deleteById(Integer commentId);

}