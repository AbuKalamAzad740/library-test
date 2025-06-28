package com.example.BookLibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookLibrary.model.Book;
import com.example.BookLibrary.model.User;
import com.example.BookLibrary.service.LibraryService;

@RestController
@RequestMapping("/library/api")
public class maincontroller {

    @Autowired
    private LibraryService libraryService;

   @GetMapping("/get/books")
    public ResponseEntity<?> getBook(){
        return ResponseEntity.ok(libraryService.getBook());
    }


    @PostMapping("/add")
    public ResponseEntity<?> addBook(@RequestBody Book book){
        return ResponseEntity.ok(libraryService.addBook(book));
    }

    @PostMapping("/users")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        return ResponseEntity.ok(libraryService.addUser(user));
    }

    @PostMapping("/issue")
    public ResponseEntity<?> issueBook(@RequestParam String bookId, @RequestParam String userId) {
        return ResponseEntity.ok(libraryService.issueBook(bookId, userId));
    }

    @PostMapping("/return")
    public ResponseEntity<?> returnBook(@RequestParam String bookId) {
        return ResponseEntity.ok(libraryService.returnBook(bookId));
    }
    
}
