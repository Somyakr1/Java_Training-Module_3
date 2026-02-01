package com.app.service;

import org.springframework.stereotype.Service;

import com.app.util.NameFormatter;

@Service
public class WelcomeService {
	
	private NameFormatter nameFormatter;
	
	public WelcomeService(NameFormatter formatter) {
		this.nameFormatter = formatter;
	}
	
	public String greet(String name) {
		String formattedName = nameFormatter.format(name);
        return "Welcome " + formattedName + " to Spring Boot!";
        
//		return "Welcome " + name + " to Spring Boot!";
	}

}
