package com.main;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.main.dao.UserRepo;
import com.main.entity.User;

@SpringBootApplication
public class Security1Application implements CommandLineRunner{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(Security1Application.class, args);
		System.out.println("HELLO");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("HII");
		
		
	User user1=	new User("admin", bCryptPasswordEncoder.encode("admin123"),"ROLE_ADMIN");
	User user2=	new User("member", bCryptPasswordEncoder.encode("member123"),"ROLE_MEMBER");
	List<User> userList=Arrays.asList(user1,user2);
		userRepo.saveAll(userList);
		
		
		
		
	}

}
