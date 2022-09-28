package controllers;

import services.UsuarioServices;

@RestController
@CrossOrigin(Origins="*", MaxAge=3600)
@RequestMapping("/usuario")
public class UsuarioController {
    final UsuarioServices usuarioServices;
    public UsuarioController(UsuarioServices usuarioServices){
        this.usuarioServices = usuarioServices;
    }    
}
