package com.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.entity.Message;
import com.api.repo.MessageRepo;
import com.api.service.SecretMessage;

@RestController
@CrossOrigin(origins="https://locktalk.netlify.app/")	
public class MessageController {
	
	@Autowired
	private MessageRepo mr;
	
	@Autowired
	private SecretMessage sm;
	
	@PostMapping("/encryptMsg")
	public String encryptMsg(String msg, String password) {
		
		Message m = new Message();
		
		if(msg==null || password == null) {
			return "Either message or password is empty";
					
		}
		
		else {
			m.setMsg(msg);
			String secret = sm.generateMessage();
			m.setPassword(password);
			m.setSecretmsg(secret);
			mr.save(m);
			return secret;
		}
		
		
	}

	@PostMapping("/decryptMsg")
	public String decryptMsg( String secret, String password) {
		

		System.out.println(secret + " "+password);		
		List<Message> list = mr.findBySecretmsgAndPassword(secret,password);
	
		if(list.size()==1) {
			return list.get(0).getMsg();
		}
		
		else {
			return "No message available";
		}
	}
}










