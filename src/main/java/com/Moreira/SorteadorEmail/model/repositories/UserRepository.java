package com.Moreira.SorteadorEmail.model.repositories;

import com.Moreira.SorteadorEmail.DTO.ObjetoGet;
import com.Moreira.SorteadorEmail.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.JoinColumn;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserRepository extends JpaRepository<User,Integer> {
    public Iterable<User> findByEmailContainingIgnoreCase(String partEmail);
    boolean existsByEmail(String email);
    @JoinColumn(name = "aposta_numeros")
    @JoinColumn(name = "user_apostas")
    @Query(value = "select u.email,ap.apostas_aposta_id,an.numeros from aposta_numeros an join user u join user_apostas ap on an.aposta_aposta_id=ap.apostas_aposta_id where u.email= :email", nativeQuery = true)
    Set serchByEmail(@Param("email") String email);
}
