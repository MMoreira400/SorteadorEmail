package com.Moreira.SorteadorEmail.model.repositories;

import com.Moreira.SorteadorEmail.model.entities.Aposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.JoinColumn;
import java.util.List;

public interface ApostaRepository extends JpaRepository<Aposta,Integer> {
    @JoinColumn(name = "aposta_numeros")
    @Query (value = "SELECT numeros from aposta_numeros where aposta_aposta_id=:id ", nativeQuery = true)
    List<Integer> searchById(@Param("id") Integer id);
}
