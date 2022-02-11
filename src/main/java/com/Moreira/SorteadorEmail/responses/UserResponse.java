package com.Moreira.SorteadorEmail.responses;

import com.Moreira.SorteadorEmail.model.entities.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserResponse {

    private String email;
    private List<ApostaResponse> apostas;

    public UserResponse(String email, List<ApostaResponse> apostas) {
        this.email = email;
        this.apostas = apostas;
    }

    public UserResponse(User user) {
        this.email = user.getEmail();
        this.apostas = user.getApostas().stream().map(ApostaResponse::new).collect(Collectors.toList());
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ApostaResponse> getApostas() {
        return apostas;
    }

    public void setApostas(List<ApostaResponse> apostas) {
        this.apostas = apostas;
    }
}
