package com.Moreira.SorteadorEmail.model.entities;


import javax.persistence.*;

@Entity
public class numerosApostados {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numeros_id")
    int numeros_id;

    Integer numeros;

    @ManyToOne
    @JoinColumn(name = "aposta_id")
    Aposta aposta;

    public numerosApostados(int numeros_id, Integer numeros) {
        this.numeros_id = numeros_id;
        this.numeros = numeros;
    }

    public numerosApostados() {
    }

    public int getNumeros_id() {
        return numeros_id;
    }

    public Integer getNumeros() {
        return numeros;
    }

    public void setNumeros(Integer numeros) {
        this.numeros = numeros;
    }
}
