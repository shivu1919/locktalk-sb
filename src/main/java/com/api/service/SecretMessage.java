package com.api.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class SecretMessage {
	
	public String generateMessage() {
		String str = "Java-Hyd_is%India&^Cricket**Football";
		Random r = new Random();
		
		String secret = "";
		
		for(int i=1; i<=11; i++) {
			int num = r.nextInt(30);
			secret = secret + str.charAt(num);
		}
		
		return secret;
	}
}
