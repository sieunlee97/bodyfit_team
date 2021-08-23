package com.bodyfit.bodyfit.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bodyfit.bodyfit.domain.MemberDTO;
import com.bodyfit.bodyfit.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public boolean insertMember(MemberDTO params) {
		int queryResult = 0;
		
		if(params.getEmail() == null) {
			queryResult = memberMapper.insertMember(params);
		}else {
			queryResult = memberMapper.updateMember(params);
		}
		return (queryResult == 1)? true : false;
	}

	@Override
	public MemberDTO getMemberDetail(String email) {
		return memberMapper.selectMemberDetail(email);
	}

	@Override
	public boolean deleteMember(String email) {
		int queryResult = 0;
		MemberDTO member = memberMapper.selectMemberDetail(email);
		if(member != null && "N".equals(member.getEnabled())) {
			queryResult = memberMapper.deleteMember(email);
		}
		
		return (queryResult == 1)? true : false;
	}

	@Override
	public List<MemberDTO> getMemberList() {
		List<MemberDTO> memberList = Collections.emptyList();
		
		int memberTotalCount = memberMapper.selectMemberTotalCount();
		
		if(memberTotalCount > 0) {
			memberList = memberMapper.selectMemberList();
		}
		
		return memberList;
	}

}
