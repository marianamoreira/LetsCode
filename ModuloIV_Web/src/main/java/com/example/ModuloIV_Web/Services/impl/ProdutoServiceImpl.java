package com.example.ModuloIV_Web.Services.impl;

import com.example.ModuloIV_Web.Models.Produto;
import com.example.ModuloIV_Web.Services.ProdutoService;
import com.example.ModuloIV_Web.dao.ProdutoDao;
import com.example.ModuloIV_Web.dto.ProdutoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoDao produtoDao;


    @Override
    public List<Produto> listarTodosProdutos() {
        return produtoDao.findAll();
    }

    @Override
    public Produto listarProdutoPorID(long id) {
        return produtoDao.findById(id).orElseThrow(NegativeArraySizeException::new);
    }

    @Override
    public boolean novoProduto(ProdutoDto produtoDto) {
        try{
            Produto produto = new Produto(produtoDto.getNome(),produtoDto.getPreco(),produtoDto.getDescricao());
            produtoDao.save(produto);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean atualizarProduto(Produto produto) {
        try{
            produtoDao.save(produto);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean removerProduto(long id) {
        try {
            produtoDao.deleteById(id); // DELETE FROM CLIENTE WHERE ID = {long id}
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
