package com.estudo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.estudo.model.Produto;
import com.estudo.repository.ProdutoRepository;

@Service
public class ProdutoService {

  private final ProdutoRepository produtoRepository;

  public ProdutoService(ProdutoRepository produtoRepository) {
    this.produtoRepository = produtoRepository;
  }

  public List<Produto> listarProdutos() {
    return produtoRepository.findAll();
  }
}
