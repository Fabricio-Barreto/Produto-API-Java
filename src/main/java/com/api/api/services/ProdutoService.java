package com.api.api.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.api.api.model.Produto;
import com.api.api.model.exception.ResourceNotFoundException;
import com.api.api.repository.ProdutoRepository;
import com.api.api.shared.ProdutoDTO;

import org.modelmapper.ModelMapper;
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
    public List<ProdutoDTO> obterTodos() {

        List<Produto> produtos = produtoRepository.findAll();

        // Transformar um objeto tipo produto em um objeto tipo produtoDTO.
        return produtos.stream().map(produto -> new ModelMapper()
        .map(produto, ProdutoDTO.class))
        .collect(Collectors.toList());

    }

     /**
     * Método que retorna o produto encontrado pelo seu Id
     * @param id do produto que será localizado
     * @return Retorna um produto caso seja encontrado.
     */
    public Optional<ProdutoDTO> obterPorId(Integer id){
        //Obtendo produto optional pelo id
        Optional<Produto> produto = produtoRepository.findById(id);

        // se não encontrar lançar uma exception
        if(produto.isEmpty()){
            throw new ResourceNotFoundException("Produto com id:" + id + " não encontrado.");
        }

        // Convertendo o meu optional de produto em um produtoDTO.
        ProdutoDTO produtodto = new ModelMapper().map(produto.get(), ProdutoDTO.class);

        // Criando e retornando um optional de produtoDTO.
        return Optional.of(produtodto);
    }

    /**
     * Método para adicionar um produto na lista
     * @param produto que será adicionado
     * @return Retorna o produto que foi adicionado na lista
     */
    public ProdutoDTO adicionar(ProdutoDTO produtoDto){
        // Removendo o id para conesguir fazer o cadastro
        produtoDto.setId(null);

        // Criar um objeto de mapeamento.
        ModelMapper mapper = new ModelMapper();

        // Converter um ProdutoDto em um Produto.
        Produto produto = mapper.map(produtoDto, Produto.class);

        // Salvar o produto no banco.
        produto = produtoRepository.save(produto);

        produtoDto.setId(produto.getId());

        // retornar o ProdutoDto atualizado.
        return produtoDto;

    }

    /**
     * Método para deletar o produto por id
     * @param id do produto que será deletado
     */
    public void deletar(Integer id) {
        // Verificar se o produto existe.
        Optional<Produto> produto = produtoRepository.findById(id);

        // Se não existir lança uma exception.
        if(produto.isEmpty()){
            throw new ResourceNotFoundException("Não foi possível deletar o produto com o id:" + id + " - Produto não existe.");
        }

        // Deleta o produto pelo id.
        produtoRepository.deleteById(id);
    }

    /**
     * Método para atualizar o produto na lista.
     * @param produto que será atualizado.
     * @param id do produto que será atualizado.
     * @return Retorna o produto após a atualização.
     */
    public ProdutoDTO atualizar(Integer id, ProdutoDTO produtoDto) {

        // Passar o id para o produtoDto.
        produtoDto.setId(id);

        // Criar um objeto de mapeamento.
        ModelMapper mapper = new ModelMapper();

        // Converter o produtoDTO em um produto.
        Produto produto = mapper.map(produtoDto, Produto.class);

        // Atualizar o produto no banco.
        produtoRepository.save(produto);

        // Retornar o produtoDto atualizado.
        return produtoDto;

    }
}
