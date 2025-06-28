package com.example.BookLibrary.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookLibrary.Repository.BookRepository;
import com.example.BookLibrary.Repository.IssueRecordsRepository;
import com.example.BookLibrary.Repository.UserRepository;
import com.example.BookLibrary.model.Book;
import com.example.BookLibrary.model.IssueRecord;
import com.example.BookLibrary.model.User;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private IssueRecordsRepository issueRecordRepository;

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public String issueBook(String bookId, String userId) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        if(book.isIssued())
        return "Book is already issued";

        User user = userRepository.findById(userId).orElseThrow();

        if(user == null)
        return "User not exists";

        IssueRecord issueRecord = new IssueRecord();
        issueRecord.setUserId(user.getId());
        issueRecord.setBookId(book.getId());
        issueRecord.setIssueDate(LocalDate.now());

        issueRecordRepository.save(issueRecord);

        book.setIssued(true);

        bookRepository.save(book);
        return "Book Issued Successfully";
    }

    @Override
    public String returnBook(String bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        if(!book.isIssued())
        return "Book is already issued";
        book.setIssued(false);
        bookRepository.save(book);
        return "Book Returned Successfully";
    }

    @Override
    public List<Book> getBook() {
        return bookRepository.findAll();
    }

}
