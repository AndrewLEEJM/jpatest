package com.jpatest.jpatest.domain.posts;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
	
	@Autowired
	PostsRepository postRepository;
	
	@AfterEach
	public void cleanup() {
		postRepository.deleteAll();
	}
	
	@Test
	public void 게시글저장_불러오기() {
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
}
