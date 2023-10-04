package com.bway.springMVCdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String getHome(HttpSession session) {
		if(session.getAttribute("validUser")==null) {
			return "Login";
		}
		return "Home";
	}

}
