package com.Moreira.SorteadorEmail.util;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sorteio {

    public Sorteio() {
    }

    public List<Integer> sortearNumeros(){
        int num;
        Random r = new Random();
        List<Integer> lista = new ArrayList<>();
        for(int i=0;i<7;i++){
            num=r.nextInt(99);
            if(!lista.contains(num)){
                lista.add(num);
            }else{i--;}
        }
        return lista;
    }
}
