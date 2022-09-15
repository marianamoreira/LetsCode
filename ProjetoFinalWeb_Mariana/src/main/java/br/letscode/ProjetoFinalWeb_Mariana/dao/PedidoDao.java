package br.letscode.ProjetoFinalWeb_Mariana.dao;

import br.letscode.ProjetoFinalWeb_Mariana.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoDao extends JpaRepository<Pedido, Long> {
}
