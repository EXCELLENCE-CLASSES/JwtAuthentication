package com.example.JwtAuthorization.JwtAuthorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class JwtAuthrizationWebSecurity extends WebSecurityConfigurerAdapter
{
	
	@Autowired
	UserDetailsService userDetailService;  
	
	
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	    {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailService);
		
		}
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable().authorizeRequests().antMatchers("/Authenticate").permitAll().anyRequest().authenticated();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() 
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	
	

}
