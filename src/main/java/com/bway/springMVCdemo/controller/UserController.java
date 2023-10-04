package com.bway.springMVCdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bway.springMVCdemo.model.User;
import com.bway.springMVCdemo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
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
			return "Home";
		}
		
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

}
