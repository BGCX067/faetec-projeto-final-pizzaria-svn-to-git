package pizzaria.modelo;

public class Venda {
    
    private int venda_id;
    private Funcionario funcionario;
    private Pedido pedido;

    public int getVenda_id() {
        return venda_id;
    }

    public void setVenda_id(int venda_id) {
        this.venda_id = venda_id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
}
