package pizzaria.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente {
    private int cli_id;
    private String cli_nome;
    private String cli_sexo;
    private String cli_cpf;
    private String cli_rg;
    private Date cli_data_nasc;
    private Logradouro log;
    private String cli_numero;
    private String cli_compl;
    private List<Telefone> telefones;

    public Cliente() {
        telefones = new ArrayList<Telefone>();
    }


    public int getCli_id() {
        return cli_id;
    }

    public void setCli_id(int cli_id) {
        this.cli_id = cli_id;
    }

    public String getCli_nome() {
        return cli_nome;
    }

    public void setCli_nome(String cli_nome) {
        this.cli_nome = cli_nome;
    }

    public String getCli_sexo() {
        return cli_sexo;
    }

    public void setCli_sexo(String cli_sexo) {
        this.cli_sexo = cli_sexo;
    }

    public String getCli_cpf() {
        return cli_cpf;
    }

    public void setCli_cpf(String cli_cpf) {
        this.cli_cpf = cli_cpf;
    }

    public String getCli_rg() {
        return cli_rg;
    }

    public void setCli_rg(String cli_rg) {
        this.cli_rg = cli_rg;
    }

    public Date getCli_data_nasc() {
        return cli_data_nasc;
    }

    public void setCli_data_nasc(Date cli_data_nasc) {
        this.cli_data_nasc = cli_data_nasc;
    }

    public Logradouro getLogradouro() {
        return getLog();
    }

    public void setLogradouro(Logradouro logradouro) {
        this.setLog(logradouro);
    }

    public Logradouro getLog() {
        return log;
    }

    public void setLog(Logradouro log) {
        this.log = log;
    }

    public String getCli_numero() {
        return cli_numero;
    }

    public void setCli_numero(String cli_numero) {
        this.cli_numero = cli_numero;
    }

    public String getCli_compl() {
        return cli_compl;
    }

    public void setCli_compl(String cli_compl) {
        this.cli_compl = cli_compl;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

}
