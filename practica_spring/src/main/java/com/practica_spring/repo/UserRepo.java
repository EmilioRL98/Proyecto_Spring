package com.practica_spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practica_spring.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

}
