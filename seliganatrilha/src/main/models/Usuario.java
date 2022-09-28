import java.lang.annotation.Inherited;
import java.util.UUID;

@Entity
@Table(Name = "tb_usuario")
public class Usuario{
    @ID
    @GeneratedValue(Strategy=GenerationType.auto)
    @Collumn(Nullable = false, Unique = true)
    private UUID id;
    @Collumn(Nullable = false, Unique = true)
    private String nome;
    @Collumn(Nullable = false, Unique = true)
    private String email;
    @Collumn(Nullable = false, Unique = true)
    private String cpf;
    @Collumn(Nullable = false, Unique = true)
    private String senha;
    

    public Usuario(int id, String nome, String email, String cpf, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }


    
}