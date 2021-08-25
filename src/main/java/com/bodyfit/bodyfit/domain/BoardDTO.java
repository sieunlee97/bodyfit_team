package com.bodyfit.bodyfit.domain;

import java.time.LocalDateTime;

public class BoardDTO {
	/*글번호(PK)*/
	private Integer bno;
	/*게시판 카테고리(PK)*/
	private String board_type;
	/*글제목*/
	private String title;
	/*글내용*/
	private String content;
	/*작성자*/
	private String writer;
	/*작성일시*/
	private LocalDateTime reg_date;
	/*수정일시*/
	private LocalDateTime update_date;
	/*좋아요수*/
	private int like_cnt;
	/*싫어요수*/
	private int dislike_cnt;
	/*히든글여부*/
	private String hidden_yn;
	
	
	public Integer getBno() {
		return bno;
	}
	public void setBno(Integer bno) {
		this.bno = bno;
	}
	public String getBoard_type() {
		return board_type;
	}
	public void setBoard_type(String board_type) {
		this.board_type = board_type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public LocalDateTime getReg_date() {
		return reg_date;
	}
	public void setReg_date(LocalDateTime reg_date) {
		this.reg_date = reg_date;
	}
	public LocalDateTime getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(LocalDateTime update_date) {
		this.update_date = update_date;
	}
	public int getLike_cnt() {
		return like_cnt;
	}
	public void setLike_cnt(int like_cnt) {
		this.like_cnt = like_cnt;
	}
	public int getDislike_cnt() {
		return dislike_cnt;
	}
	public void setDislike_cnt(int dislike_cnt) {
		this.dislike_cnt = dislike_cnt;
	}
	public String getHidden_yn() {
		return hidden_yn;
	}
	public void setHidden_yn(String hidden_yn) {
		this.hidden_yn = hidden_yn;
	}
	
	
}
