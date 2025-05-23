package com.example.demo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface userRepo extends MongoRepository<userModel,String> {
    
}
