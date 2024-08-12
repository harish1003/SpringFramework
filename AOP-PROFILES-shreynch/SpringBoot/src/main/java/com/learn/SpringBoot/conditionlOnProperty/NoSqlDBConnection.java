package com.learn.SpringBoot.conditionlOnProperty;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
@Component
@ConditionalOnProperty(prefix = "nosql", value = "conn",havingValue = "true",matchIfMissing = false)

//check application.properties file nosql.conn= true
public class NoSqlDBConnection {

	NoSqlDBConnection(){
		System.out.println("NoSqlDBConnection connection !!");
	}

}
