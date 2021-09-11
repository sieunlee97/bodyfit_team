package com.bodyfit.bodyfit.model;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BoardDTO extends CommonDTO {
	/*글번호(PK)*/
	private Integer bno;
	/*게시판 카테고리(PK)*/
	private String boardType;
	/*글제목*/
	private String title;
	/*글내용*/
	private String content;
	/*작성자*/
	private String writer;
	/*작성일시*/
	private LocalDateTime regDate;
	/*수정일시*/
	private LocalDateTime updateDate;
	/*좋아요수*/
	private int likeCnt;
	/*싫어요수*/
	private int dislikeCnt;
	/*히든글여부*/
	private String hiddenYn;
	
	@Override
	public String toString() {
		return "BoardDTO [bno=" + bno + ", boardType=" + boardType + ", title=" + title + ", content=" + content
				+ ", writer=" + writer + ", regDate=" + regDate + ", updateDate=" + updateDate + ", likeCnt=" + likeCnt
				+ ", dislikeCnt=" + dislikeCnt + ", hiddenYn=" + hiddenYn + "]";
	}

	

	
}