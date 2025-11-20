package com.estudo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.estudo.exceptions.RecursoNaoEncontradoException;
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

  public Produto buscarPorId(Long id) {
    return produtoRepository.findById(id)
        .orElseThrow(() -> new RecursoNaoEncontradoException("Produto com ID " + id + " não encontrado"));
  }

  public Produto salvarProduto(Produto produto) {
    return produtoRepository.save(produto);
  }

  public void deletarProduto(Long id) {
    if (!produtoRepository.existsById(id)) {
      throw new RecursoNaoEncontradoException("Produto com ID " + id + " não encontrado");
    }
    produtoRepository.deleteById(id);
  }
}
