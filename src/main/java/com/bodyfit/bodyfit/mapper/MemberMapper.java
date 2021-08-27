package com.bodyfit.bodyfit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bodyfit.bodyfit.model.UserDto;

@Mapper
public interface MemberMapper {
	/*멤버 추가*/
	public void insertMember(UserDto userDto) throws Exception;
	/*멤버 상세보기*/
	public UserDto selectMemberDetail(String email) throws Exception;
	/*멤버 수정*/
	public void updateMember(UserDto userDto)throws Exception;
	/*멤버 삭제*/
	public void deleteMember(String email)throws Exception;
	/*멤버 목록보기*/
	public List<UserDto> selectMemberList()throws Exception;
	/*총 멤버 수*/
	public int selectMemberTotalCount() throws Exception;
	/*로그인*/
	public int login(UserDto userDto) throws Exception;
	/*이메일체크*/
	public int idCheck(String email) throws Exception;
}
