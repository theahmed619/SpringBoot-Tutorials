package com.main.security;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Date;
import java.util.List;

@Component
public class JwtUtil  {

    private static String secretKey;
    JwtUtil(){
        SecureRandom random =new SecureRandom();

    }

    public  String generateToken(String username, List<String> roles){

        return Jwts.builder().setSubject(username)
                .claim("roles",roles)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() +100*60+2))
                .signWith();
    }

}
