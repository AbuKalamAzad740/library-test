package com.example.BookLibrary.service;

import java.util.List;

import com.example.BookLibrary.model.Book;
import com.example.BookLibrary.model.User;

public interface LibraryService {
    Book addBook(Book book);
    User addUser(User user);
    String issueBook(String bookId, String userId);
    String returnBook(String bookId);
    List<Book> getBook();
    
}
