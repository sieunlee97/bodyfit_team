package com.bodyfit.bodyfit;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.CollectionUtils;

import com.bodyfit.bodyfit.mapper.BoardMapper;
import com.bodyfit.bodyfit.mapper.MemberMapper;
import com.bodyfit.bodyfit.model.BoardDTO;
import com.bodyfit.bodyfit.model.UserDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class MapperTest {

	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	@Test
	public void testBoardSelectList() throws Exception {
		int boardTotalList = boardMapper.selectBoardTotalCount();
		if (boardTotalList > 0) {
			List<BoardDTO> list = boardMapper.selectBoardList();
			if (CollectionUtils.isEmpty(list) == false) {
				for (BoardDTO board : list) {
						System.out.println("=========================");
						System.out.println(board.getBno());
						System.out.println(board.getBoardType());
						System.out.println(board.getTitle());
						System.out.println(board.getWriter());
						System.out.println("=========================");
				}
			}
		}
	}
	@Test
	public void testOfBoardInsert() throws Exception {
		BoardDTO params = new BoardDTO();
		params.setBoardType("공지사항");
		params.setTitle("테스트");
		params.setContent("테스트");
		params.setWriter("테스트");		
		boardMapper.insertBoard(params);
	}
	
	
	@Test
	public void testOfInsert() throws Exception {
		UserDTO params = new UserDTO();
		params.setEmail("testgmail.com");
		params.setNickname("테스터");
		params.setPassword("123456578");
		
		memberMapper.insertMember(params);
	}
	
	@Test
	public void testOfSelectDetail() throws Exception {
		UserDTO member = memberMapper.selectMemberDetail("test2@abc.com");
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
		UserDTO params = new UserDTO();
		params.setNickname("수정자");
		params.setPassword("123456789");
		params.setLevels("ROLE_USER");
		params.setEnabled("Y");
		params.setEmail("test2@abc.com");
		memberMapper.updateMember(params);
		if(true) {
			UserDTO member = memberMapper.selectMemberDetail("test2@abc.com");
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
			UserDTO member = memberMapper.selectMemberDetail("test2@abc.com");
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
			List<UserDTO> memberList = memberMapper.selectMemberList();
			if (CollectionUtils.isEmpty(memberList) == false) {
				for (UserDTO member : memberList) {
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
		UserDTO params = new UserDTO();
		params.setEmail("bodyfit@gamil.com");
		params.setPassword("1234");
		
		String encodePassword = passwordEncoder.encode(params.getPassword());
		params.setPassword(encodePassword);
		memberMapper.login(params);
		memberMapper.selectMemberDetail("bodyfit@gamil.com");
	}
	
	
}