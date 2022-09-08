package com.example.ModuloIV_Web.Services;

import com.example.ModuloIV_Web.Models.Cliente;
import com.example.ModuloIV_Web.Models.PerfilEnum;
import com.example.ModuloIV_Web.dto.ClienteDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteService {
    List<Cliente> listarTodosClientes();

    Cliente novoCliente(ClienteDto cliente);

    boolean atualizarCliente(Cliente cliente);

    boolean removerCliente(long id);

    boolean atualizarPerfil(String email, PerfilEnum perfilEnum);
}