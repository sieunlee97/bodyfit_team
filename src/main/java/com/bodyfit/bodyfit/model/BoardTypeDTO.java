package com.bodyfit.bodyfit.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardTypeDTO {
	/*게시판 카테고리*/
	private String boardType;
	/*작성일시*/
	private LocalDateTime regDate;
	/*수정일시*/
	private LocalDateTime updateDate;
	
}
