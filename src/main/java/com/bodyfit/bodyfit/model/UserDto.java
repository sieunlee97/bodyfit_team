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
	private Timestamp regDate;
	private Timestamp updateDate;
	private Timestamp lastLoginDate;
	private int loginCnt;
	
	
}
