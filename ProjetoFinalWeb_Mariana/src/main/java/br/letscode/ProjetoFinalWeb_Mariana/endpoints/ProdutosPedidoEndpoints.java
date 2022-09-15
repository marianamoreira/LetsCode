package br.letscode.ProjetoFinalWeb_Mariana.endpoints;

import br.letscode.ProjetoFinalWeb_Mariana.models.ProdutoPorPedido;
import br.letscode.ProjetoFinalWeb_Mariana.services.ProdutosPorPedidoService;
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
public class ProdutosPedidoEndpoints {

    @Autowired
    ProdutosPorPedidoService produtosPorPedidoService;
    Logger logger = LoggerFactory.getLogger(ProdutosPedidoEndpoints.class);

    @RequestMapping(path = "/produtosPedido", method = RequestMethod.POST)
    public ResponseEntity novoProdutoPedido(@RequestBody ProdutoPorPedido produtoPorPedido) {
        boolean sucesso = produtosPorPedidoService.novoProdutoPedido(produtoPorPedido);

        if (sucesso) {
            return new ResponseEntity("Produto-Pedido criado com sucesso!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Criação do Produto-Pedido falhou!", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/produtosPedido", method = RequestMethod.PUT)
    public ResponseEntity atualizarProdutoPedido(@RequestBody ProdutoPorPedido produtoPorPedido) {
        boolean sucesso = produtosPorPedidoService.atualizarProdutoPedido(produtoPorPedido);

        if (sucesso) {
            return new ResponseEntity("Produto-Pedido atualizado com sucesso!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Atualização do Produto-Pedido falhou!", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity delete(@RequestParam("idPedido") long idPedido,@RequestParam("idProduto") long idProduto) {
        boolean sucesso = produtosPorPedidoService.removerProdutoPedido(idProduto,idPedido);

        if (sucesso) {
            return new ResponseEntity("Produto-Pedido deletado com sucesso!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Deleção do Produto-Pedido falhou!", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/produtosPedido/{idPedido}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProdutoPorPedido>> getProdutosPedido(@PathVariable Long idPedido) {
        List<ProdutoPorPedido> produtoPorPedidos = produtosPorPedidoService.listarProdutosPorPedidos(idPedido);

        return ResponseEntity.ok(produtoPorPedidos);
    }
}
