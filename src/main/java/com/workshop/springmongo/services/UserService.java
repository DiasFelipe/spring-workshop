package com.workshop.springmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.springmongo.domain.User;
import com.workshop.springmongo.dto.UserDTO;
import com.workshop.springmongo.repository.UserRepository;
import com.workshop.springmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		if(id.isEmpty())
			throw new IllegalArgumentException("Id argument connit be empty");
		Optional<User> user  = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("User not found by id"));
	}
	
	public User insert(User user) {
		return repo.insert(user);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User user) {
		User newUser = findById(user.getId());
		updateData(newUser, user);
		return repo.save(newUser);
	}
	
	private void updateData(User newUser, User user) {
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
	}

	public User fromDTO(UserDTO user) {
		return new User(user.getId(), user.getName(), user.getEmail());
	}
}
