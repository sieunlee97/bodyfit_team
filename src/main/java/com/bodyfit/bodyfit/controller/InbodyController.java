package com.bodyfit.bodyfit.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bodyfit.bodyfit.model.BoardDTO;
import com.bodyfit.bodyfit.model.InbodyDTO;
import com.bodyfit.bodyfit.model.UserDTO;
import com.bodyfit.bodyfit.service.InbodyService;


@Controller
public class InbodyController {
	
	@Autowired
	private InbodyService inbodyService;
	
	@GetMapping(value="/inbody/main")
	public String home(Model model, InbodyDTO inbodyDTO, HttpSession session) throws Exception {
		UserDTO loginUser = (UserDTO) session.getAttribute("session_info");
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("inbodyDTO", inbodyDTO);
		return "inbody/main";
		
	}
	
	@PostMapping(value="/inbody/register")
	public String register(Model model, InbodyDTO inbodyDTO) throws Exception {	
		inbodyService.insertInbody(inbodyDTO);		
		return "inbody/result";
	}
	
	@GetMapping(value="/inbody/result")
	public String result(Model model,InbodyController inbodyDTO, @RequestParam(value="email") String email) throws Exception {
		inbodyService.selectInbodyDetail(email);
		model.addAttribute("inbodyDTO", inbodyDTO);
		return "inbody/result";
	}
	
	
	@GetMapping(value="/inbody/resultList")
	public String resultList(Model model, HttpSession session) throws Exception {
		UserDTO loginUser = (UserDTO) session.getAttribute("session_info");
		model.addAttribute("loginUser", loginUser);
		List<InbodyDTO> list = inbodyService.selectInbodyList(loginUser.getEmail());
		model.addAttribute("list", list);
		return "inbody/resultList";
	}
}
