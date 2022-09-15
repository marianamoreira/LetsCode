package br.letscode.ProjetoFinalWeb_Mariana.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class QtdProdutosKey implements Serializable {

    @Column(name = "idPedido")
    private long idPedido;

    @Column(name = "idProduto")
    private long idProduto;

}
