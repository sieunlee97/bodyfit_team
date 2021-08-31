package com.bodyfit.bodyfit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bodyfit.bodyfit.mapper.BoardTypeMapper;
import com.bodyfit.bodyfit.model.BoardTypeDTO;

@Service
public class BoardTypeService {
	@Autowired
	private BoardTypeMapper boardTypeMapper;
	
	/*카테고리 목록 조회*/
	public List<BoardTypeDTO> selectBoardTypeList() throws Exception{
		List<BoardTypeDTO> boardType = boardTypeMapper.selectBoardTypeList();
		return boardType;
	}
	/*카테고리 상세보기*/
	public BoardTypeDTO selectBoardTypeDetail(String boardType) throws Exception{
		return boardTypeMapper.selectBoardTypeDetail(boardType);
	}
	/*카테고리 등록*/
	public void insertBoardType(BoardTypeDTO boardTypeDTO) throws Exception{
		boardTypeMapper.insertBoardType(boardTypeDTO);
	}
	/*카테고리 삭제*/
	public void deleteBoardType(String boardType) throws Exception{
		boardTypeMapper.deleteBoardType(boardType);
	}
	/*카테고리 수정*/
	public void updateBoardType(BoardTypeDTO boardTypeDTO) throws Exception{
		boardTypeMapper.updateBoardType(boardTypeDTO);
	}
}
