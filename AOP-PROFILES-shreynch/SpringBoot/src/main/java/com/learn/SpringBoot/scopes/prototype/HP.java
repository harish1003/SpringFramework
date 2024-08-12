package com.learn.SpringBoot.scopes.prototype;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class HP {

	HP(){
		System.out.println("In HP prototype Constructor");
	}
	
}
