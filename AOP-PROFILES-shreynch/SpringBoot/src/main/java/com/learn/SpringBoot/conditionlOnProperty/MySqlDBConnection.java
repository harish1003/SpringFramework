package com.learn.SpringBoot.conditionlOnProperty;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "mysql", value = "conn",havingValue = "true",matchIfMissing = true)
// check application.properties file => no entry exists, even thought it will invoke because matchIfMissing set to True
public class MySqlDBConnection {
	
	MySqlDBConnection(){
		System.out.println("MySqlDBConnection connection !!");
	}

}
