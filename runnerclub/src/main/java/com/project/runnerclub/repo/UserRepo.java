package com.project.runnerclub.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.runnerclub.entities.User;

public interface UserRepo extends JpaRepository<User, Long> {

	User findByUserName(String userName);

}
