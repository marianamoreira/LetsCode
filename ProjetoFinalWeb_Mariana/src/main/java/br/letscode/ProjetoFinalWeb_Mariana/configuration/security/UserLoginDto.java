package br.letscode.ProjetoFinalWeb_Mariana.configuration.security;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginDto {

    private String cpf;
    private String senha;

}
