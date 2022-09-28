package services;

@Services
public class UsuarioServices {
    final UsuarioRepository usuarioRepository;

    public UsuarioServices(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }
}
