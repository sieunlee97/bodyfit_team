package com.bodyfit.bodyfit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bodyfit.bodyfit.model.UserDto;
import com.bodyfit.bodyfit.service.MemberService;


@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	@GetMapping(value="/")
	public String home(Model model) {
		return "index";
		
	}
	
	
	@GetMapping(value="/member/boardList")
	public String boardList() {
		return "member/boardList";
		
	}
	
	@GetMapping(value="/member/mypage")
	public String mypage() {
		return "member/mypage";
		
	}

	@GetMapping(value="/account/registerForm")
	public String register() {
		return "account/registerForm";
	}
	
	@PostMapping(value="/account/register")
	public String register(UserDto user) throws Exception {
		memberService.insertMember(user);
		return "redirect:/account/loginForm";
	}
	

	@GetMapping(value="/account/loginForm")
	public String login(Model model) {
		System.out.println("로그인폼 get매핑됨");
		return "account/loginForm";
		
	}
	
	@PostMapping(value="/account/login")
	public String login(UserDto user) throws Exception {
		System.out.println("로그인 post매핑됨"+user);
		boolean result = memberService.login(user);
		if(result == true) {
			return "index";
		}else {
			return "account/loginForm";
		}
	}
	
}
