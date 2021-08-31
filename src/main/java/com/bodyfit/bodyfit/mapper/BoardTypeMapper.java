package com.bodyfit.bodyfit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bodyfit.bodyfit.model.BoardTypeDTO;

@Mapper
public interface BoardTypeMapper {
	/*카테고리 목록 조회*/
	public List<BoardTypeDTO> selectBoardTypeList() throws Exception;
	/*카테고리 상세보기*/
	public BoardTypeDTO selectBoardTypeDetail(String boardType) throws Exception;
	/*카테고리 등록*/
	public void insertBoardType(BoardTypeDTO boardTypeDTO) throws Exception;
	/*카테고리 삭제*/
	public void deleteBoardType(String boardType) throws Exception;
	/*카테고리 수정*/
	public void updateBoardType(BoardTypeDTO boardTypeDTO) throws Exception;

}
