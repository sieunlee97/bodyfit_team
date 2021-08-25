package com.bodyfit.bodyfit;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import com.bodyfit.bodyfit.dao.MemberDAO;
import com.bodyfit.bodyfit.domain.MemberDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class MapperTests {

	@Autowired
	private MemberDAO memberMapper;
	
	@Test
	public void testOfInsert() throws Exception {
		MemberDTO params = new MemberDTO();
		params.setEmail("test2@abc.com");
		params.setNickname("테스터2");
		params.setPassword("123456578");
		
		memberMapper.insertMember(params);
	}
	
	@Test
	public void testOfSelectDetail() throws Exception {
		MemberDTO member = memberMapper.selectMemberDetail("test2@abc.com");
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
		MemberDTO params = new MemberDTO();
		params.setNickname("수정자");
		params.setPassword("123456789");
		params.setLevels("free");
		params.setEnabled("Y");
		params.setEmail("test2@abc.com");
		memberMapper.updateMember(params);
		if(true) {
			MemberDTO member = memberMapper.selectMemberDetail("test2@abc.com");
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
			MemberDTO member = memberMapper.selectMemberDetail("test2@abc.com");
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
			List<MemberDTO> memberList = memberMapper.selectMemberList();
			if (CollectionUtils.isEmpty(memberList) == false) {
				for (MemberDTO member : memberList) {
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
	
}
