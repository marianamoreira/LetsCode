package br.letscode.ProjetoFinalWeb_Mariana.services;

import br.letscode.ProjetoFinalWeb_Mariana.models.ProdutoPorPedido;

import java.util.List;

public interface ProdutosPorPedidoService {
    List<ProdutoPorPedido> listarProdutosPorPedidos(long idPedido);

    boolean novoProdutoPedido(ProdutoPorPedido produtoPorPedido);

    boolean atualizarProdutoPedido(ProdutoPorPedido produtoPorPedido);

    boolean removerProdutoPedido(long idProduto, long idPedido);
}
