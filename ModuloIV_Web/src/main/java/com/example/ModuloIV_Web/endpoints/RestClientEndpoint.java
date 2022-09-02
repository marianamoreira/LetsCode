package com.example.ModuloIV_Web.endpoints;

import com.example.ModuloIV_Web.restClient.ProdutoRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class RestClientEndpoint {
    @Autowired
    ProdutoRestClient produtoRestClient;

    @RequestMapping(path="/produtos/dummy", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getAllProducts() {
        return ResponseEntity.ok(produtoRestClient.findAll());
    }
}
