package com.bodyfit.bodyfit.securingWeb.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bodyfit.bodyfit.model.User;
import com.bodyfit.bodyfit.repository.UserRepository;


//시큐리티 설정에서 loginProcessingUrl("/account/login");
// /account/login 요청이 오면 자동으로UserDetailsService 타입으로 IoC되어있는 loadUserByUsername 함수 실행
@Service
public class PrincipalDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	
	// Security Session(<= Authentication(<= UserDetails))
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userEntity = userRepo.findByEmail(username);
		if(userEntity != null) {
			return new PrincipalDetails(userEntity);
		}
		return null;
	}

}
