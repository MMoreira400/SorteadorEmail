package com.Moreira.SorteadorEmail.controllers;

import com.Moreira.SorteadorEmail.model.entities.User;
import com.Moreira.SorteadorEmail.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api")
public class UserControll {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/sortear/{email}")
    public User sortearnumeros(@PathVariable String email){
        User user = new User(email);
        userRepository.save(user);
        return user;
    }

    @GetMapping("/buscar/{email}")
    public Iterable<User> procurarporEmail(@PathVariable String email){
        return userRepository.findByEmailContainingIgnoreCase(email);
    }
}
