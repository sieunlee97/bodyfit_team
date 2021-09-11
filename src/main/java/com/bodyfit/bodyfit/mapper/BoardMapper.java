package com.bodyfit.bodyfit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bodyfit.bodyfit.model.BoardDTO;

@Mapper
public interface BoardMapper {
	/*게시물 목록 조회*/
	public List<BoardDTO> selectBoardList(BoardDTO boardDTO) throws Exception;
	/*총 게시물 수*/
	public int selectBoardTotalCount(BoardDTO boardDTO) throws Exception;	
	/*게시물 상세보기*/
	public BoardDTO selectBoardDetail(BoardDTO boardDTO) throws Exception;
	/*조회 수*/
	public void updateViewCount(Integer bno) throws Exception;
	/*게시물 등록*/
	public void insertBoard(BoardDTO boardDTO) throws Exception;
	/*게시물 삭제*/
	public void deleteBoard(BoardDTO boardDTO) throws Exception;
	/*게시물 수정*/
	public void updateBoard(BoardDTO boardDTO) throws Exception;

}
