package com.bodyfit.bodyfit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bodyfit.bodyfit.model.BoardDTO;
import com.bodyfit.bodyfit.model.UserDTO;
import com.bodyfit.bodyfit.service.BoardService;
import com.bodyfit.bodyfit.service.MemberService;


@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BoardService boardService;
	
	
	@GetMapping(value="/")
	public String home(Model model) {
		return "index";
		
	}
	

	@GetMapping(value="/member/boardList")
	public String boardList(Model model) throws Exception {
		List<BoardDTO> list = boardService.selectBoardList();
		model.addAttribute("list", list);
		return "member/boardList";
		
	}
	
// 마이페이지 ==============================================================================
	@GetMapping(value="/member/mypage")
	public String mypage() {
		return "member/mypage";
		
	}
	
// 회원가입 ==============================================================================
	@GetMapping(value="/account/registerForm")
	public String register() {
		return "account/registerForm";
	}
	
	@PostMapping(value="/account/register")
	public String register(UserDTO user) throws Exception {
		memberService.insertMember(user);
		return "redirect:/account/loginForm";
	}
	
// 로그인 ==============================================================================
	@GetMapping(value="/account/loginForm")
	public String login(Model model) {
		System.out.println("로그인폼 get매핑됨");
		return "account/loginForm";
		
	}
	
	@PostMapping(value="/account/login")
	public String login(UserDTO user) throws Exception {
		System.out.println("로그인 post매핑됨"+user);
		boolean result = memberService.login(user);
		if(result == true) {
			return "index";
		}else {
			return "account/loginForm";
		}
	}
	
}
