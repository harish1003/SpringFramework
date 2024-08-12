package com.learn.SpringBoot.scopes.prototype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Laptop {
	
	@Autowired
	HP hp;

	Laptop(){
		System.out.println("In Laptop prototype Constructor");
	}
}
