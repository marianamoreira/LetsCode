package br.letscode.ProjetoFinalWeb_Mariana.endpoints;

import br.letscode.ProjetoFinalWeb_Mariana.dto.ClienteDto;
import br.letscode.ProjetoFinalWeb_Mariana.models.Cliente;
import br.letscode.ProjetoFinalWeb_Mariana.models.PerfilEnum;
import br.letscode.ProjetoFinalWeb_Mariana.services.ClienteService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

@RestController
public class ClienteEndpoints {
    @Autowired
    ClienteService clienteService;

    Logger logger = LoggerFactory.getLogger(ClienteEndpoints.class);

    @RequestMapping(path = "/cliente", method = RequestMethod.POST)
    public ResponseEntity novoCliente(@RequestBody ClienteDto cliente) {
        boolean sucesso = clienteService.novoCliente(cliente);

        if (sucesso) {
            return new ResponseEntity("Cliente criado com sucesso!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Criação do cliente falhou!", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/cliente", method = RequestMethod.PUT)
    public ResponseEntity atualizarCliente(@RequestBody Cliente cliente) {
        boolean sucesso = clienteService.atualizarCliente(cliente);

        if (sucesso) {
            return new ResponseEntity("Cliente atualizado com sucesso!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Atualização do cliente falhou!", HttpStatus.BAD_REQUEST);
        }
    }
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(path = "/cliente/{cpf}", method = RequestMethod.DELETE)
    public ResponseEntity removerClientePorCPF(@PathVariable String cpf) {
        boolean sucesso = clienteService.removerClientePorCPF(cpf);

        if (sucesso) {
            return new ResponseEntity("Cliente deletado com sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity("Remoção do cliente falhou!", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/cliente", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cliente>> getAllCients() {
        List<Cliente> clienteList = clienteService.listarTodosClientes();

        return ResponseEntity.ok(clienteList);
    }

    @RequestMapping(path = "/cliente/{cpf}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> getClientByCPF(@PathVariable String cpf) {
        try {
            Cliente cliente = clienteService.listarClientePorCPF(cpf);
            return ResponseEntity.ok(cliente);
        } catch (Exception e) {
            return new ResponseEntity("Cliente não existe!", HttpStatus.BAD_REQUEST);
        }
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(path="/cliente/perfil", method = RequestMethod.PUT)
    public ResponseEntity atualizarPerfil(@RequestParam("cpf") String cpf, @RequestParam("perfil") PerfilEnum perfilEnum) {
        boolean sucesso = clienteService.atualizarPerfil(cpf,perfilEnum);
        if(sucesso) {
            return new ResponseEntity("Perfil atualizado com sucesso!", HttpStatus.OK);
        }
        else {
            return new ResponseEntity("Atualizacao do perfil falhou!", HttpStatus.BAD_REQUEST);
        }
    }
}
