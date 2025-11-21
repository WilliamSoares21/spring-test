package com.estudo.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.estudo.model.Usuario;
import com.estudo.repository.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
    private final UsuarioRepository usuarioRepository;

    public CustomUserDetailsService(UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // Busca o usuário no banco de dados
    Usuario usuario = usuarioRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));

    // Converte para UserDetails do Spring Security
    return User.builder()
        .username(usuario.getUsername())
        .password(usuario.getPassword())  // Senha já está em BCrypt
        .authorities("USER")  // Role/permissão do usuário
        .build();
  }
}
