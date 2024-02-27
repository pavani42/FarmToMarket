package com.dnapass.training.service;

import com.dnapass.training.entity.Login;
import com.dnapass.training.entity.User;
import com.dnapass.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService{

	@Autowired
	UserRepository userRepo;
	//To add new user
	public User saveUser(User user) {
		return userRepo.save(user);
	}

	//To find user based on user id 
	public User findUser(Integer userId) {

		return userRepo.findById(userId).get();
	}

	public User checkLogin(Login login) {
		return userRepo.checkLogin(login.getUserid(), login.getPassword(), login.getRole());
	}
}
