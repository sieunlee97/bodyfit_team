package com.bodyfit.bodyfit.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bodyfit.bodyfit.model.InbodyDTO;

@Mapper
public interface InbodyMapper {
	public void insertInbody(InbodyDTO inbodyDTO) throws Exception;
	public InbodyDTO selectInbodyDetail(String email) throws Exception;
}
