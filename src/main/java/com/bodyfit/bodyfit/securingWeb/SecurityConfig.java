package com.bodyfit.bodyfit.securingWeb;

import javax.servlet.http.HttpSessionListener;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.bodyfit.bodyfit.configuration.SessionListener;

@Configuration
@EnableWebSecurity //스프링 시큐리티 필터가 스프링 필터 체인에 등록된다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http
			.authorizeRequests()
				.antMatchers("/", "/inbody/**","/diet/**","/member/**", "/board/**","/account/**","/css/**", "/js/**", "/img/**").permitAll()
				.antMatchers().hasAuthority("ROLE_USER")
//				.antMatchers("/**/*Write", "/**/*Update").access("hasRole('ROLE_USER')")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/account/loginForm") 
				.permitAll()
				.and()
				.logout()
				.permitAll();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// 세션
	@Bean
	  public HttpSessionListener httpSessionListener(){

	    return new SessionListener();

	 }

	
}
