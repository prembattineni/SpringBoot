package com.vm.rest.demo.Students;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		//super.configure(auth);
		auth.inMemoryAuthentication().withUser("prem").password("kumar").roles("USER").and()
		                             .withUser("kedari").password("kedari").roles("USER").and()
		                             .withUser("vamsi").password("vamsi").roles("ADMIN");
		   
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
