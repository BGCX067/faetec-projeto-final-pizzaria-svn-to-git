package pizzaria.modelo;

public class Estado {

    private String est_uf;
    private String est_nome;

    public Estado() {

    }
    
    public String getEst_uf() {
        return est_uf;
    }

    //método com Exceções \/
    public void setEst_uf(String est_uf) throws Exception {
        if (est_uf.isEmpty()) {
//Cria uma nova Exceção \/
            throw new Exception("A est_uf não pode estar vazia!");
        } else {
            this.est_uf = est_uf;
        }
    }

    public String getEst_nome() {
        return est_nome;
    }

    public void setEst_nome(String est_nome) {
        this.est_nome = est_nome;
    }

    @Override
    public String toString() {
        return est_uf;
    }


}
