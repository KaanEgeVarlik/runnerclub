package com.project.runnerclub.runnerclub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan(basePackages = { "com.project.runnerclub.entities" })
public class RunnerclubApplication {

	public static void main(String[] args) {
		SpringApplication.run(RunnerclubApplication.class, args);
	}

}
