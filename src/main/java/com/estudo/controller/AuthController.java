package com.estudo.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
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
  private final UsuarioService usuarioService;
  private final JwtUtil jwtUtil; 

  // Injetar JwtUtil no construtor
  public AuthController(UsuarioService usuarioService, JwtUtil jwtUtil) {
    this.usuarioService = usuarioService;
    this.jwtUtil = jwtUtil;
  }

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody Map<String, String> request) {
    Usuario usuario = usuarioService.registrarUsuario(
        request.get("username"), 
        request.get("password") 
    );
    return ResponseEntity.ok(usuario);
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
    Optional<Usuario> usuario = usuarioService.buscarPorUsername(request.get("username"));
    
    if (usuario.isPresent() && usuario.get().getPassword().equals(request.get("password"))) {
      // Usa a instância jwtUtil
      String token = jwtUtil.generateToken(usuario.get().getUsername());
      return ResponseEntity.ok(Map.of("token", token));
    }

    return ResponseEntity.status(401).body("Credenciais inválidas");
  }
}
