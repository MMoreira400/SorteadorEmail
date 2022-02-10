package com.Moreira.SorteadorEmail.controllers;

import com.Moreira.SorteadorEmail.DTO.ObjetoGet;
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
public class UserControll {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ApostaRepository apostaRepository;

    @PostMapping("/sortear/{email}")
    public Aposta gerarAposta (@PathVariable String email){

        Sorteio sorteio = new Sorteio(); //Objeto para sortear
        User user;
        Aposta aposta = new Aposta(sorteio.sortearNumeros()); //Cria a aposta para cadastrar na lista
        List<Aposta> apostas = new ArrayList<>();

        //Verificar se existe o Email Cadastrado

        if(userRepository.existsByEmail(email)){
            user = userRepository.findByEmailContainingIgnoreCase(email).iterator().next();
            apostas= user.getApostas();
            apostas.add(aposta);
        }else{
            user = new User(email,apostas);
        }
        apostaRepository.save(aposta);
        userRepository.save(user);
        return aposta;
    }
    @GetMapping("/buscar/{email}")
    public Set findByEmail(@PathVariable String email){
        return userRepository.serchByEmail(email);
    }

    @GetMapping("/buscar/aposta/{id}")
    public List<Integer> findByIdAposta(@PathVariable Integer id){
        return apostaRepository.searchById(id);
    }
}
