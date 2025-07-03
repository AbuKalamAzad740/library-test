package com.example.BookLibrary.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.BookLibrary.model.Book;
import com.example.BookLibrary.model.User;

public interface LibraryService {
    Book addBook(MultipartFile file, Book book) throws Exception;
    User addUser(User user);
    String issueBook(String bookId, String userId);
    String returnBook(String bookId);
    List<Book> getBook();
    
}
