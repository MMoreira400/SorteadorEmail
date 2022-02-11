package com.Moreira.SorteadorEmail.controllers;

import com.Moreira.SorteadorEmail.responses.ApostaResponse;
import com.Moreira.SorteadorEmail.responses.UserResponse;
import com.Moreira.SorteadorEmail.util.Sorteio;
import com.Moreira.SorteadorEmail.model.entities.Aposta;
import com.Moreira.SorteadorEmail.model.entities.User;
import com.Moreira.SorteadorEmail.model.repositories.ApostaRepository;
import com.Moreira.SorteadorEmail.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping(path = "/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ApostaRepository apostaRepository;

    @PostMapping("/sortear/{email}")
    public ApostaResponse gerarAposta (@PathVariable String email){

        Sorteio sorteio = new Sorteio(); //Objeto para sortear
        User user;
        Aposta aposta = new Aposta(sorteio.sortearNumeros());
        //Verificar se existe o Email Cadastrado

        if(userRepository.existsByEmail(email)){
            user = userRepository.findByEmailContainingIgnoreCase(email);
        }else{
            user = new User(email);
        }

        aposta.setUser(user);

        apostaRepository.save(aposta);
        return new ApostaResponse(aposta);
    }

    @GetMapping("/buscar/{email}")
    public UserResponse findByEmail(@PathVariable String email){
        return new UserResponse(userRepository.findByEmailContainingIgnoreCase(email));
    }

    @GetMapping("/buscar/aposta/{id}")
    public Aposta findByIdAposta(@PathVariable Integer id){
        return apostaRepository.findById(id).orElse(null);
    }
}
