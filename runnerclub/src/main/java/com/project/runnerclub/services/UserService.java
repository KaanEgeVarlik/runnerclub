package com.project.runnerclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.runnerclub.entities.User;
import com.project.runnerclub.repo.UserRepo;

@Service
public class UserService {
	
	private UserRepo userRepo;
	
	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	public User saveOneUser(User newUser) {
		return userRepo.save(newUser);
	}
	
	public User getOneUserById(Long userId) {
		return userRepo.findById(userId).orElse(null);
	}
	
	public User updateOneUser(Long userId, User newUser) {
		Optional<User> user = userRepo.findById(userId);
		if(user.isPresent()) {
			User foundUser = user.get();
			foundUser.setUserName(newUser.getUserName());
			foundUser.setPassword(newUser.getPassword());
			userRepo.save(foundUser);
			return foundUser;
		} else {
			return null;
		}
		
	}

	public void deleteById(Long userId) {
		userRepo.deleteById(userId);
	}

	public User getOneUserByName(String userName) {
		
		return userRepo.findByUserName(userName);
	}

}
