package com.bodyfit.bodyfit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DietController {
	@GetMapping(value="/diet/main")
	public String main() {
		return "diet/main";
	}
}
