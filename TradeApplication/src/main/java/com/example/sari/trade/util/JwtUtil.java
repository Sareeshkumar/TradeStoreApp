package com.example.sari.trade.util;


import java.sql.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



@Component
public class JwtUtil {
	
	@Value("${app.secret}")
  private String secret;
	
	//3. Read Exp Date
	
	
	
  
	// 2.Read Claims
	
	  public Claims getClaims(String token) {
		  
	          return Jwts.parser()
	         .setSigningKey(secret.getBytes())
	         .build()
			 .parseClaimsJws(token)
			 .getBody();
						
	}
	
	
	
  //1.Generate Token
  public String generateToken(String subject) {
	  return Jwts.builder()
			  .setSubject(subject)
			  .setIssuer("AccentureSari")
			  .setIssuedAt(new Date(System.currentTimeMillis()))
			  .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(15)))
			  .signWith(SignatureAlgorithm.HS512, secret.getBytes())
			  .compact();
	  
	  //System.out.println(token);
			  
  }
  

}
