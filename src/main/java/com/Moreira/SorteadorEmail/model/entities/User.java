package com.Moreira.SorteadorEmail.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Random;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String email;
    String numeros;

    //Constructor
    public User() {
    }

    public User(int id, String email, String numeros) {
        this.id = id;
        this.email = email;
        this.numeros = numeros;
    }

    public User(String email) {
        this.email = email;
        this.numeros = this.sortearNumeros();
    }

    //METHODS

    public String getNumeros() {
        return numeros;
    }

    public void setNumeros(String numeros) {
        this.numeros = numeros;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String sortearNumeros() {
        Random r = new Random();
        for (int i = 0; i < 7; i++) {
            numeros+= (String.valueOf(r.nextInt(99))+",");
        }
        return numeros;
    }
}
