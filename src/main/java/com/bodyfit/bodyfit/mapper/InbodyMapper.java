package com.bodyfit.bodyfit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bodyfit.bodyfit.model.InbodyDTO;

@Mapper
public interface InbodyMapper {
	public void insertInbody(InbodyDTO inbodyDTO) throws Exception;
	public List<InbodyDTO> selectInbodyList(String email) throws Exception;
	public InbodyDTO selectInbodyDetail(String email) throws Exception;
}
