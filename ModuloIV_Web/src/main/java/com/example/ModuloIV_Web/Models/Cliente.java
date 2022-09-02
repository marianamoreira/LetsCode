package com.example.ModuloIV_Web.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.annotation.processing.Generated;
import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="nome")
    private String nome;
    @Column(name="sobrenome")
    private String sobrenome;
    @Column(name="email")
    private String email;
    @Column(name="sexo")
    private String sexo;
    @Column(name="cpf")
    private String cpf;
    public Cliente(String nome, String sobrenome, String email, String sexo, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.sexo = sexo;
        this.cpf = cpf;
    }
}
