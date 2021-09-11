package com.bodyfit.bodyfit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bodyfit.bodyfit.mapper.InbodyMapper;
import com.bodyfit.bodyfit.model.InbodyDTO;

@Service
public class InbodyService {
	
	@Autowired
	private InbodyMapper inbodyMapper;
	
	public void insertInbody(InbodyDTO inbodyDTO) throws Exception{
		inbodyMapper.insertInbody(inbodyDTO);
	}
	public List<InbodyDTO> selectInbodyList(String email) throws Exception {
		return inbodyMapper.selectInbodyList(email);
	}
	
	public InbodyDTO selectInbodyDetail(String email) throws Exception {
		return inbodyMapper.selectInbodyDetail(email);
	}
}
