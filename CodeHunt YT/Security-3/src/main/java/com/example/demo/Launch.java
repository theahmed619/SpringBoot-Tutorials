package com.example.demo;

import java.util.Base64;

import javax.crypto.SecretKey;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class Launch { 
	
	public static void main(String[] args) {
		
		SecretKey key=Keys.secretKeyFor(SignatureAlgorithm.HS512);
		String encodeToString=Base64.getEncoder().encodeToString(key.getEncoded());
		System.out.println(encodeToString);
		
	}

}
