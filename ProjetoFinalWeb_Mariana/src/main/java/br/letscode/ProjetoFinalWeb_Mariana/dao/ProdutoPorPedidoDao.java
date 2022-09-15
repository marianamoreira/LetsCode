package br.letscode.ProjetoFinalWeb_Mariana.dao;

import br.letscode.ProjetoFinalWeb_Mariana.models.ProdutoPorPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoPorPedidoDao extends JpaRepository<ProdutoPorPedido, Long> {

    @Modifying
    @Query(value="DELETE FROM produtos_pedidos WHERE id_Produto = ?1 AND id_Pedido = ?2",
            nativeQuery = true)
    void deleteByIdProdutoAndIdPedido(long idProduto, long idPedido);
    @Query(value="SELECT * FROM produtos_pedidos WHERE id_pedido = ?1",
            nativeQuery = true)
    List<ProdutoPorPedido> findAllByIdPedido(long idPedido);
}
