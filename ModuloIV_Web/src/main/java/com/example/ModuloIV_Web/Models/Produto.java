package com.example.ModuloIV_Web.Models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
@Data
@NoArgsConstructor
@Entity
@Table(name="produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "preco")
    private BigDecimal preco;

    @Column(name = "descricao")
    private String descricao;

    public Produto(String nome, BigDecimal preco, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

}
