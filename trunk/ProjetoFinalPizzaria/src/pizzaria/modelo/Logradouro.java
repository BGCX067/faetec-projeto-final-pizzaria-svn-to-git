package pizzaria.modelo;

public class Logradouro {

    private int log_id;
    private String log_nome;
    private String log_cep;
    private TipoLog tipolog;
    private Bairro bairro;
 

    public int getLog_id() {
        return log_id;
    }

    public void setLog_id(int log_id) {
        this.log_id = log_id;
    }

    public String getLog_nome() {
        return log_nome;
    }

    public void setLog_nome(String log_nome) {
        this.log_nome = log_nome;
    }

    public String getLog_cep() {
        return log_cep;
    }

    public void setLog_cep(String log_cep) {
        this.log_cep = log_cep;
    }

    public TipoLog getTipolog() {
        return tipolog;
    }

    public void setTipolog(TipoLog tipolog) {
        this.tipolog = tipolog;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return tipolog + " "+log_nome;
    }

   

}