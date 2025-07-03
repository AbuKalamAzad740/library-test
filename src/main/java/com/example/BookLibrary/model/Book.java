package com.example.BookLibrary.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "books")
public class Book {
    
    @Id
    private String id;
    private String title;
    private String author;
    private String publishby;
    private boolean issued;
    private String bannerImg; // S3 image URL
}
