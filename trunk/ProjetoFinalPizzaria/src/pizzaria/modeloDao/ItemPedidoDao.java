package pizzaria.modeloDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pizzaria.controle.Conexao;
import pizzaria.modelo.ItemPedido;

public class ItemPedidoDao {

    private List<ItemPedido> lista = null;

    /** Incluir uma Nova estado ao Banco */
    public void incluir(ItemPedido itemPedido) throws Exception {
        try {
            String sql = "INSERT INTO item_pedido (ped_num,beb_id,piz_id,quantidade,valor_total,itp_preco) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, itemPedido.getPed_num());
            if (itemPedido.getBebida() == null) {
                ps.setInt(2, 0);
            } else {
                ps.setInt(2, itemPedido.getBebida().getBeb_id());
            }
            if (itemPedido.getPizza() == null) {
                ps.setInt(3, 0);
            } else {
                ps.setInt(3, itemPedido.getPizza().getPiz_id());
            }
            ps.setInt(4, itemPedido.getQuantidade());
            ps.setDouble(5, itemPedido.getValor_total());
            ps.setDouble(6, itemPedido.getItp_preco());
            ps.executeUpdate();

        } catch (Exception erro) {
            erro.printStackTrace();
            throw new Exception("Erro ao Incluir Item Pedido: " + erro.getMessage());
        }

    }

    public void alterar(ItemPedido itemPedido) throws Exception {
        try {
            String sql = "UPDATE item_pedido SET beb_ID = ? AND piz_id = ? AND quantidade = ? AND valor_total = ? AND itp_preco = ? WHERE ped_num = ? ";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, itemPedido.getPed_num());
            if (itemPedido.getBebida() == null) {
                ps.setInt(2, 0);
            } else {
                ps.setInt(2, itemPedido.getBebida().getBeb_id());
            }
            if (itemPedido.getPizza() == null) {
                ps.setInt(3, 0);
            } else {
                ps.setInt(3, itemPedido.getPizza().getPiz_id());
            }
            ps.setInt(4, itemPedido.getQuantidade());
            ps.setDouble(5, itemPedido.getValor_total());
            ps.setDouble(6, itemPedido.getItp_preco());

            ps.executeUpdate();

        } catch (Exception erro) {
            throw new Exception("Erro ao Alterar Item_Pedido: " + erro.getMessage());
        }
    }

    public void excluir(ItemPedido itemPedido) throws Exception {
        try {
            String sql = "DELETE FROM item_pedido WHERE PED_NUM=?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, itemPedido.getPed_num());

            ps.executeUpdate();

        } catch (Exception erro) {
            throw new Exception("Erro ao Excluir Item_Pedido: " + erro.getMessage());
        }
    }

    public void excluirProd(ItemPedido itemPedido) throws Exception {
        try {
            if (itemPedido.getBebida() != null) {
                String sql = "DELETE FROM item_pedido WHERE BEB_ID = ? and PED_NUM = ?";
                PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

                ps.setInt(1, itemPedido.getBebida().getBeb_id());
                ps.setInt(2, itemPedido.getPed_num());

                ps.executeUpdate();
            } else if (itemPedido.getPizza() != null) {
                String sql = "DELETE FROM item_pedido WHERE PIZ_ID = ? and PED_NUM = ?";
                PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

                ps.setInt(1, itemPedido.getPizza().getPiz_id());
                ps.setInt(2, itemPedido.getPed_num());

                ps.executeUpdate();
            }
        } catch (Exception erro) {
            throw new Exception("Erro ao Excluir Item_Pedido: " + erro.getMessage());
        }
    }

    public List<ItemPedido> selecionarPorPedido(int ped_num) throws Exception {
        try {
            String sql = "SELECT * FROM item_pedido WHERE ped_num=?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, ped_num);

            ResultSet rs = ps.executeQuery();

            preencheLista(rs);

            return lista;
        } catch (Exception erro) {
            throw new Exception("Erro ao localizar Pedido: " + erro.getMessage());
        }
    }

    private void preencheLista(ResultSet rs) throws Exception {
        try {
            lista = new ArrayList<ItemPedido>();
            //PedidoDao pedidao = new PedidoDao();
            BebidaDAO bebiDao = new BebidaDAO();
            PizzaDAO pizzaDao = new PizzaDAO();
            while (rs.next()) {
                ItemPedido itemPed = new ItemPedido();
                itemPed.setPed_num(rs.getInt("ped_num"));
                itemPed.setBebida(bebiDao.selecionarPorId(rs.getInt("beb_id")));
                itemPed.setPizza(pizzaDao.selecionarPorId(rs.getInt("piz_id")));
                itemPed.setQuantidade(rs.getInt("quantidade"));
                itemPed.setValor_total(rs.getDouble("valor_total"));
                itemPed.setItp_preco(rs.getDouble("itp_preco"));

                getLista().add(itemPed);
            }
            return;
        } catch (Exception erro) {
            erro.printStackTrace();
            throw erro;
        }

    }

    public List<ItemPedido> getLista() {
        return lista;
    }
}
