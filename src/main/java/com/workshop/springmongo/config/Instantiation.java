package com.workshop.springmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.workshop.springmongo.domain.User;
import com.workshop.springmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		//delete all preview registers
		userRepository.deleteAll();
		
		User joao = new User(null, "Joao", "joao@email.com");
		User maria = new User(null, "Maria", "maria@email.com");
		User karry = new User(null, "Karry", "karry@email.com");
		
		userRepository.insert(Arrays.asList(joao, maria, karry));
	}

}
