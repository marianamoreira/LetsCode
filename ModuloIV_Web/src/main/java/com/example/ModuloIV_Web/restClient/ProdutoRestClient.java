package com.example.ModuloIV_Web.restClient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(
        value = "financeiroRestClient",
        url = "https://dummyjson.com")
public interface ProdutoRestClient {
    @RequestMapping(path="/products", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    List<String> findAll();
}
