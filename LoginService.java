package com.rutwik.springboot.web.demofirstwebapplication.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class LoginService {
	
	public boolean validateUser(String userId, String password) {
		return userId.equalsIgnoreCase("Rutwik") && password.equalsIgnoreCase("Konduru");
	}

}
