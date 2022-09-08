package com.example.ModuloIV_Web.Services.impl;

import com.example.ModuloIV_Web.Models.Cliente;
import com.example.ModuloIV_Web.Models.PerfilEnum;
import com.example.ModuloIV_Web.Services.ClienteService;
import com.example.ModuloIV_Web.dao.ClienteDao;
import com.example.ModuloIV_Web.dto.ClienteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteDao clienteDao;

    private final PasswordEncoder passwordEncoder;

    public ClienteServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public List<Cliente> listarTodosClientes() {
        return clienteDao.findAll();
    }

    //Usando o DTO pq nosso caso (de mentirinha), precisamos de algum trabalho nele antes de chegar a camada de persistencia
    public Cliente novoCliente(ClienteDto clienteDto) {
        try {
            if (clienteDto.getId() == 0) {
                clienteDto.setSenha(passwordEncoder.encode(clienteDto.getSenha()));
            }
            Cliente cliente = new Cliente(clienteDto.getNome(), clienteDto.getSobrenome(), clienteDto.getEmail(), clienteDto.getSexo(), clienteDto.getCpf(), clienteDto.getSenha(), PerfilEnum.CLIENTE);
            clienteDao.save(cliente);
            cliente.setSenha("");
            return cliente;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean atualizarCliente(Cliente cliente) {
        try {
            Optional<Cliente> cli = clienteDao.findById(cliente.getId());
            if(cli.isPresent()) {
                if (!passwordEncoder.encode(cliente.getSenha()).equals(cli.get().getSenha()))
                    cliente.setSenha(passwordEncoder.encode(cliente.getSenha()));
                if (!cli.get().getPerfil().equals(cliente.getPerfil()))
                    cliente.setPerfil(cli.get().getPerfil());
            }
            else{
                cliente.setSenha(passwordEncoder.encode(cliente.getSenha()));
                cliente.setPerfil(PerfilEnum.CLIENTE);
            }

            clienteDao.save(cliente);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removerCliente(long id) {
        try {
            clienteDao.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Transactional
    @Override
    public boolean atualizarPerfil(String email, PerfilEnum perfilEnum) {
        try {
            clienteDao.setPerfilWhereEmail(perfilEnum.name(), email);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}