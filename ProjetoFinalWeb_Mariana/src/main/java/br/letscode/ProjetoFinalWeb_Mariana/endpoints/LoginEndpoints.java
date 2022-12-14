package br.letscode.ProjetoFinalWeb_Mariana.endpoints;

import br.letscode.ProjetoFinalWeb_Mariana.configuration.security.UserLoginDto;
import br.letscode.ProjetoFinalWeb_Mariana.configuration.security.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginEndpoints {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(path="/login", method = RequestMethod.POST)
    public ResponseEntity autenticacao(@RequestBody UserLoginDto userLoginDto) {
        return new ResponseEntity(HttpStatus.OK);
    }
}