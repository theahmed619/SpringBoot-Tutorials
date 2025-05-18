package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;



@Repository
public interface UserRepo extends JpaRepository<User, String>{
	
	Optional<User> findByUsername(String username);

}
