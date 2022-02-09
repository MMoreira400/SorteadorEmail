package com.Moreira.SorteadorEmail.model.entities;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "numeros_aposta")
public class Numeros_aposta {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    int numeros_id;

    Integer numerosApostados;

    @ManyToOne
    Aposta aposta;
    //METHODS



    //GET & SET


    public Integer getNumerosApostados() {
        return numerosApostados;
    }

    public void setNumerosApostados(Integer numerosApostados) {
        this.numerosApostados = numerosApostados;
    }

    public int getNumeros_id() {
        return numeros_id;
    }

    public void setNumeros_id(int numeros_id) {
        this.numeros_id = numeros_id;
    }

    public Aposta getAposta() {
        return aposta;
    }

    public void setAposta(Aposta aposta) {
        this.aposta = aposta;
    }
}
