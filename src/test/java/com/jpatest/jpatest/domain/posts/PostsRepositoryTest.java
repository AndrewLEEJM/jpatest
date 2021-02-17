package com.jpatest.jpatest.domain.posts;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostsRepositoryTest {
	
	@Autowired
	PostsRepository postRepository;
	
	@AfterEach
	public void cleanup() {
		postRepository.deleteAll();
	}
	
	@Test
	public void get_content() {
		//given
		String title = "테스트 게시글";
		String content = "테스트 본물";
		
		postRepository.save(Posts.builder().title(title).content(content).author("woals@gmail.com").build());
		
		//when
		List<Posts> postsList = postRepository.findAll();
		
		//then
		Posts posts = postsList.get(0);
		assertThat(posts.getTitle()).isEqualTo(title);
		assertThat(posts.getContent()).isEqualTo(content);
	}
	
	@Test
	public void BaseTimeEntity_insert() {
		//given
		LocalDateTime now = LocalDateTime.of(2021, 2, 9, 0, 0, 0);
		postRepository.save(Posts.builder().title("title").content("content").author("woals@gmail.com").build());
		
		//when
		List<Posts> postsList = postRepository.findAll();
		
		//then
		Posts posts = postsList.get(0);
		
		System.out.println(">>> createDate = " + posts.getCreatedDate() + ", modifiedDate = " + posts.getModifiedDate());
		
		assertThat(posts.getCreatedDate()).isAfter(now);
		assertThat(posts.getModifiedDate()).isAfter(now);
	}
}
