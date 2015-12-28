package pizzaria.modelo;

public class Bebida {
    
    private int beb_id;
    private String beb_desc;
    private Double beb_preco;
    private String beb_tam;

    public int getBeb_id() {
        return beb_id;
    }

    public void setBeb_id(int beb_id) {
        this.beb_id = beb_id;
    }

    public String getBeb_desc() {
        return beb_desc;
    }

    public void setBeb_desc(String beb_desc) {
        this.beb_desc = beb_desc;
    }

    public Double getBeb_preco() {
        return beb_preco;
    }

    public void setBeb_preco(Double beb_preco) {
        this.beb_preco = beb_preco;
    }

    public String getBeb_tam() {
        return beb_tam;
    }

    public void setBeb_tam(String beb_tam) {
        this.beb_tam = beb_tam;
    }
    
}
