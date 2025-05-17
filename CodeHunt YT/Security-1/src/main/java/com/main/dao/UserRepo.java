package com.main.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, String>{
	
	Optional<User> findByUsername(String username);

}
