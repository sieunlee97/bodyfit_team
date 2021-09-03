package com.bodyfit.bodyfit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bodyfit.bodyfit.model.BoardDTO;
import com.bodyfit.bodyfit.model.BoardTypeDTO;
import com.bodyfit.bodyfit.service.BoardService;
import com.bodyfit.bodyfit.service.BoardTypeService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@Autowired
	private BoardTypeService boardTypeService;

//====================================================================================================================================== 게시글 삭제
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
	
//====================================================================================================================================== 게시글 상세보기	
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
	
//====================================================================================================================================== 게시글 등록/수정		
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
		if(bno == null) { // 글 새로 등록
			model.addAttribute("board",new BoardDTO());
		}else {			 // 글 수정
			BoardDTO board = boardService.selectBoardDetail(bno);
			if(board == null) {
				return "redirect:/member/boardList";
			}
			model.addAttribute("board", board);
		}
		return "member/boardWrite";
		
	}
//====================================================================================================================================== 게시글 목록	
	@GetMapping(value="/member/boardList")
	public String boardList(@ModelAttribute("params") BoardDTO boardDTO, Model model, BoardTypeDTO boardTypeDTO) throws Exception {
		System.out.println("/member/boardList");
		List<BoardDTO> list = boardService.selectBoardList(boardDTO);
		System.out.println("list : "+list);
		model.addAttribute("list", list);
	    
		List<BoardTypeDTO> board_type = boardTypeService.selectBoardTypeList();
		model.addAttribute("board_type", board_type);
		return "member/boardList";
		
	}
		
}
