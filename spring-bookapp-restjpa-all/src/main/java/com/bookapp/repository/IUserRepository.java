package com.bookapp.repository;

import com.bookapp.model.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface IUserRepository extends JpaRepository<ApiUser,Integer> {
    Optional<ApiUser> findByUsername(String username);

}
