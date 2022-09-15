package br.letscode.services;

import br.letscode.models.Produto;

import java.util.List;

public interface ProdutoService {

    Produto salvar(Produto cliente);

    Produto atualizar(Produto cliente);

    void excluir(long id);

    Produto getById(long id);

    List<Produto> getAll();

}