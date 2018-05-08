package com.workshop.springmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.workshop.springmongo.domain.Post;
import com.workshop.springmongo.domain.User;
import com.workshop.springmongo.repository.PostRepository;
import com.workshop.springmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		//delete all preview registers
		userRepository.deleteAll();
		
		User joao = new User(null, "Joao", "joao@email.com");
		User maria = new User(null, "Maria", "maria@email.com");
		User karry = new User(null, "Karry", "karry@email.com");
		
		Post post1 = new Post(null, sdf.parse("2018-01-31"), "Título ;)", "Texto corpo do post", true, joao);
		Post post2 = new Post(null, sdf.parse("2018-03-15"), "Nice Title :D", "Another happy post body", true, karry);
		
		userRepository.insert(Arrays.asList(joao, maria, karry));
		postRepository.insert(Arrays.asList(post1, post2));
	}

}
