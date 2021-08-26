package com.bodyfit.bodyfit.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
public class User {
	@Id //PK
	private String email;
	
	private String nickname;
	private String password;
	private String enabled;
	private String levels;
	@CreationTimestamp
	private Timestamp reg_date;
	@CreationTimestamp
	private Timestamp update_date;
	@CreationTimestamp
	private Timestamp last_login_date;
	private int login_cnt;
	
	
}
