package com.unit17.seliganatrilha.controllers;

import com.unit17.seliganatrilha.dtos.UsuarioDto;
import com.unit17.seliganatrilha.models.Usuario;
import com.unit17.seliganatrilha.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/usuario")
public class UsuarioController {

    final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }

    @PostMapping
    public String save(@RequestBody UsuarioDto novoUsuario){
        usuarioService.save(novoUsuario);
        return "Novo usuário cadastrado com sucesso!";
    }

    @PutMapping
    public String update(@RequestBody UsuarioDto usuarioAtualizar){
        usuarioService.save(usuarioAtualizar);
        return "Dados de usuário atualizados com sucesso!";
    }

    @DeleteMapping
    public String delete(@RequestBody Usuario usuarioDeletar){
        usuarioService.delete(usuarioDeletar);
            return "Usuário deletado com sucesso!";
    }

}
