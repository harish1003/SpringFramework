package com.learn.SpringBoot.scopes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Car {
	
	Car(){
		System.out.println("In Car Constructor");
	}

}
