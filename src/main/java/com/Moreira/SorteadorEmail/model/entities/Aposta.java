package com.Moreira.SorteadorEmail.model.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "aposta")
public class Aposta {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    int apostaId;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @JoinColumn(name = "aposta_numeros")
    @ElementCollection
    private List<Integer> numeros;

    public Aposta(int aposta_id, User user, List<Integer> numeros) {
        this.apostaId = aposta_id;
        this.user = user;
        this.numeros = numeros;
    }

    public Aposta() {
    }

    public Aposta(User user, List<Integer> numeros) {
        this.user = user;
        this.numeros = numeros;
    }

    public Aposta(List<Integer> numeros) {
        this.numeros = numeros;
    }

    public int getApostaId() {
        return apostaId;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getNumeros() {
        return numeros;
    }

    public void setNumeros(List<Integer> numeros) {
        this.numeros = numeros;
    }
}
