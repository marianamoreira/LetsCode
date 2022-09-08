package com.example.ModuloIV_Web.endpoints;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.ModuloIV_Web.Services.impl.HelloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloEndpoints {
    @Autowired
    private HelloServiceImpl helloService;

    Logger logger = LoggerFactory.getLogger(HelloEndpoints.class);

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public ResponseEntity hello() {
        logger.info("Usou endpoint Hello");
        return new ResponseEntity("Hello world!", HttpStatus.OK);
    }

    @RequestMapping(path = "/hello/{nome}", method = RequestMethod.GET)
    public ResponseEntity helloNome(@PathVariable String nome) {
        logger.info("Usou endpoint Hello/{nome}");
        return new ResponseEntity("Hello "+nome, HttpStatus.OK);
    }

    @RequestMapping(path = "/hello/{nome}/horario", method = RequestMethod.GET)
    public ResponseEntity helloNomeHorario(@PathVariable String nome) {
        logger.info("Usou endpoint Hello/{nome}/horario");
        return new ResponseEntity("Hello "+nome+"! Agora são "+
                helloService.getHorario()
                +", não esqueça!", HttpStatus.OK);
    }
    //as vezes pede pra retornar o tipo e é boa prática retornar, mas n é necessário
    @RequestMapping(path = "/hello2", method = RequestMethod.GET)
    public ResponseEntity hello2() {
        return new ResponseEntity("Hello world!", HttpStatus.OK);
    }
}
