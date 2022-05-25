package com.api.api.services;

import java.util.List;
import java.util.Optional;

import com.api.api.model.Produto;
import com.api.api.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

     /**
     * Metodo para retorna uma lista de produtos
     * @return Lista de produtos
     */
    public List<Produto> obterTodos() {
        return produtoRepository.obterTodos();
    }

     /**
     * Método que retorna o produto encontrado pelo seu Id
     * @param id do produto que será localizado
     * @return Retorna um produto caso seja encontrado.
     */
    public Optional<Produto> obterPorId(Integer id){
        return produtoRepository.obterPorId(id);
    }

    /**
     * Método para adicionar um produto na lista
     * @param produto que será adicionado
     * @return Retorna o produto que foi adicionado na lista
     */
    public Produto adicionar(Produto produto){
        return produtoRepository.adicionar(produto);
    }

    /**
     * Método para deletar o produto por id
     * @param id do produto que será deletado
     */
    public void deletar(Integer id) {
        produtoRepository.deletar(id);
    }

    /**
     * Método para atualizar o produto na lista.
     * @param produto que será atualizado.
     * @param id do produto que será atualizado.
     * @return Retorna o produto após a atualização.
     */
    public Produto atualizar(Integer id, Produto produto) {

        produto.setId(id);

        return produtoRepository.atualizar(produto);
    }
}
