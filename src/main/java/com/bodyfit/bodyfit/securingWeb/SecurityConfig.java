package com.bodyfit.bodyfit.securingWeb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity //스프링 시큐리티 필터가 스프링 필터 체인에 등록된다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http
			.authorizeRequests()
				.antMatchers("/", "/account/**","/css/**", "/js/**", "/img/**").permitAll()
				.antMatchers("/member/**").access("hasRole('ROLE_USER')")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/account/loginForm") 
				.loginProcessingUrl("/account/login") //login주소가 호출이 되면 시큐리티가 낚아채서 대신 로그인 진행
				.defaultSuccessUrl("/")
				.permitAll()
				.and()
			.logout()
				.permitAll();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncode() {
		return new BCryptPasswordEncoder();
	}

	
}
