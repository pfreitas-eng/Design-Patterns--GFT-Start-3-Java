package com.pfreitas.loja.service;

import java.util.Optional;

import com.pfreitas.loja.model.Produto;
import com.pfreitas.loja.model.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService{

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public Iterable<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto buscarPorId(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
		return produto.get();
    }

    @Override
    public void inserir(Produto produto) {
        salvarProduto(produto);
    }

    @Override
    public void atualizar(Long id, Produto produto) {
        Optional<Produto> produtoBd = produtoRepository.findById(id);
		if (produtoBd.isPresent()) {
			salvarProduto(produto);
		}
    }

    @Override
    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }

    private void salvarProduto(Produto produto) {
        produtoRepository.save(produto);
    }
    
}
