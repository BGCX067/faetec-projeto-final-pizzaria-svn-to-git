package pizzaria.modelo;

public class ItemPedido {

    private int ped_num;
    private Bebida bebida;
    private Pizza pizza;
    private int quantidade;
    private double valor_total;
    private double itp_preco;
    private char operacao;  // P-Pizza, B-Bebida, A-Altera

    public ItemPedido() {       
        operacao = 'A';
    }

    public ItemPedido(int ped_num, Bebida bebida, Pizza pizza, int quantidade, double itp_preco, double valor_total, char operacao) throws Exception {
        if (operacao == 'P') {
        } else if (operacao == 'B') {
        }
        this.ped_num = ped_num;
        this.bebida = bebida;
        this.pizza = pizza;
        this.quantidade = quantidade;
        this.itp_preco = itp_preco;
        this.valor_total = valor_total;
        this.operacao = operacao;
    }

    public double getItp_preco() {
        return itp_preco;
    }

    public void setItp_preco(double itp_preco) {
        this.itp_preco = itp_preco;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public char getOperacao() {
        return operacao;
    }

    public void setOperacao(char operacao) {
        this.operacao = operacao;
    }
/*
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemPedido other = (ItemPedido) obj;
        if (this.pizza == null || !this.pizza.getPiz_desc().equalsIgnoreCase(other.pizza.getPiz_desc())) {
            return false;
        } else if (this.bebida == null || !this.bebida.getBeb_desc().equalsIgnoreCase(other.bebida.getBeb_desc())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.pizza != null ? this.pizza.hashCode() : 0);
        return hash;
    }*/

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public int getPed_num() {
        return ped_num;
    }

    public void setPed_num(int ped_num) {
        this.ped_num = ped_num;
    }
}
