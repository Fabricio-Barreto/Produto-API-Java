package com.api.api.repository;

import com.api.api.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//Atenção -- Interface--
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
    
}
