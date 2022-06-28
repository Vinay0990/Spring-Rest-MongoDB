package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Comment;
import com.example.demo.repo.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository repo;

	public List<Comment> getAllComments(int id) {
		Pageable request = PageRequest.of(id, 10);
		List<Comment> comments = new ArrayList<Comment>();
		Page<Comment> page = this.repo.findAll(request);
		page.forEach(t -> comments.add(t));
		return comments;
	}

	public Comment getComment(String id) {
		Optional<Comment> op =this.repo.findById(id);
		if(op.isPresent()) {
			return op.get();
		}else {
			return null;
		}
	}

	public Comment addComment(Comment com) {
		return this.repo.save(com);
	}

	public Comment deleteComment(String id) {
		Comment com = this.repo.findById(id).get();
		this.repo.delete(com);

		return com;
	}

	public Comment updateComment(String id, Comment com) {

		Comment temp = this.repo.findById(id).get();
		temp.setName(com.getName());
		
		return this.repo.save(temp);
	}
}
