package com.learn.SpringBoot.Profile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Profile("prod")
public class Connection2 {
	
	@Value("${username}")
	public String userName;
	
	@Value("${password}")
	public String password;

	public Connection2() {
		
		System.out.println("prod config loaded : userName : "+userName+" password : "+password);
		
	}
	
	  @PostConstruct public void init() {
	  System.out.println("prod config loaded : userName : "+userName+" password : "
	  +password); }
	

}
