package br.letscode.ProjetoFinalWeb_Mariana.endpoints;

import br.letscode.ProjetoFinalWeb_Mariana.models.Pedido;
import br.letscode.ProjetoFinalWeb_Mariana.models.Produto;
import br.letscode.ProjetoFinalWeb_Mariana.services.PedidoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class PedidoEndpoints {

    @Autowired
    PedidoService pedidoService;

    Logger logger = LoggerFactory.getLogger(PedidoEndpoints.class);

    @RequestMapping(path = "/pedido", method = RequestMethod.POST)
    public ResponseEntity novoPedido(@RequestBody Pedido pedido) {
        boolean sucesso = pedidoService.novoPedido(pedido);

        if (sucesso) {
            return new ResponseEntity("Pedido criado com sucesso!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Criação do pedido falhou!", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path="/pedido", method = RequestMethod.PUT)
    public ResponseEntity atualizarPedido(@RequestBody Pedido pedido){
        boolean sucesso = pedidoService.atualizarPedido(pedido);
        if(sucesso) {
            return new ResponseEntity("Pedido atualizado com sucesso!", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity("Atualização do pedido falhou!", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path="/pedido/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Produto> removerPedido(@PathVariable long id) {
        boolean sucesso = pedidoService.removerPedido(id);
        if (sucesso) {
            return new ResponseEntity("Pedido deletado com sucesso!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Remoção do pedido falhou!", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path="/pedido", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pedido>> getAllPedidos(){
        List<Pedido> pedido = pedidoService.listarTodosPedidos();
        return ResponseEntity.ok(pedido);
    }
}
