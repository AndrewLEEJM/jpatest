package com.jpatest.jpatest.web.dto;

import java.time.LocalDateTime;

import com.jpatest.jpatest.domain.posts.Posts;

import lombok.Getter;

@Getter
public class PostsListResponseDto {
	
	private Long id;
	private String title;
	private String author;
	private LocalDateTime modifiedDate;
	
	public PostsListResponseDto(Posts entity) {
		super();
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.author = entity.getAuthor();
		this.modifiedDate = entity.getModifiedDate();
	}
	
	

}
