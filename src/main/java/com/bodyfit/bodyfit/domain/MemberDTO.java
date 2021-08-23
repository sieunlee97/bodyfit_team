package com.bodyfit.bodyfit.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {
	/*사용자 이메일*/
	private String email;
	/*사용자 닉네임*/
	private String nickname;
	/*사용자 비밀번호*/
	private String password;
	/*가입일시*/
	private LocalDateTime reg_date;
	/*수정일시*/
	private LocalDateTime update_date;
	/*마지막 로그인 일시*/
	private LocalDateTime last_login_date;
	/*로그인 횟수*/
	private int login_cnt;
	/*활성 상태(가입/탈퇴)*/
	private String enabled;
	/*권한*/
	private String levels;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public LocalDateTime getLast_login_date() {
		return last_login_date;
	}
	public void setLast_login_date(LocalDateTime last_login_date) {
		this.last_login_date = last_login_date;
	}
	public int getLogin_cnt() {
		return login_cnt;
	}
	public void setLogin_cnt(int login_cnt) {
		this.login_cnt = login_cnt;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public String getLevels() {
		return levels;
	}
	public void setLevels(String levels) {
		this.levels = levels;
	}
}
