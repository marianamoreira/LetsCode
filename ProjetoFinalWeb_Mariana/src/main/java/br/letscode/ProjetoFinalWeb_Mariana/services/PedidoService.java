package br.letscode.ProjetoFinalWeb_Mariana.services;

import br.letscode.ProjetoFinalWeb_Mariana.models.Pedido;

import java.util.List;

public interface PedidoService {
    List<Pedido> listarTodosPedidos();

    boolean novoPedido(Pedido pedido);

    boolean atualizarPedido(Pedido pedido);

    boolean removerPedido(long id);
}
