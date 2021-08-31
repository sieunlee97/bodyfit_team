package com.bodyfit.bodyfit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bodyfit.bodyfit.model.BoardDTO;
import com.bodyfit.bodyfit.model.BoardTypeDTO;
import com.bodyfit.bodyfit.model.UserDTO;
import com.bodyfit.bodyfit.service.BoardService;
import com.bodyfit.bodyfit.service.BoardTypeService;
import com.bodyfit.bodyfit.service.MemberService;


@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private BoardTypeService boardTypeService;
	
	
	@GetMapping(value="/")
	public String home(Model model,BoardTypeDTO boardTypeDTO) throws Exception {

		return "index";
		
	}
// 게시판 ==============================================================================	
	@PostMapping(value = "/member/boardDelete")
	public String boardDelete(@RequestParam(value = "bno", required = false) Integer bno) throws Exception {
		System.out.println(bno);
		if (bno == null) {
			// TODO => 올바르지 않은 접근이라는 메시지를 전달하고, 게시글 리스트로 리다이렉트
			return "redirect:/member/boardList";
		}
		boardService.deleteBoard(bno);
		return "redirect:/member/boardList";
	}
	
	
	@GetMapping(value="/member/boardView")
	public String boardView(@RequestParam(value="bno", required=false) Integer bno, Model model) throws Exception{
		//System.out.println(bno);
		if(bno==null) {
			return "redirect:/member/boardList";
		}
		BoardDTO board = boardService.selectBoardDetail(bno);
		model.addAttribute("board", board);
		return "member/boardView";
	}
	
	
	
	@PostMapping(value="/member/boardRegister")
	public String boardWrite(BoardDTO boardDTO) throws Exception{		

		if(boardDTO.getWriter() == null) {
			boardDTO.setWriter("작성자");
		}
		boardDTO.setBoardType("notice");
		boardService.insertBoard(boardDTO);
		return "redirect:/member/boardList";
	}
	
	@GetMapping(value="/member/boardRegister")
	public String boardRegister(@RequestParam(value="bno", required=false) Integer bno, Model model) throws Exception {
		if(bno == null) {
			model.addAttribute("board",new BoardDTO());
		}else {
			BoardDTO board = boardService.selectBoardDetail(bno);
			if(board == null) {
				return "redirect:/member/boardList";
			}
			model.addAttribute("board", board);
		}
		return "member/boardWrite";
		
	}
	
	@GetMapping(value="/member/boardList")
	public String boardList(Model model, BoardDTO board, BoardTypeDTO boardTypeDTO) throws Exception {
		List<BoardDTO> list = boardService.selectBoardList();
		model.addAttribute("list", list);

	    
		List<BoardTypeDTO> board_type = boardTypeService.selectBoardTypeList();
		model.addAttribute("board_type", board_type);
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
		System.out.println(user);
		return "redirect:/account/loginForm";
	}
	
// 로그인 ==============================================================================
	@GetMapping(value="/account/loginForm")
	public String login(Model model) {
		System.out.println("로그인폼 get매핑됨");
		return "account/loginForm";
		
	}
	
	@PostMapping(value="/account/login")
	public String login(UserDTO user, HttpSession session, Model model) throws Exception {
		System.out.println("로그인 post매핑됨");
		UserDTO result = memberService.login(user);
		if(result != null) { //로그인 성공
			session.setAttribute("session_info", result);
			//String session_email = (String)session.getAttribute("session_info");
			System.out.println(session);
			return "redirect:/";
		}else {				// 로그인 실패
			return "redirect:/account/loginForm?error";
		}
	}
	
}
