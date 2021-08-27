package com.bodyfit.bodyfit;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.CollectionUtils;

import com.bodyfit.bodyfit.mapper.MemberMapper;
import com.bodyfit.bodyfit.model.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class MapperTest {

	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	public void testOfInsert() throws Exception {
		UserDto params = new UserDto();
		params.setEmail("testgmail.com");
		params.setNickname("테스터");
		params.setPassword("123456578");
		
		memberMapper.insertMember(params);
	}
	
	@Test
	public void testOfSelectDetail() throws Exception {
		UserDto member = memberMapper.selectMemberDetail("test2@abc.com");
		try {
			String memberJson = new ObjectMapper().writeValueAsString(member);
			System.out.println("=============================");
			System.out.println(memberJson);
			System.out.println("=============================");
		} catch (JsonProcessingException e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOfUpdate() throws Exception {
		UserDto params = new UserDto();
		params.setNickname("수정자");
		params.setPassword("123456789");
		params.setLevels("ROLE_USER");
		params.setEnabled("Y");
		params.setEmail("test2@abc.com");
		memberMapper.updateMember(params);
		if(true) {
			UserDto member = memberMapper.selectMemberDetail("test2@abc.com");
			try {
				String memberJson = new ObjectMapper().writeValueAsString(member);
				System.out.println("=============================");
				System.out.println(memberJson);
				System.out.println("=============================");
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testOfDelete() throws Exception {
		memberMapper.deleteMember("test2@abc.com");
		if(true) {
			UserDto member = memberMapper.selectMemberDetail("test2@abc.com");
			try {
				String memberJson = new ObjectMapper().writeValueAsString(member);
				System.out.println("=============================");
				System.out.println(memberJson);
				System.out.println("=============================");
			}catch(JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testSelectList() throws Exception {
		int memberTotalCount = memberMapper.selectMemberTotalCount();
		if (memberTotalCount > 0) {
			List<UserDto> memberList = memberMapper.selectMemberList();
			if (CollectionUtils.isEmpty(memberList) == false) {
				for (UserDto member : memberList) {
						System.out.println("=========================");
						System.out.println(member.getEmail());
						System.out.println(member.getNickname());
						System.out.println(member.getEnabled());
						System.out.println(member.getLevels());
						System.out.println("=========================");
				}
			}
		}
	}
	
	@Test
	public void testOfLogin() throws Exception {
		UserDto params = new UserDto();
		params.setEmail("bodyfit@gamil.com");
		params.setPassword("1234");
		
		String encodePassword = passwordEncoder.encode(params.getPassword());
		params.setPassword(encodePassword);
		memberMapper.login(params);
		memberMapper.selectMemberDetail("bodyfit@gamil.com");
	}
	
	
}