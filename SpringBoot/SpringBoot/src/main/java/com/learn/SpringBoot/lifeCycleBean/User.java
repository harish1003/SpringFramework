package com.learn.SpringBoot.lifeCycleBean;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class User {
	
	private String name;
	
	private int id;
	
	User(){
		System.out.println("Dependecy initialised");
	}

}
