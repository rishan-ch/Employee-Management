package com.bway.springMVCdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.springMVCdemo.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByUsernameAndPassword(String username, String password); 

}
