package com.bookapp.repository;

import com.bookapp.model.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface IUserRepository extends JpaRepository<ApiUser,Integer> {
    @Query(value="select au.username,au.password,au.user_id,r.roles from api_user au inner join apiuser_roles r on au.user_id=r.api_user_user_id where au.username=?1",
      nativeQuery = true)
    Optional<ApiUser> findByUsername(String username);

}
