package com.Moreira.SorteadorEmail.model.repositories;

import com.Moreira.SorteadorEmail.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User,Integer> {
    public Iterable<User> findByEmailContainingIgnoreCase(String partEmail);

}
