package com.bodyfit.bodyfit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DietController {
	
	@GetMapping(value="/diet/dietMain")
	public String main() {
		return "diet/dietMain";
	}
	
	@GetMapping(value="/diet/dietWrite")
	public String write() {
		return "diet/dietWrite";
	}
}
