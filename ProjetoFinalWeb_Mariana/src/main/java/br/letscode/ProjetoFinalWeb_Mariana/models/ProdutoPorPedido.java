package br.letscode.ProjetoFinalWeb_Mariana.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="produtos_pedidos")
public class ProdutoPorPedido {

    @EmbeddedId
    private QtdProdutosKey id;

    @ManyToOne
    @MapsId("idPedido")
    @JoinColumn(name = "idPedido")
    private Pedido pedido;

    @ManyToOne
    @MapsId("idProduto")
    @JoinColumn(name = "idProduto")
    private Produto produto;

    private int quantidade;
}
