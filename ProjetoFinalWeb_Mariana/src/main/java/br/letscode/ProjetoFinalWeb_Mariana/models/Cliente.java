package br.letscode.ProjetoFinalWeb_Mariana.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NaturalId
    @Column(name="cpf", unique = true, updatable = false)
    private String CPF;

    @Column(name="nome")
    private String nome;

    @Column(name="email", unique = true)
    private String email;

    @Column(name="senha")
    private String senha;

    @Enumerated(EnumType.STRING)
    private PerfilEnum perfil;

}
