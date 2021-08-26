package com.bodyfit.bodyfit.securingWeb.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bodyfit.bodyfit.model.User;

//시큐리티가 /account/login 주소 요청이 오면 낚아채서 로그인을 진행시킨다.
//로그인 진행이 왼료되면 시큐리티 session공간을 만든다.
//오브젝트 => Authentication 타입 
//Authentication 안에는 User정보가 있다.
//User오브젝트 => UserDetails 타입

//Security Session <= Authentication <= UserDetails

public class PrincipalDetails implements UserDetails {

	private User user; //콤포지션
	
	public PrincipalDetails (User user) {
		this.user = user;
	}
	
	
	//해당 유저의 권한 리턴
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collect = new ArrayList<>();
		collect.add(new GrantedAuthority() {
			
			@Override
			public String getAuthority() {
				return user.getLevels();
			}
		});
		return collect;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
