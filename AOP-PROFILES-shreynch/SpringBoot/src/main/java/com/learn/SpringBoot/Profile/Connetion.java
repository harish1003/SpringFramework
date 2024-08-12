package com.learn.SpringBoot.Profile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("QA")
public class Connetion {
	
	@Value("${username}")
	public String userName;
	
	@Value("${password}")
	public String password;

	public Connetion() {
		
		System.out.println("QA config loaded : userName : "+userName+" password : "+password);
		
	}
	
}
