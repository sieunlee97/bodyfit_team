package com.bodyfit.bodyfit.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bodyfit.bodyfit.dao.MemberDAO;
import com.bodyfit.bodyfit.domain.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void insertMember(MemberDTO memberDTO) throws Exception {
		String encodePassword = passwordEncoder.encode(memberDTO.getPassword());
		memberDTO.setPassword(encodePassword);
		memberDAO.insertMember(memberDTO);		
	}

	@Override
	public MemberDTO selectMemberDetail(String email) throws Exception {
		return memberDAO.selectMemberDetail(email);
	}

	@Override
	public void updateMember(MemberDTO memberDTO) throws Exception {
		memberDAO.updateMember(memberDTO);
	}

	@Override
	public void deleteMember(String email) throws Exception {
		memberDAO.deleteMember(email);
		
	}

	@Override
	public List<MemberDTO> selectMemberList() throws Exception {
		return memberDAO.selectMemberList();
	}

	@Override
	public int selectMemberTotalCount() throws Exception {
		return memberDAO.selectMemberTotalCount();
	}

	@Override
	public int login(MemberDTO memberDTO) throws Exception {
		return memberDAO.login(memberDTO);
	}

	

}
