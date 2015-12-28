package pizzaria.modelo;

public class Bairro {

    private int bai_id;
    private String bai_nome;
    private Cidade cidade;

    public Bairro() {
    }

    public int getBai_Id() {
        return bai_id;
    }

    public void setBai_Id(int bai_id) {
            this.bai_id = bai_id;
        
    }

    public String getBai_Nome() {
        return bai_nome;
    }

    public void setBai_Nome(String bai_nome) {
        this.bai_nome = bai_nome;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return bai_nome;
    }
}
