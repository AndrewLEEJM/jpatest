package com.jpatest.jpatest.web.dto;

import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
	
	private String title;
	private String content;
	
	@Builder
	public PostsUpdateRequestDto(String title, String content) {
		this.title = title;
		this.content = content;
	}
}
