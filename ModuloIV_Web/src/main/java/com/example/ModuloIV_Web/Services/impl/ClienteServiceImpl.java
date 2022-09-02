package com.example.ModuloIV_Web.Services.impl;

import com.example.ModuloIV_Web.Models.Cliente;
import com.example.ModuloIV_Web.Services.ClienteService;
import com.example.ModuloIV_Web.dao.ClienteDao;
import com.example.ModuloIV_Web.dto.ClienteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteDao clienteDao;

    public List<Cliente> listarTodosClientes(){
        return clienteDao.findAll();
    }

    public boolean novoCliente(ClienteDto clienteDto) {
        try {
            Cliente cliente = new Cliente(clienteDto.getNome(), clienteDto.getSobrenome(), clienteDto.getEmail(), clienteDto.getSexo(), clienteDto.getCpf());
            clienteDao.save(cliente);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean atualizarCliente(Cliente cliente) {
        try {
            clienteDao.save(cliente); //INSERT
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removerCliente(long id) {
        try {
            clienteDao.deleteById(id); // DELETE FROM CLIENTE WHERE ID = {long id}
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
