package com.unit17.seliganatrilha.controllers;

import com.unit17.seliganatrilha.dtos.LoginDto;
import com.unit17.seliganatrilha.dtos.SessaoDto;
import com.unit17.seliganatrilha.models.Usuario;
import com.unit17.seliganatrilha.repositories.UsuarioRepository;
import com.unit17.seliganatrilha.security.JWTCreator;
import com.unit17.seliganatrilha.security.JWTObject;
import com.unit17.seliganatrilha.security.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
@RestController
public class LoginController {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private WebSecurityConfig webSecurityConfig;
    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/login")
    public SessaoDto logar(@RequestBody LoginDto login){
        Usuario user = repository.findByEmail(login.getEmail());
        if(user!=null) {
            boolean passwordOk =  encoder.matches(login.getSenha(), user.getSenha());
            if (!passwordOk) {
                throw new RuntimeException("Senha inválida para o login: " + login.getEmail());
            }

            SessaoDto sessao = new SessaoDto();
            sessao.setLogin(user.getEmail());

            JWTObject jwtObject = new JWTObject();
            jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
            jwtObject.setExpiration((new Date(System.currentTimeMillis() + WebSecurityConfig.EXPIRATION)));
            jwtObject.setRoles(user.getRoles());
            sessao.setToken(JWTCreator.create(WebSecurityConfig.PREFIX, WebSecurityConfig.KEY, jwtObject));
            return sessao;
        }else {
            throw new RuntimeException("Erro ao tentar fazer login");
        }
    }
}
