package com.learn.SpringBoot.scopes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Vehicle {
	
	@Autowired
	Car car;

	Vehicle(){
		System.out.println("In Constructor Vehicle");
	}
	
}
