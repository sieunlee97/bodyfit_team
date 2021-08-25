package com.bodyfit.bodyfit.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.bodyfit.bodyfit.domain.MemberDTO;

@Mapper
@Repository
public interface MemberDAO {
	/*멤버 추가*/
	public void insertMember(MemberDTO memberDTO) throws Exception;
	/*멤버 상세보기*/
	public MemberDTO selectMemberDetail(String email) throws Exception;
	/*멤버 수정*/
	public void updateMember(MemberDTO memberDTO)throws Exception;
	/*멤버 삭제*/
	public void deleteMember(String email)throws Exception;
	/*멤버 목록보기*/
	public List<MemberDTO> selectMemberList()throws Exception;
	/*총 멤버 수*/
	public int selectMemberTotalCount() throws Exception;
	/*로그인*/
	public int login(MemberDTO memberDTO) throws Exception;
	
}
