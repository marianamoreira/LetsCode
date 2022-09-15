package br.letscode.ProjetoFinalWeb_Mariana.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduto")
    private long id;

    @Column(name="nome")
    private String nome;

    @Column(name="preco")
    private BigDecimal preco;

    @Column(name="descricao")
    private String descricao;

}
