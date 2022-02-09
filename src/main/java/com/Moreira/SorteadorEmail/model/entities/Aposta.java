package com.Moreira.SorteadorEmail.model.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "aposta")
public class Aposta {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    int aposta_id;

    @OneToMany(mappedBy = "numeros_id")
    List<Numeros_aposta> numerosApostados;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    public Aposta() {
    }

    public List<Numeros_aposta> getNumerosApostados() {
        return numerosApostados;
    }

    public void setNumerosApostados(List<Numeros_aposta> numerosApostados) {
        this.numerosApostados = numerosApostados;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
