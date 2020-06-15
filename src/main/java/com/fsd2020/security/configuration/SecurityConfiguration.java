package com.fsd2020.security.configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter  {
	
		@Override
	    protected void configure(HttpSecurity http) throws Exception {

	        http
	            .authorizeRequests()
	            .antMatchers("/querytoken", "/addtoken").permitAll()
	            .anyRequest().authenticated()
	            .and()
	            .formLogin()
	            .loginPage("/login")
	            .permitAll()
	            .and()
	            .logout()
	            .permitAll();
	    }
}
