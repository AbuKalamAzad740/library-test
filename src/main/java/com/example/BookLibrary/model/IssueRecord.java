package com.example.BookLibrary.model;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "issuerecords")
public class IssueRecord {

    public String id;
    public String userId;
    public String bookId;
    public LocalDate issueDate;
    public LocalDate returnDate;
    
}
