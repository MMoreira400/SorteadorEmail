package com.Moreira.SorteadorEmail.controllers;

import com.Moreira.SorteadorEmail.util.Sorteio;
import com.Moreira.SorteadorEmail.model.entities.Aposta;
import com.Moreira.SorteadorEmail.model.entities.User;
import com.Moreira.SorteadorEmail.model.repositories.ApostaRepository;
import com.Moreira.SorteadorEmail.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api")
public class UserControll {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ApostaRepository apostaRepository;

    @PostMapping("/sortear/{email}")
    public Aposta gerarAposta (@PathVariable String email){
        User user= new User(email);
        Sorteio sorteio = new Sorteio();
        Aposta aposta = new Aposta(user,sorteio.sortearNumeros());
        apostaRepository.save(aposta);
        userRepository.save(user);
        return aposta;
    }

  /*  @GetMapping("/buscar/{email}")
    public Aposta findByEmail(@PathVariable String email){
    return userRepository.findByEmailContainingIgnoreCase(email);
    }*/
}
