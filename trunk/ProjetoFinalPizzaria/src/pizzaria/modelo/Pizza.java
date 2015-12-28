package pizzaria.modelo;

public class Pizza {
    
    private int piz_id;
    private String piz_desc;
    private String piz_sabor;
    private String piz_tam;
    private double piz_preco;


    public int getPiz_id() {
        return piz_id;
    }

    public void setPiz_id(int piz_id) {
        this.piz_id = piz_id;
    }

    public String getPiz_desc() {
        return piz_desc;
    }

    public void setPiz_desc(String piz_desc) {
        this.piz_desc = piz_desc;
    }

    public String getPiz_sabor() {
        return piz_sabor;
    }

    public void setPiz_sabor(String piz_sabor) {
        this.piz_sabor = piz_sabor;
    }

    public String getPiz_tam() {
        return piz_tam;
    }

    public void setPiz_tam(String piz_tam) {
        this.piz_tam = piz_tam;
    }

    public double getPiz_preco() {
        return piz_preco;
    }

    public void setPiz_preco(double piz_preco) {
        this.piz_preco = piz_preco;
    }
    
}
