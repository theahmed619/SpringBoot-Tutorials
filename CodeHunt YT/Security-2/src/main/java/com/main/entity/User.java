package com.main.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class User {
	
	@Id
	public String username;
	public String password;
	public String role;
	
	



	public User() {
		super();
		// TODO Auto-generated constructor stub
	}





	public User(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}





	public String getUsername() {
		return username;
	}





	public void setUsername(String username) {
		this.username = username;
	}





	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}





	public String getRole() {
		return role;
	}





	public void setRole(String role) {
		this.role = role;
	}
	
	

}
