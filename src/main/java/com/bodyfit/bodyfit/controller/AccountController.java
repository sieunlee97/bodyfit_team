package com.bodyfit.bodyfit.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bodyfit.bodyfit.domain.MemberDTO;
import com.bodyfit.bodyfit.service.MemberService;


@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private MemberService memberService;
	
	
	@PostMapping(value="/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password , Model model, HttpSession session) throws Exception{
		if(email==null ||password==null) {
			model.addAttribute("msg", "아이디 또는 비밀번호를 입력해주세요.");
		}
		
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setEmail(email);
		memberDTO.setPassword(password);
		
		int result = memberService.login(memberDTO);
		
		if(result==1) {
			session.setAttribute("memberDTO", memberDTO);
		} else {
			model.addAttribute("msg", "아이디 또는 비밀번호를 입력해주세요.");
		}
		return "/member/mypage";
	}
	
	@GetMapping(value="/login")
	public String login(Model model) {
		return "account/login";	
	}
	
	@GetMapping(value="/register")
	public String register() {
		return "account/register";
	}
	
	@PostMapping(value = "/register")
	public String register(MemberDTO memberDTO) throws Exception {
		memberService.insertMember(memberDTO);
		return "redirect:/";
	}
	 
}
