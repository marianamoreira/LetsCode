package com.example.ModuloIV_Web.endpoints;

import com.example.ModuloIV_Web.Models.Cliente;
import com.example.ModuloIV_Web.configuration.security.UserLoginDto;
import com.example.ModuloIV_Web.configuration.security.UserPrincipalDetails;
import com.example.ModuloIV_Web.configuration.security.UserServiceImpl;
import com.example.ModuloIV_Web.dto.ClienteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginEndpoints {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(path="/login", method = RequestMethod.POST)
    public ResponseEntity autenticacao(@RequestBody UserLoginDto userLoginDto) {
            return new ResponseEntity(HttpStatus.OK);
    }
}
