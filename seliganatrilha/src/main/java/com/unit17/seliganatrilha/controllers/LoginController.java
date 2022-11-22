package com.unit17.seliganatrilha.controllers;

import com.unit17.seliganatrilha.dtos.LoginDto;

import com.unit17.seliganatrilha.exceptions.UsuarioNaoEncontradoException;
import com.unit17.seliganatrilha.security.WebSecurityConfig;
import com.unit17.seliganatrilha.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class LoginController {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private WebSecurityConfig webSecurityConfig;
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> logar(@RequestBody LoginDto login){
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(loginService.login(login));
        } catch (UsuarioNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
        }
    }
}
