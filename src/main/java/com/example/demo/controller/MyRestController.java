package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Comment;
import com.example.demo.service.CommentService;

@RestController
@RequestMapping("/api/v1")
public class MyRestController {

	@Autowired
	private CommentService service;

	@GetMapping("/comments")
	public List<Comment> getAllComments(@RequestParam("page") int id) {
		return this.service.getAllComments(id);
	}
	
	@GetMapping("/comments/{id}")
	public Comment getComment(@PathVariable String id) {
		return this.service.getComment(id);
	}
	
	@PostMapping("/comments")
	public Comment addComment(@RequestBody Comment com) {
		return this.service.addComment(com);
	}
	
	@DeleteMapping("/comments/{id}")
	public Comment deleteComment(@PathVariable String id) {
		return this.service.deleteComment(id);
	}
	
	@PutMapping("/comments/{id}")
	public Comment updateComment(@PathVariable String id, @RequestBody Comment com) {
		return this.service.updateComment(id, com);
	}
	
}
