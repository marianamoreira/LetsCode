package com.example.ModuloIV_Web.Services;

import com.example.ModuloIV_Web.Models.Produto;
import com.example.ModuloIV_Web.dto.ProdutoDto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    List<Produto> listarTodosProdutos();
    Produto listarProdutoPorID(long id);



    boolean novoProduto(ProdutoDto produtoDto);



    boolean atualizarProduto (Produto produto);



    boolean removerProduto (long id);

}
