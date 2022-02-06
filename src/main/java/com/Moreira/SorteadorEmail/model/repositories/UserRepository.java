package com.Moreira.SorteadorEmail.model.repositories;

import com.Moreira.SorteadorEmail.model.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends PagingAndSortingRepository<User,Integer> {
    public Iterable<User> findByEmailContainingIgnoreCase(String partEmail);

}
