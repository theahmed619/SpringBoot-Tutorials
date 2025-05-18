package com.example.yeshendrayt.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
	
	private Long id;
	private String username;
	private String email;
	private String password;
	
	
	private Set<String> roles;

}
