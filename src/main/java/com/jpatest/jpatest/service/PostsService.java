package com.jpatest.jpatest.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jpatest.jpatest.domain.posts.Posts;
import com.jpatest.jpatest.domain.posts.PostsRepository;
import com.jpatest.jpatest.web.dto.PostsSaveRequestDto;
import com.jpatest.jpatest.web.dto.PostsUpdateRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostsService {
	private final PostsRepository postsRepository;
	
	@Transactional
	public Long save(PostsSaveRequestDto requestDto) {
		return postsRepository.save(requestDto.toEntity()).getId();
	}
	
	@Transactional
	public Long update(Long id, PostsUpdateRequestDto requestDto) {
		Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. ID = "+id))
	}
}