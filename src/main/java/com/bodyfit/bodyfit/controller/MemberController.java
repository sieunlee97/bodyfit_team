package com.bodyfit.bodyfit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bodyfit.bodyfit.constant.Method;
import com.bodyfit.bodyfit.model.UserDTO;
import com.bodyfit.bodyfit.service.BoardService;
import com.bodyfit.bodyfit.service.BoardTypeService;
import com.bodyfit.bodyfit.service.MemberService;
import com.bodyfit.bodyfit.util.UIUtil;


@Controller
public class MemberController extends UIUtil {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private BoardTypeService boardTypeService;
	
	
	@GetMapping(value="/")
	public String home(Model model) throws Exception {

		return "index";
		
	}
	
	@GetMapping(value="/member/deleteMember")
	public String deleteMember(HttpSession session, Model model) throws Exception {
		UserDTO loginUser = (UserDTO) session.getAttribute("session_info");
		System.out.println("session_info"+loginUser.getEmail());
		memberService.deleteMember(loginUser.getEmail());
		session.invalidate();
		return showMessageWithRedirect("회원탈퇴가 완료되었습니다.", "/", Method.GET, null, model);
	}
// 마이페이지 ==============================================================================
	@GetMapping(value="/member/mypage")
	public String mypage(HttpSession session, Model model) throws Exception {
		//마이페이지는 로그인 상태만 접근 가능하기 때문에, 로그인 세션변수를 로그인아이디 변수 session_userid
		UserDTO loginUser = (UserDTO) session.getAttribute("session_info");
		model.addAttribute("loginUser", loginUser);
		return "member/mypage";
		
	}
	
// 회원가입 ==============================================================================
	@GetMapping(value="/account/registerForm")
	public String register() {
		return "account/registerForm";
	}
	
	@PostMapping(value="/account/register")
	public String register(UserDTO user) throws Exception {
		memberService.insertMember(user);
		System.out.println(user);
		return "redirect:/account/loginForm";
	}
	
	@RequestMapping(value="/account/nickname_check", method=RequestMethod.GET)
	@ResponseBody
	public String nickname_check(@RequestParam("nickname") String nickname) {
		String result = "0";
		try {
			String yn = memberService.nicknameCheck(nickname);
			if( yn == "" || yn == null ){
				result = "0";
			} else {
				result = "1";
			}
		} catch (Exception e) {
			result = e.toString();
		}
		return result; // 결과값은 0, 1, 또는 에러메세지 중 한가지
	}
	@RequestMapping(value="/account/email_check", method=RequestMethod.GET)
	@ResponseBody
	public String email_check(@RequestParam("email") String email) {
		String result="0";
		try {
			UserDTO userDTO = memberService.selectMemberDetail(email);
			if(userDTO != null) {result="1";} // 아이디 중복값이 있을 경우
			else {result="0";} // 아이디 중복값이 없을 경우
		} catch (Exception e) {
			result=e.toString();
		}
		return result; // 결과값은 0, 1, 또는 에러메세지 중 한가지
	}
// 로그인 ==============================================================================
	@GetMapping(value="/account/loginForm")
	public String login(Model model) {
		System.out.println("로그인폼 get매핑됨");
		return "account/loginForm";
		
	}
	
	@PostMapping(value="/account/login")
	public String login(UserDTO user, HttpSession session, Model model) throws Exception {
		System.out.println("로그인 post매핑됨");
		UserDTO loginUser = memberService.login(user);
		if(loginUser != null) { //로그인 성공
			session.setAttribute("session_info", loginUser);
			//String session_email = (String)session.getAttribute("session_info");
			System.out.println(session);
			return "redirect:/";
		}else {				// 로그인 실패
			return "redirect:/account/loginForm?error";
		}
	}
	
// 로그아웃 ==============================================================================	
	@GetMapping("/account/logout")
	public String logout(HttpSession session, Model model) {
		session.invalidate();
		return showMessageWithRedirect("로그아웃이 완료되었습니다.", "/", Method.GET, null, model);
	}
}
