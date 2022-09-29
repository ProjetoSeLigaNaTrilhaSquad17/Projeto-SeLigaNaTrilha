package controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import services.UsuarioServices;

@RestController
@CrossOrigin(Origins="*", MaxAge=3600)
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @GetMapping
    public List<Usuario> findAll(){
        usuarioRepo.findAll();
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
