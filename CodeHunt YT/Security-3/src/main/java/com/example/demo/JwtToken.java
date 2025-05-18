package com.example.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtToken {

	@Value("${jwt.token.validity}")
	private long JWT_VALIDITY;

	@Value("${jwt.secret}")
	private String SECRET_KEY;

	public String generateMyToken(UserDetails userDetails) {

		List<String> role = new ArrayList<>();

		for (GrantedAuthority grantedAuthority : userDetails.getAuthorities()) {
			role.add(grantedAuthority.getAuthority());

		}

		Map<String, Object> claims = new HashMap<>();
		claims.put("roles", role);

		String token = Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_VALIDITY * 1000))
				.signWith(getKey(),SignatureAlgorithm.HS256)
				.compact();

		return token;

	}

	private SecretKey getKey() {

		byte[] bytes = SECRET_KEY.getBytes();
		SecretKey key = Keys.hmacShaKeyFor(bytes);
		return key;

	}
}
