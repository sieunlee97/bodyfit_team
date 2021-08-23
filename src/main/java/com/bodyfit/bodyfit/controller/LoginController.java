package com.bodyfit.bodyfit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bodyfit.bodyfit.service.MemberService;

@Controller
public class LoginController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping(value="/member/login.do")
	public String openLogin(Model model) {
		return "member/login";
		
	}
}
