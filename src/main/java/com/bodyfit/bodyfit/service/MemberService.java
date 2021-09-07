package com.bodyfit.bodyfit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bodyfit.bodyfit.mapper.MemberMapper;
import com.bodyfit.bodyfit.model.UserDTO;

@Service
public class MemberService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private MemberMapper memberMapper;
	
	public void insertMember(UserDTO userDto) throws Exception {
		String encodePassword = passwordEncoder.encode(userDto.getPassword());
		userDto.setPassword(encodePassword);
		memberMapper.insertMember(userDto);
	}

	public UserDTO selectMemberDetail(String email) throws Exception {
		return memberMapper.selectMemberDetail(email);
	}

	public void updateMember(UserDTO userDto) throws Exception {
		memberMapper.updateMember(userDto);
	}

	public void deleteMember(String email) throws Exception {
		memberMapper.deleteMember(email);
	}

	public List<UserDTO> selectMemberList() throws Exception {
		return memberMapper.selectMemberList();
	}

	public int selectMemberTotalCount() throws Exception {
		return memberMapper.selectMemberTotalCount();
	}

	public String nicknameCheck(String nickname) throws Exception{
		return memberMapper.nicknameCheck(nickname);
	}
	
	public UserDTO login(UserDTO userDto){
		UserDTO result = null;
		try {
			// 입력한 이메일값을 전달해서 유저 정보 받아옴 = info
			UserDTO info = memberMapper.selectMemberDetail(userDto.getEmail());
			// 해당 이메일을 가진 유저의 가입 비밀번호(암호화O)와 입력한 비밀번호 값 비교
			// passwordEncoder.matches(암호화되기 전 비밀번호,DB에 저장된 암호화된 비밀번호)
			boolean match = passwordEncoder.matches(userDto.getPassword(),info.getPassword());
			if(match == true) {
				return memberMapper.login(info);
			}else {
				throw new Exception();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return result;
		}
	}

}
