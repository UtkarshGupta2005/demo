package com.example.demo;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class MyController {

    @Autowired
    private userRepo userRepo;

    @PostMapping
    public userModel createUser(@RequestBody userModel user) {
        userModel saved = userRepo.save(user);
        System.out.println("Saved user : "+saved);
        return saved;
    }

    @GetMapping("/{id}")
    public Optional<userModel> getUser(@PathVariable String id) {
        return userRepo.findById(id);
    }

    @PutMapping("/{id}")
    public userModel updateUser(@PathVariable String id, @RequestBody userModel userDetails) {
        userModel user=userRepo.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        return userRepo.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userRepo.deleteById(id);
    }
}