package com.bodyfit.bodyfit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bodyfit.bodyfit.model.User;
import com.bodyfit.bodyfit.repository.UserRepository;


@Controller
public class MemberController {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping(value="/account/register")
	public String register(User user) {
		System.out.println(user);
		user.setLevels("ROLE_USER");
		user.setEnabled("Y");
		String encodePassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodePassword);
		userRepo.save(user); 
		return "redirect:/account/loginForm";
	}
	
	@GetMapping(value="/account/registerForm")
	public String register() {
		return "account/registerForm";
	}

	@GetMapping(value="/account/loginForm")
	public String login(Model model) {
		return "account/loginForm";
		
	}
	
	@GetMapping(value="/")
	public String home(Model model) {
		return "index";
		
	}
}
