package com.bodyfit.bodyfit.util;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.bodyfit.bodyfit.constant.Method;
import com.bodyfit.bodyfit.paging.Criteria;

@Controller
public class UIUtil {
	public String showMessageWithRedirect(@RequestParam(value = "message", required = false) String message,
			  @RequestParam(value = "redirectUri", required = false) String redirectUri,
			  @RequestParam(value = "method", required = false) Method method,
			  @RequestParam(value = "params", required = false) Map<String, Object> params, Model model) {

			model.addAttribute("message", message);
			model.addAttribute("redirectUri", redirectUri);
			model.addAttribute("method", method);
			model.addAttribute("params", params);
			
			return "util/message-redirect";
	}
	
	//Criteria 클래스의 모든 멤버 번수(이전 페이지 정보)를 Map에 Key, Value 형태로 담아 리턴하는 메서드
	//POST 방식의 처리에서만 사용
	public Map<String, Object> getPagingParams(Criteria criteria) {

		Map<String, Object> params = new LinkedHashMap<>();
		params.put("currentPageNo", criteria.getCurrentPageNo());
		params.put("recordsPerPage", criteria.getRecordsPerPage());
		params.put("pageSize", criteria.getPageSize());
		params.put("searchType", criteria.getSearchType());
		params.put("searchKeyword", criteria.getSearchKeyword());

		return params;
	}
}
