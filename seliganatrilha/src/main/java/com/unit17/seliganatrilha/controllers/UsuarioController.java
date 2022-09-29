package com.unit17.seliganatrilha.controllers;

import com.unit17.seliganatrilha.models.Usuario;
import com.unit17.seliganatrilha.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @GetMapping
    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    @PostMapping
    public String save(@RequestBody Usuario novoUsuario){
        usuarioRepository.save(novoUsuario);
        return "Novo usuário cadastrado com sucesso!";
    }

    @PutMapping
    public String update(@RequestBody Usuario usuarioAtualizar){
        usuarioRepository.save(usuarioAtualizar);
        return "Dados de usuário atualizados com sucesso!";
    }

    @DeleteMapping
    public String delete(@RequestBody Usuario usuarioDeletar){
            usuarioRepository.delete(usuarioDeletar);
            return "Usuário deletado com sucesso!";
    }

}
