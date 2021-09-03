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

//==================================================================================================================== 게시글 삭제
	@PostMapping(value = "/board/boardDelete")
	public String boardDelete(@RequestParam(value = "bno", required = false) Integer bno) throws Exception {
		System.out.println(bno);
		if (bno == null) {
			// TODO => 올바르지 않은 접근이라는 메시지를 전달하고, 게시글 리스트로 리다이렉트
			return "redirect:/board/boardList";
		}
		boardService.deleteBoard(bno);
		return "redirect:/board/boardList";
	}
//==================================================================================================================== 게시글 수정
	@PostMapping(value="/board/boardUpdate")
	public String boardUpdate(@ModelAttribute("params") BoardDTO params,BoardDTO boardDTO) throws Exception{		
		boardService.updateBoard(boardDTO);
		
		return "redirect:/board/boardView?currentPageNo="+params.getCurrentPageNo()+"&bno="+boardDTO.getBno();
	}
	
	@GetMapping(value="/board/boardUpdate")
	public String boardUpdate(@RequestParam(value="bno", required=false) Integer bno, Model model) throws Exception{
		System.out.println("bno====================="+bno);
		if(bno==null) {
			return "redirect:/board/boardList";
		}
		BoardDTO board = boardService.selectBoardDetail(bno);
		model.addAttribute("board", board);
		return "board/boardUpdate";
	}
	
//==================================================================================================================== 게시글 상세보기	
	@GetMapping(value="/board/boardView")
	public String boardView(@ModelAttribute("params") BoardDTO params,@RequestParam(value="bno", required=false) Integer bno, Model model) throws Exception{
		if(bno==null) {
			return "redirect:/board/boardList";
		}
		BoardDTO board = boardService.selectBoardDetail(bno);
		model.addAttribute("board", board);
		return "board/boardView";
	}
	
//===================================================================================================================== 게시글 등록
	@PostMapping(value="/board/boardRegister")
	public String boardRegister(BoardDTO boardDTO) throws Exception{		
		boardService.insertBoard(boardDTO);
		return "redirect:/board/boardList";
	}
	
	@GetMapping(value="/board/boardWrite")
	public String boardWrite(Model model) throws Exception {

		return "board/boardWrite";
	}
//==================================================================================================================== 게시글 목록	
	@GetMapping(value="/board/boardList")
	public String boardList(@ModelAttribute("params") BoardDTO boardDTO, Model model, BoardTypeDTO boardTypeDTO) throws Exception {
		System.out.println("/board/boardList");
		List<BoardDTO> list = boardService.selectBoardList(boardDTO);
		System.out.println("list : "+list);
		model.addAttribute("list", list);
	    
		List<BoardTypeDTO> board_type = boardTypeService.selectBoardTypeList();
		model.addAttribute("board_type", board_type);
		return "board/boardList";
		
	}
		
}
