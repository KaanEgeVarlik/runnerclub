package com.project.runnerclub.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.runnerclub.entities.User;
import com.project.runnerclub.repo.UserRepo;
import com.project.runnerclub.security.JwtUserDetails;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

	private UserRepo userRepo;
	
	public UserDetailsServiceImp(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUserName(username);
		return JwtUserDetails.create(user);
	}
	public UserDetails loadUserById(Long id) {
		User user = userRepo.findById(id).get();
		return JwtUserDetails.create(user);
	}

}
