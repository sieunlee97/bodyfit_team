package com.bodyfit.bodyfit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class InbodyController {
	@GetMapping(value="/inbody/main")
	public String home(Model model) throws Exception {

		return "inbody/main";
		
	}
}
