package com.Moreira.SorteadorEmail.model.repositories;

import com.Moreira.SorteadorEmail.model.entities.Aposta;
import com.Moreira.SorteadorEmail.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ApostaRepository extends PagingAndSortingRepository<Aposta,Integer> {
}
