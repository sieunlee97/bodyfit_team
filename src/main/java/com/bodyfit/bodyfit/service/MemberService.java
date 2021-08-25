package com.bodyfit.bodyfit.service;

import java.util.List;
import java.util.Map;

import com.bodyfit.bodyfit.domain.MemberDTO;

public interface MemberService {
	public void insertMember(MemberDTO memberDTO) throws Exception;
	public MemberDTO selectMemberDetail(String email)throws Exception;
	public void updateMember(MemberDTO memberDTO)throws Exception;
	public void deleteMember(String email)throws Exception;
	public List<MemberDTO> selectMemberList()throws Exception;
	public int selectMemberTotalCount() throws Exception;
	public int login(MemberDTO memberDTO) throws Exception;
}
