package com.jpatest.jpatest.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jpatest.jpatest.config.auth.LoginUser;
import com.jpatest.jpatest.config.auth.dto.SessionUser;
import com.jpatest.jpatest.service.PostsService;
import com.jpatest.jpatest.web.dto.PostsResponseDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {
	
	private final PostsService postsService;

	@GetMapping("/") //@LoginUser를 통해 어느 컨트롤러든디 세션 정보를 가져올 수 있다.
	public String index(Model model, @LoginUser SessionUser user) {
		model.addAttribute("posts", postsService.findAllDesc());
		//SessionUser user = (SessionUser) httpSession.getAttribute("user"); 어노테이션 생성으로 필요 없음
		
		if(user != null) {
			System.out.println(user.getName());
			model.addAttribute("nameUser", user.getName());
		}
		
		return "index";
	}
	
	@GetMapping("/posts/save")
	public String postsSave() {
		return "posts-save";
	}
	
	@GetMapping("/posts/update/{id}")
	public String postsUpdate(@PathVariable Long id, Model model) {
		PostsResponseDto dto = postsService.findById(id);
		model.addAttribute("post", dto);
		return "posts-update";
	}

}
