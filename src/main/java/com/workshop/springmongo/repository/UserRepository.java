package com.workshop.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.workshop.springmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
