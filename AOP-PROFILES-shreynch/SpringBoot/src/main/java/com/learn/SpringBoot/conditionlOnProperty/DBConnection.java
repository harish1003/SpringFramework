package com.learn.SpringBoot.conditionlOnProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBConnection {
	
	@Autowired(required = false)
	MySqlDBConnection mysqlConnection;
	
	@Autowired(required = false)
	NoSqlDBConnection nosqlConnection;
	
	public DBConnection() {
		
		System.out.println("DB connection");
	}

}
