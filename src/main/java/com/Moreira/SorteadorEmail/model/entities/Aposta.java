package com.Moreira.SorteadorEmail.model.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "aposta")
public class Aposta {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    int aposta_id;

    @ManyToOne
    @JoinColumn(name = "user_id")@Transient
    User user;
    @ElementCollection
    List<Integer> numeros;

    public Aposta() {
    }

    public Aposta(User user, List<Integer> numeros) {
        this.user = user;
        this.numeros = numeros;
    }


    public int getAposta_id() {
        return aposta_id;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
