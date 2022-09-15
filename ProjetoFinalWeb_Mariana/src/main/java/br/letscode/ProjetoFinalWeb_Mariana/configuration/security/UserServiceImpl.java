package br.letscode.ProjetoFinalWeb_Mariana.configuration.security;

import br.letscode.ProjetoFinalWeb_Mariana.dao.ClienteDao;
import br.letscode.ProjetoFinalWeb_Mariana.models.Cliente;
import br.letscode.ProjetoFinalWeb_Mariana.models.PerfilEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    ClienteDao clienteDao;

    //Implementacao da mesma, utilizando o DAO da aplicacao (credenciais salvas no banco).
    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {

        Optional<Cliente> cliente = clienteDao.findByCPF(cpf);
        Cliente clienteFinal = new Cliente();

        if (!cliente.isPresent()) {
            throw new UsernameNotFoundException(cpf);
        }
        else{
            clienteFinal = new Cliente(cliente.get().getId(), cliente.get().getCPF(), cliente.get().getNome(), cliente.get().getEmail(), cliente.get().getSenha(), cliente.get().getPerfil());
        }

        return new UserPrincipalDetails(clienteFinal); //Retornando somente o que eh importante para a autenticacao.
    }

}
