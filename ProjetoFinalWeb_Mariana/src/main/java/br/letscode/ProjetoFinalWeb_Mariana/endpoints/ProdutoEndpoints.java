package br.letscode.ProjetoFinalWeb_Mariana.endpoints;

import br.letscode.ProjetoFinalWeb_Mariana.models.Produto;
import br.letscode.ProjetoFinalWeb_Mariana.services.ProdutoService;
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
public class ProdutoEndpoints {
    @Autowired
    ProdutoService produtoService;
    Logger logger = LoggerFactory.getLogger(Produto.class);

    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(path = "/produto", method = RequestMethod.POST)
    public ResponseEntity novoProduto(@RequestBody Produto produto) {
        boolean sucesso = produtoService.novoProduto(produto);

        if (sucesso) {
            return new ResponseEntity("Produto criado com sucesso!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Criação do produto falhou!", HttpStatus.BAD_REQUEST);
        }
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(path = "/produto", method = RequestMethod.PUT)
    public ResponseEntity atualizarProduto(@RequestBody Produto produto) {
        boolean sucesso = produtoService.atualizarProduto(produto);
        if (sucesso) {
            return new ResponseEntity("Produto atualizado com sucesso!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Atualização do produto falhou!", HttpStatus.BAD_REQUEST);
        }
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(path = "/produto/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Produto> removerProduto(@PathVariable long id) {
        boolean sucesso = produtoService.removerProduto(id);
        if (sucesso) {
            return new ResponseEntity("Produto deletado com sucesso!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Remoção do produto falhou!", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/produto", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Produto>> getAllProdutos() {
        List<Produto> produto = produtoService.listarTodosProdutos();
        return ResponseEntity.ok(produto);
    }

}
