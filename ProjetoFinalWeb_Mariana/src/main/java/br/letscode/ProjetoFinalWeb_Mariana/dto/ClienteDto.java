package br.letscode.ProjetoFinalWeb_Mariana.dto;

import br.letscode.ProjetoFinalWeb_Mariana.models.PerfilEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ClienteDto {
    private long id;
    private String CPF;
    private String nome;
    private String email;
    private String senha;
    private PerfilEnum perfil;

    public ClienteDto(String CPF, String nome, String email, String senha) {
        this.CPF = CPF;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
}