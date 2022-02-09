package com.Moreira.SorteadorEmail;

import com.Moreira.SorteadorEmail.model.entities.User;
import com.Moreira.SorteadorEmail.model.entities.numerosApostados;

import java.util.List;
import java.util.Random;

public class sorteadorNumeros {

    numerosApostados numeros;
    int num;
    User user;
    Random r = new Random();

    public List<numeros> sortearNumeros(){
        List<numerosApostados> lista = null;
        for(int i=0;i<7;i++){
           num=r.nextInt();
           if(!lista.contains(num)){
               lista.add(num);
           }else{i--;}
        }

    }
}
