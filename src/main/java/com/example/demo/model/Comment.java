package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("comments")
public class Comment {

	private String id;
	private String name;
	private String email;
	private String movie_id;
	private String date;
}
