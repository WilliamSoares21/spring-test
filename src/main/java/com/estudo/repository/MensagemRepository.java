package com.estudo.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MensagemRepository {
  public String obterMensagem() {
    return "Hello World do Repository!";
  }
}
