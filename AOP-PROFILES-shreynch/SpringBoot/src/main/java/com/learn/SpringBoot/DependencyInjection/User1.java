package com.learn.SpringBoot.DependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class User1 {
	
	/*
	 * 3 type of dependency injection
	 * constructorInjection is the highly usefull -> we can make final objects, injected at initialization, unit testing much easy
	 *  fieldInjection & setterInjection -> not able to use the final
	 *
	 *
	 * when two beans are qualified for autowired, take ex: 1 interface implemented by 2 classes
	 * 1. @Primary 
	 * 2. @Qualifier("somename")
	 */
	@Autowired
	@Qualifier("online")
    Order fieldInjection;  
	
	final Order constructorInjection;

	Order setterInjection;

	@Autowired
	User1(Order order) {
		this.constructorInjection = order;
	}
	
	@Autowired
	void setterInjection(Order order) {
		this.setterInjection = setterInjection;
	}

}
