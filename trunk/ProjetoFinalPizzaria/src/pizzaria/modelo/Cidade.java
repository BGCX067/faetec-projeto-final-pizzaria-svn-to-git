package pizzaria.modelo;

public class Cidade {

    private int cid_id;
    private String cid_nome;
    private Estado estado;

    public Cidade() {
    }

    public int getCid_id() {
        return cid_id;
    }

    //método com Exceções \/
    public void setCid_id(int cid_id) throws Exception {
        this.cid_id = cid_id;

    }

    public String getCid_nome() {
        return cid_nome;
    }

    public void setCid_nome(String cid_nome) {
        this.cid_nome = cid_nome;
    }

    @Override
    public String toString() {
        return cid_nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
