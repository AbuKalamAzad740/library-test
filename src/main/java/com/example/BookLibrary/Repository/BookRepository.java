package com.example.BookLibrary.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.BookLibrary.model.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, String>{}
