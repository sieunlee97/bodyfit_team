package com.bodyfit.bodyfit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.bodyfit.bodyfit.model.BoardTypeDTO;
import com.bodyfit.bodyfit.model.UserDTO;
import com.bodyfit.bodyfit.service.BoardTypeService;

@Controller
public class ControllerAdviceException {
	
	@Autowired
	private BoardTypeService boardTypeService;
	
	
	//컨트롤러 매핑이 걸린 모든 메소드(jsp와 매칭)에서 공통으로 사용할 modelAttribute 생성 (board_type_list)
	@ModelAttribute("board_type_list")
	public List<BoardTypeDTO> board_type_list() throws Exception{
		List<BoardTypeDTO> board_type_list = boardTypeService.selectBoardTypeList();
		System.out.println("board_type_list"+board_type_list);
		return board_type_list;
	}
	
	@ModelAttribute("loginUser")
	public UserDTO loginUser(HttpSession session) throws Exception{
		UserDTO loginUser = (UserDTO) session.getAttribute("session_info");
		return loginUser;
	}
}
