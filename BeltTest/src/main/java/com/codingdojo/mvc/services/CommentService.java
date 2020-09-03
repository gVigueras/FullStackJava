package com.codingdojo.mvc.services;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Comment;
import com.codingdojo.mvc.repositories.CommentRepository;

@Service
public class CommentService {
	private final CommentRepository commentRepo;
	
	public CommentService (CommentRepository a) {
		this.commentRepo = a;
	}
	public Comment createComent(Comment a) {
		return commentRepo.save(a);
	}
}