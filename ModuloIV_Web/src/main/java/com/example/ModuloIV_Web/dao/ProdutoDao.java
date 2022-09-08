package com.example.ModuloIV_Web.dao;

import com.example.ModuloIV_Web.Models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoDao extends JpaRepository<Produto,Long> {
}
