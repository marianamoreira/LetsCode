package com.example.ModuloIV_Web.configuration.security;

import com.example.ModuloIV_Web.Models.Cliente;
import com.example.ModuloIV_Web.dao.ClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    ClienteDao clienteDao;

    //Implementacao da mesma, utilizando o DAO da aplicacao (credenciais salvas no banco).
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Cliente cliente = clienteDao.findByEmail(email);

        if (Objects.isNull(cliente)) {
            throw new UsernameNotFoundException(email);
        }

        return new UserPrincipalDetails(cliente); //Retornando somente o que eh importante para a autenticacao.
    }

}
