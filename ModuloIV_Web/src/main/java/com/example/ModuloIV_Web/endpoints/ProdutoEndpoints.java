package com.example.ModuloIV_Web.endpoints;

import com.example.ModuloIV_Web.Models.Produto;
import com.example.ModuloIV_Web.Services.ProdutoService;
import com.example.ModuloIV_Web.dto.ProdutoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ProdutoEndpoints {
    @Autowired
    ProdutoService produtoService;

    @RequestMapping(path="/produto", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Produto>> getAllProdutos(){
        List<Produto> produto = produtoService.listarTodosProdutos();
        return ResponseEntity.ok(produto);
    }

    @RequestMapping(path="/produto/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Produto> getProdutoPorID(@PathVariable long id){
        try {
            Produto produto = produtoService.listarProdutoPorID(id);
            return ResponseEntity.ok(produto);
        }catch (Exception e){
            return new ResponseEntity("Não existe produto com o ID informado", HttpStatus.BAD_REQUEST);
        }


    }

    @RequestMapping(path="/produto", method = RequestMethod.POST)
    public ResponseEntity novotProduto(@RequestBody ProdutoDto produtoDto){
        boolean sucesso = produtoService.novoProduto(produtoDto);
        if(sucesso) {
            return new ResponseEntity("Produto criado com sucesso!", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity("Criacao do produto falhou!", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path="/produto", method = RequestMethod.PUT)
    public ResponseEntity atualizarProduto(@RequestBody Produto produto){
        boolean sucesso = produtoService.atualizarProduto(produto);
        if(sucesso) {
            return new ResponseEntity("Produto atualizado com sucesso!", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity("Atualização do produto falhou!", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path="/produto/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Produto> removerProduto(@PathVariable long id) {
        boolean sucesso = produtoService.removerProduto(id);
        if (sucesso) {
            return new ResponseEntity("Produto deletado com sucesso!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Remoção do produto falhou!", HttpStatus.BAD_REQUEST);
        }
    }
}
