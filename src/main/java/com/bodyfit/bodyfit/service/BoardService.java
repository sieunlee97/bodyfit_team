package com.bodyfit.bodyfit.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bodyfit.bodyfit.mapper.BoardMapper;
import com.bodyfit.bodyfit.model.BoardDTO;
import com.bodyfit.bodyfit.paging.PaginationInfo;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	public List<BoardDTO> selectBoardList(BoardDTO boardDTO) throws Exception {
		List<BoardDTO> list = Collections.emptyList();
		int boardTotalCount = 0;
		
		try {
			boardTotalCount = boardMapper.selectBoardTotalCount(boardDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PaginationInfo paginationInfo = new PaginationInfo(boardDTO);
		paginationInfo.setTotalRecordCount(boardTotalCount);
		
		boardDTO.setPaginationInfo(paginationInfo);
		
		if (boardTotalCount > 0) {
			list = boardMapper.selectBoardList(boardDTO);
		}
		//System.out.println(boardList);
		return list;
	}
	
	
	public int selectBoardTotalCount(BoardDTO boardDTO) throws Exception{
		return boardMapper.selectBoardTotalCount(boardDTO);
	}

	public BoardDTO selectBoardDetail(BoardDTO boardDTO) throws Exception {
		
		return boardMapper.selectBoardDetail(boardDTO);
	}
	public void updateViewCount(Integer bno) throws Exception{
		boardMapper.updateViewCount(bno);
	}
	public void insertBoard(BoardDTO boardDTO) throws Exception{
		boardMapper.insertBoard(boardDTO);
	}
	public void deleteBoard(BoardDTO boardDTO) throws Exception{
		System.out.println("boardService"+boardDTO);
		boardMapper.deleteBoard(boardDTO);
	}
	public void updateBoard(BoardDTO boardDTO) throws Exception{
		boardMapper.updateBoard(boardDTO);
	}
}
