package com.example.demo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")

public class userModel {
    @Id
    private String id;
    private String name;
    private String email;

    public userModel() {
    }
    
    public userModel(String id, String name, String email) {
        this.id=id;
        this.name=name;
        this.email=email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id=id;
    }

    public void setName(String name) {
        this.name=name;
    }

    public void setEmail(String email) {
        this.email=email;
    }
}