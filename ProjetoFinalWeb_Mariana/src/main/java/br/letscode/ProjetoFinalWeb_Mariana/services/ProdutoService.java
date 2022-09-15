package br.letscode.ProjetoFinalWeb_Mariana.services;

import br.letscode.ProjetoFinalWeb_Mariana.models.Produto;

import java.util.List;

public interface ProdutoService {

    List<Produto> listarTodosProdutos();

    boolean novoProduto(Produto produto);

    boolean atualizarProduto(Produto produto);

    boolean removerProduto (long id);

}
