package com.estudo.estudo.service;

import org.springframework.stereotype.Service;

import com.estudo.estudo.repository.MensagemRepository;

@Service
public class MensagemService {
  private final MensagemRepository mensagemService;

  public MensagemService(MensagemRepository mensagemService) {
    this.mensagemService = mensagemService;
  }

  public String obterMensagem() {
    return mensagemService.obterMensagem();
  }
}
