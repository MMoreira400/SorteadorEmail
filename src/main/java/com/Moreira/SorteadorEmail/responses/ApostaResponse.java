package com.Moreira.SorteadorEmail.responses;

import com.Moreira.SorteadorEmail.model.entities.Aposta;

import java.util.List;

public class ApostaResponse {

    private Integer id;
    private List<Integer> numerosApostados;

    public ApostaResponse(Integer id, List<Integer> numerosApostados) {
        this.id = id;
        this.numerosApostados = numerosApostados;
    }

    public ApostaResponse(Aposta aposta) {
        this.id = aposta.getApostaId();
        this.numerosApostados = aposta.getNumeros();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Integer> getNumerosApostados() {
        return numerosApostados;
    }

    public void setNumerosApostados(List<Integer> numerosApostados) {
        this.numerosApostados = numerosApostados;
    }
}
