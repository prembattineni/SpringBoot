package com.vm.rest.demo.Students;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
//  @Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		
//		//super.configure(auth);
//		auth.jdbcAuthentication()            
//		.dataSource(dataSource)
//		.withDefaultSchema()              //this is default schema we no need to create tables
//		.withUser(
//				User.withUsername("user").password("userpwd").roles("USER")
//				)
//		.withUser(
//				User.withUsername("admin").password("adminpwd").roles("ADMIN")
//				);
//	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		
		auth.jdbcAuthentication()
		.dataSource(dataSource);
	}
	
	@Bean
   public	PasswordEncoder getPasswordEncoder()
   {
	   return NoOpPasswordEncoder.getInstance();
   }
	
	@Override
	public void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
        .antMatchers("/admin").hasRole("ADMIN")
        .antMatchers("/user").hasAnyRole("USER","ADMIN")   //admin is able to access user using admin credentials also
        .antMatchers("/").permitAll()
		.and()
		.formLogin();
	
	}
}
