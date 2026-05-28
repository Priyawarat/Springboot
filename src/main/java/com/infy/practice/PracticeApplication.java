package com.infy.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Homework completed
@SpringBootApplication
public class PracticeApplication implements CommandLineRunner {

	private final Baker baker;

	@Autowired
	public PracticeApplication(Baker baker)
	{
		this.baker = baker;
	}

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		baker.bakeCake();
	}
}
