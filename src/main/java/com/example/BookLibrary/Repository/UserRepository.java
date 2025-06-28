package com.example.BookLibrary.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.BookLibrary.model.User;

public interface UserRepository extends MongoRepository<User, String>{
    
}
