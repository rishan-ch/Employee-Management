package com.bway.springMVCdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bway.springMVCdemo.model.User;
import com.bway.springMVCdemo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;

@Log
@Controller
public class UserController {
	
	//creating object for logger
	//private static final Logger logger = LoggerFactory.getLogger(UserController.class) ;
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/login")
	public String getlogin() {
		return "Login";
	}
	
	@PostMapping("/login")
	public String postLogin(@ModelAttribute User user, Model model, HttpSession session) {
		
		User usr = userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		
		
		session.setAttribute("validUser", usr);
		session.setMaxInactiveInterval(200);//logout after inactivity
		
		
		if(usr!=null) {
			log.info("--------------Login success------------");
			return "Home";
		}
		
		log.info("--------------Login failed------------");
		model.addAttribute("error","user not found");
		return "Login";
	}
	
	@GetMapping("/signup")
	public String getSignup() {
		return "SignUp";
	}
	
	@PostMapping("/signup")
	public String postSignup(User user) {
		
		userRepo.save(user);
		
		return "Login";
	}
	
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		//unbinds any object related to this session after invalidate
		session.invalidate();
		log.info("--------------User logout------------");
		return "Login";
	}
	
	@GetMapping("/profile")
	public String profile() {
		return "Profile";
	}

}
