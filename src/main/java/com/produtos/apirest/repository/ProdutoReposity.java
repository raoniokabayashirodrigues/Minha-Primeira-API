package com.produtos.apirest.repository;

import com.produtos.apirest.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoReposity extends JpaRepository<Produto, Long> {

    Produto findById(long id);
}
