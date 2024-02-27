package com.dnapass.training.repository;

import com.dnapass.training.entity.Login;
import com.dnapass.training.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dnapass.training.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    @Query("select user from User user where user.id = ?1 and user.password = ?2 and user.role = ?3")
    public User checkLogin(int userid, String password, String role);
}
