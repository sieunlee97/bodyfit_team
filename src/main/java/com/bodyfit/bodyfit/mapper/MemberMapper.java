package com.bodyfit.bodyfit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bodyfit.bodyfit.domain.MemberDTO;

@Mapper
public interface MemberMapper {
	/*멤버 추가*/
	public int insertMember(MemberDTO params);
	/*멤버 상세보기*/
	public MemberDTO selectMemberDetail(String email);
	/*멤버 수정*/
	public int updateMember(MemberDTO params);
	/*멤버 삭제*/
	public int deleteMember(String email);
	/*멤버 목록보기*/
	public List<MemberDTO> selectMemberList();
	/*총 멤버 수*/
	public int selectMemberTotalCount();
}
