package com.example.BookLibrary.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.BookLibrary.model.IssueRecord;

public interface IssueRecordsRepository extends MongoRepository<IssueRecord, String> {
    
}
