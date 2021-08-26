package com.bodyfit.bodyfit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bodyfit.bodyfit.model.User;


//CRUD 함수를 JpaRepository가 가지고 있음.
//@Repository 어노테이션 필요 없음
public interface UserRepository extends JpaRepository<User, String> {
	public User findByEmail(String username);
}
