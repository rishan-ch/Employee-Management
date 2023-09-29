package com.bway.springMVCdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bway.springMVCdemo.utils.MailUtil;

@Controller
public class ContactController {
	
	@Autowired
	private MailUtil mailUtil;
	
	@GetMapping("/contact")
	public String getContact() {
		return "ContactForm";
	}
	
	@PostMapping("/contact")		
	public String postContact(@RequestParam String toEmail, @RequestParam String subject, @RequestParam String message) {
		
		mailUtil.sendEmail(toEmail,subject,message);
		
		return "ContactForm";
	}

}
