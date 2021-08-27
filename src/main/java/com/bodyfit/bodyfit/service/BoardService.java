package com.bodyfit.bodyfit.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bodyfit.bodyfit.mapper.BoardMapper;
import com.bodyfit.bodyfit.model.BoardDTO;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	public List<BoardDTO> selectBoardList() throws Exception {
		List<BoardDTO> boardList = Collections.emptyList();
		int boardTotalCount = boardMapper.selectBoardTotalCount();
		System.out.println("==============================="+boardTotalCount);

		if (boardTotalCount > 0) {
			boardList = boardMapper.selectBoardList();
		}
		System.out.println(boardList);
		return boardList;
	}
	public int selectBoardTotalCount() throws Exception{
		return boardMapper.selectBoardTotalCount();
	}
	public BoardDTO selectBoardDetail(Integer bno) throws Exception {
		return boardMapper.selectBoardDetail(bno);
	}
	public void updateViewCount(Integer bno) throws Exception{
		boardMapper.updateViewCount(bno);
	}
	public void insertBoard(BoardDTO boardDTO) throws Exception{
		boardMapper.insertBoard(boardDTO);
	}
	public void deleteBoard(Integer bno) throws Exception{
		boardMapper.deleteBoard(bno);
	}
	public void updateBoard(BoardDTO boardDTO) throws Exception{
		boardMapper.updateBoard(boardDTO);
	}
}
