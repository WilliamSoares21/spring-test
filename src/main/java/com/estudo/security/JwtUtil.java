package com.estudo.security;

import java.util.Date;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

@Component
public class JwtUtil {
  private static final SecretKey SECRET_KEY = Jwts.SIG.HS256.key().build();
  private static final long EXPIRATION_TIME = 3600000; // 1 hora

  public String generateToken(String username) {
    return Jwts.builder()
        .subject(username)
        .issuedAt(new Date())
        .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
        .signWith(SECRET_KEY)
        .compact();
  }

  public String extractUsername(String token) {
    return Jwts.parser()
        .verifyWith(SECRET_KEY)
        .build()
        .parseSignedClaims(token)
        .getPayload()
        .getSubject();
  }

  public boolean validateToken(String token) {
    try {
      Jwts.parser()
          .verifyWith(SECRET_KEY)
          .build()
          .parseSignedClaims(token);
      return true;
    } catch (JwtException e) {
      return false;
    }
  }
}
