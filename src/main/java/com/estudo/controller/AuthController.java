package com.estudo.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.model.Usuario;
import com.estudo.security.JwtUtil;
import com.estudo.service.UsuarioService;

@RestController
@RequestMapping("/auth")
public class AuthController {
  private final AuthenticationManager authenticationManager;
  private final UsuarioService usuarioService;
  private final JwtUtil jwtUtil;

  public AuthController(UsuarioService usuarioService, JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
    this.usuarioService = usuarioService;
    this.jwtUtil = jwtUtil;
    this.authenticationManager = authenticationManager;
  }

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody Map<String, String> request) {
    Usuario usuario = usuarioService.registrarUsuario(
        request.get("username"),
        request.get("password"));
    return ResponseEntity.ok(usuario);
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
    try {
      // Usa AuthenticationManager para validar (ele compara BCrypt automaticamente)
      Authentication authentication = authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
              request.get("username"),
              request.get("password")
          )
      );

      // Se chegou aqui, autenticação foi bem-sucedida
      String token = jwtUtil.generateToken(request.get("username"));
      return ResponseEntity.ok(Map.of("token", token));

    } catch (BadCredentialsException e) {
      return ResponseEntity.status(401).body("Credenciais inválidas");
    }
  }
}
