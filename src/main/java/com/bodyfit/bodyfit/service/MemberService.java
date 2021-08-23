package com.bodyfit.bodyfit.service;

import java.util.List;

import com.bodyfit.bodyfit.domain.MemberDTO;

public interface MemberService {
	public boolean insertMember(MemberDTO params);
	public MemberDTO getMemberDetail(String email);
	public boolean deleteMember(String email);
	public List<MemberDTO> getMemberList();
}
