package com.java.appconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages="com.java")
@EnableWebMvc
public class SpringJdbcConfig
{

	public static void main(String[] args) 
	
	{
		System.out.println("Hello spring boot ");
		SpringApplication.run(SpringJdbcConfig.class, args);

	}

}
