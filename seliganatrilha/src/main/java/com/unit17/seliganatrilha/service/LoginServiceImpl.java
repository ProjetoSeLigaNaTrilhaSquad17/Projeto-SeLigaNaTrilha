package com.unit17.seliganatrilha.service;

import com.unit17.seliganatrilha.dtos.LoginDto;
import com.unit17.seliganatrilha.dtos.SessaoDto;
import com.unit17.seliganatrilha.models.Usuario;
import com.unit17.seliganatrilha.security.JWTCreator;
import com.unit17.seliganatrilha.security.JWTObject;
import com.unit17.seliganatrilha.security.WebSecurityConfig;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoginServiceImpl implements LoginService{

    private final UsuarioService usuarioService;
    private final PasswordEncoder encoder;

    public LoginServiceImpl(UsuarioService usuarioService, PasswordEncoder encoder) {
        this.usuarioService = usuarioService;
        this.encoder = encoder;
    }

    @Override
    public SessaoDto login(LoginDto loginDto) {
        Usuario usuario = usuarioService.findByEmail(loginDto.getEmail());
        boolean passwordOk =  encoder.matches(loginDto.getSenha(), usuario.getSenha());
        if (!passwordOk) {
            throw new RuntimeException("Senha incorreta");
        }
        SessaoDto sessao = new SessaoDto();
        sessao.setLogin(usuario.getEmail());

        JWTObject jwtObject = new JWTObject();
        jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
        jwtObject.setExpiration((new Date(System.currentTimeMillis() + WebSecurityConfig.EXPIRATION)));
        jwtObject.setRoles(usuario.getRoles());
        sessao.setToken(JWTCreator.create(WebSecurityConfig.PREFIX, WebSecurityConfig.KEY, jwtObject));
        return sessao;
    }
}
