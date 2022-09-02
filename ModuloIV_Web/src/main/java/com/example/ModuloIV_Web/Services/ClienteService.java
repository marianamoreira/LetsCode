package com.example.ModuloIV_Web.Services;
import com.example.ModuloIV_Web.Models.Cliente;
import com.example.ModuloIV_Web.dto.ClienteDto;

import java.util.List;

public interface ClienteService {
    List<Cliente> listarTodosClientes();

    boolean novoCliente(ClienteDto cliente);

    boolean atualizarCliente (Cliente cliente);

    boolean removerCliente (long id);

}