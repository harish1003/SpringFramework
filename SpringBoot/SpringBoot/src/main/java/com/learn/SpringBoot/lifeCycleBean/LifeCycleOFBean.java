package com.learn.SpringBoot.lifeCycleBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class LifeCycleOFBean {
	
	

	@Autowired
    protected User user; // if this comments, this User object will not get initialized eagerly 
	
	@PostConstruct
	void postConstruct() {
		System.out.println("@PostConstruct  Bean");
	}
	
	@PreDestroy
	void preDestroy() {
		System.out.println("@PreDestroy  Bean");
	}
	
	LifeCycleOFBean(){
		System.out.println("Initialising Bean");
	}
}
