package com.bodyfit.bodyfit.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bodyfit.bodyfit.constant.Method;
import com.bodyfit.bodyfit.model.BoardDTO;
import com.bodyfit.bodyfit.model.BoardTypeDTO;
import com.bodyfit.bodyfit.model.UserDTO;
import com.bodyfit.bodyfit.service.BoardService;
import com.bodyfit.bodyfit.service.BoardTypeService;
import com.bodyfit.bodyfit.util.UIUtil;

@Controller
public class BoardController extends UIUtil {

	@Autowired
	private BoardService boardService;
	
	@Autowired
	private BoardTypeService boardTypeService;

//========================================================================================================== 게시글 삭제
	@PostMapping(value = "/board/boardDelete")
	public String boardDelete(@ModelAttribute("boardDTO") BoardDTO boardDTO, @RequestParam(value = "bno", required = false) Integer bno, Model model) {
		if (bno == null) {
			return showMessageWithRedirect("올바르지 않은 접근입니다.", "/board/listNotice", Method.GET, null, model);
		}
		Map<String, Object> pagingParams = getPagingParams(boardDTO);
		try {
			boardService.deleteBoard(bno);
		} catch (Exception e) {
			return showMessageWithRedirect("게시글 삭제에 실패하였습니다.","/board/listNotice", Method.GET, pagingParams, model);
		}
		return showMessageWithRedirect("게시글 삭제가 완료되었습니다.", "/board/listNotice", Method.GET, pagingParams, model);
	}

//========================================================================================================== 게시글 수정
	@PostMapping(value="/board/boardUpdate")
	public String boardUpdate(@ModelAttribute("params") BoardDTO params, Model model){		
		Map<String, Object> pagingParams = getPagingParams(params);
		try {
			System.out.println("updateBoard 호출 전");
			boardService.updateBoard(params);
			System.out.println("updateBoard 호출 후");
		} catch (Exception e) {
			return showMessageWithRedirect("게시글 수정에 실패하였습니다.", "/board/listNotice", Method.GET, pagingParams, model);
		}
		//System.out.println(pagingParams.toString());
		return showMessageWithRedirect("게시글 수정이 완료되었습니다.", "/board/boardView?bno="+params.getBno()+"&currentPageNo="+params.getCurrentPageNo(), Method.GET, null, model);
		
	}
	
	@GetMapping(value="/board/boardUpdate")
	public String boardUpdate(@ModelAttribute("params") BoardDTO params, @RequestParam(value="bno", required=false) Integer bno, Model model) throws Exception{
		BoardDTO board = boardService.selectBoardDetail(bno);
		if(board == null) {
			return showMessageWithRedirect("없는 게시글이거나 이미 삭제된 게시글입니다.", "/board/listNotice", Method.GET, null, model);
		}		
		model.addAttribute("board", board);
		return "board/boardUpdate";
	}
	
//======================================================================================================== 게시글 상세보기	
	@GetMapping(value="/board/boardView")
	public String boardView(HttpSession session, @ModelAttribute("params") BoardDTO params, @RequestParam(value="boardType", required=false) String boardType ,@RequestParam(value="bno", required=false) Integer bno, Model model) throws Exception{
		if(bno==null) {
			return showMessageWithRedirect("올바르지 않은 접근입니다.", "/board/listNotice", Method.GET, null, model);
		}
		BoardDTO board = boardService.selectBoardDetail(bno);
		if(board == null) {
			return showMessageWithRedirect("없는 게시글이거나 이미 삭제된 게시글입니다.", "/board/listNotice",Method.GET, null, model);
		}
		UserDTO loginUser = (UserDTO) session.getAttribute("session_info");
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("board", board);
		return "board/boardView";
	}
	
//======================================================================================================== 게시글 등록
	@PostMapping(value="/board/boardRegister")
	public String boardRegister(BoardDTO boardDTO, Model model){		
		try {
			boardService.insertBoard(boardDTO);
		} catch (Exception e) {
			return showMessageWithRedirect("게시글 등록에 실패하였습니다.", "/board/listNotice", Method.GET, null, model);
		}
		return showMessageWithRedirect("게시글 등록이 완료되었습니다.", "/board/listNotice", Method.GET, null, model);
	}
	
	@GetMapping(value="/board/boardWrite")
	public String boardWrite(Model model, BoardDTO boardDTO, HttpSession session) throws Exception {
		UserDTO loginUser = (UserDTO) session.getAttribute("session_info");
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("board", boardDTO);
		return "board/boardWrite";
	}
//========================================================================================================= 게시글 목록	
	@GetMapping(value="/board/listNotice")
	public String listNotice(@ModelAttribute("params") 
	BoardDTO boardDTO, Model model, BoardTypeDTO boardTypeDTO) throws Exception {
		List<BoardDTO> list = boardService.selectBoardList(boardDTO);   
		model.addAttribute("list", list);   
		List<BoardTypeDTO> board_type = boardTypeService.selectBoardTypeList();
		model.addAttribute("board_type", board_type);
		return "board/listNotice";
		
	}
	@GetMapping(value="/board/listCommunity")
	public String listCommunity(@ModelAttribute("params") 
	BoardDTO boardDTO, Model model, BoardTypeDTO boardTypeDTO) throws Exception {
		List<BoardDTO> list = boardService.selectBoardList(boardDTO);
		model.addAttribute("list", list);   
		List<BoardTypeDTO> board_type = boardTypeService.selectBoardTypeList();
		model.addAttribute("board_type", board_type);
		return "board/listCommunity";
		
	}
		
}
