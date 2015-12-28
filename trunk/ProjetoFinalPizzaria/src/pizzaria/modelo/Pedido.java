package pizzaria.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private int ped_num;
    private Entregador entregador;
    private Funcionario funcionario;
    private Cliente cliente;
    private Date ped_data;
    private List<ItemPedido> listapedido;

      public Pedido() {
    listapedido = new ArrayList<ItemPedido>();
  }
      
    public int getPed_num() {
        return ped_num;
    }

    public void setPed_num(int ped_num) {
        this.ped_num = ped_num;
    }

    public Entregador getEntregador() {
        return entregador;
    }

    public void setEntregador(Entregador entregador) {
        this.entregador = entregador;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Date getPed_data() {
        return ped_data;
    }

    public void setPed_data(Date ped_data) {
        this.ped_data = ped_data;
    }

    public List<ItemPedido> getListapedido() {
        return listapedido;
    }

    public void setListapedido(List<ItemPedido> listapedido) {
        this.listapedido = listapedido;
    }  
}
