package pizzaria.modelo;

public class Login {

    private String aut_usuario;
    private String aut_senha;
    private String aut_acesso;

    public static final String[] vsAcesso = { "Gerente", "Funcionário"};
    public static final String[] vsAcessoCod = { "1", "2"};


    public String getAut_usuario() {
        return aut_usuario;
    }

    public void setAut_usuario(String aut_usuario) {
        this.aut_usuario = aut_usuario;
    }

    public String getAut_senha() {
        return aut_senha;
    }

    public void setAut_senha(String aut_senha) {
        this.aut_senha = aut_senha;
    }

    public String getAut_acesso() {
        return aut_acesso;
    }

    public void setAut_acesso(String aut_acesso) {
        this.aut_acesso = aut_acesso;
    }
    
}
