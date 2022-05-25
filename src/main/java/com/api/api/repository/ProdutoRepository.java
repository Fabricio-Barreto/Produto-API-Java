package com.api.api.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import com.api.api.model.Produto;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoRepository {
    
    private List<Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoId = 0;

    /**
     * Metodo para retorna uma lista de produtos
     * @return Lista de produtos
     */
    public List<Produto> obterTodos(){
        return produtos;
    }

    /**
     * Método que retorna o produto encontrado pelo seu Id
     * @param id do produto que será localizado
     * @return Retorna um produto caso seja encontrado.
     */
    public Optional<Produto> obterPorId(Integer id){
        return produtos.stream().filter(produto -> produto.getId() == id).findFirst();
    }

    /**
     * Método para adicionar um produto na lista
     * @param produto que será adicionado
     * @return Retorna o produto que foi adicionado na lista
     */
    public Produto adicionar(Produto produto){

        ultimoId++;

        produto.setId(ultimoId);
        produtos.add(produto);

        return produto;
    }

    /**
     * Método para deletar o produto por id
     * @param id do produto que será deletado
     */
    public void deletar(Integer id) {
        produtos.removeIf(produto -> produto.getId() == id);
    }

    /**
     * Método para atualizar o produto na lista.
     * @param produto que será atualizado.
     * @return Retorna o produto após a atualização.
     */
    public Produto atualizar(Produto produto) {
        
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());

        if(produtoEncontrado.isEmpty()){
            throw new InputMismatchException("Produto não encontrado");
        }

        deletar(produto.getId());

        produtos.add(produto);

        return produto;
    }
}
