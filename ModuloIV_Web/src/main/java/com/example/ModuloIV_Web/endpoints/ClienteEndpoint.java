package com.example.ModuloIV_Web.endpoints;


import com.example.ModuloIV_Web.Models.Cliente;
import com.example.ModuloIV_Web.Services.ClienteService;
import com.example.ModuloIV_Web.dto.ClienteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ClienteEndpoint {
    @Autowired
    ClienteService clienteService;


    @RequestMapping(path="/cliente", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cliente>> getAllCients() {
        List<Cliente> clienteList = clienteService.listarTodosClientes();

        return ResponseEntity.ok(clienteList);
    }

    @RequestMapping(path="/cliente", method = RequestMethod.POST)
    public ResponseEntity novoCliente(@RequestBody ClienteDto cliente) {
        boolean sucesso = clienteService.novoCliente(cliente);

        if(sucesso) {
            return new ResponseEntity("Cliente criado com sucesso!", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity("Criacao do cliente falhou!", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path="/cliente", method = RequestMethod.PUT)
    public ResponseEntity atualizarCliente(@RequestBody Cliente cliente) {
        boolean sucesso = clienteService.atualizarCliente(cliente);

        if(sucesso) {
            return new ResponseEntity("Cliente atualizado com sucesso!", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity("Atualizacao do cliente falhou!", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path="/cliente/{id}", method = RequestMethod.DELETE)
    public ResponseEntity removerCliente(@PathVariable long id) {
        boolean sucesso = clienteService.removerCliente(id);

        if(sucesso) {
            return new ResponseEntity("Cliente deletado com sucesso!", HttpStatus.OK);
        }
        else {
            return new ResponseEntity("Remocao do cliente falhou!", HttpStatus.BAD_REQUEST);
        }
    }
}
