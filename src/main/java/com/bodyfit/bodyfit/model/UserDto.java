package com.bodyfit.bodyfit.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class UserDTO {
	private String email;
	private String nickname;
	private String password;
	private String enabled;
	private String levels;
	private Timestamp reg_date;
	private Timestamp update_date;
	private Timestamp last_login_date;
	private int login_cnt;
	
	
}
