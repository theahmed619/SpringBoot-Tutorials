package com.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class SecurityConfig
{
	// URL Allow or not 
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http
		.authorizeHttpRequests()
		.antMatchers("/member").hasRole("MEMBER")
		.antMatchers("/admin").hasRole("ADMIN")
		.anyRequest().permitAll()
		.and()
		.exceptionHandling()
		.accessDeniedPage("error/403");
		
		return http.build();
		
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		
		// Database by default --> userdetailService
		return authConfig.getAuthenticationManager();
		
	}
		
		@Bean
		public BCryptPasswordEncoder bCryptPasswordEncoder() {
			
			return new BCryptPasswordEncoder();
		}
}
