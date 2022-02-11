package com.Moreira.SorteadorEmail.model.repositories;

import com.Moreira.SorteadorEmail.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.JoinColumn;
import java.util.List;
import java.util.Set;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmailContainingIgnoreCase(String partEmail);
    Boolean existsByEmail(String email);
}
