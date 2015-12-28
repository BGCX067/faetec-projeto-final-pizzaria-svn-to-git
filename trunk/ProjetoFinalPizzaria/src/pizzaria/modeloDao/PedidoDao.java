package pizzaria.modeloDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pizzaria.controle.Conexao;
import pizzaria.modelo.ItemPedido;
import pizzaria.modelo.Pedido;
import pizzaria.modelo.Venda;

public class PedidoDao {

    private List<Pedido> lista = null;

    /** Incluir uma Nova estado ao Banco */
    public void incluir(Pedido pedido) throws Exception {
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO PEDIDO (ped_num, ent_cod, fun_mat, cli_id, ped_data) VALUES (?, ?, ?, ?, ?)";
            ps = Conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.getConnection().setAutoCommit(false);

            if (pedido.getPed_num() <= 0) {
                ps.setString(1, null);
            } else {
                ps.setInt(1, pedido.getPed_num());
            }

            ps.setInt(2, pedido.getEntregador().getEnt_cod());
            ps.setInt(3, pedido.getFuncionario().getFun_mat());
            ps.setInt(4, pedido.getCliente().getCli_id());
            ps.setDate(5, new java.sql.Date(pedido.getPed_data().getTime()));

            ps.executeUpdate();

            ResultSet rskey = ps.getGeneratedKeys();
            if (rskey.next()) {
                pedido.setPed_num(rskey.getInt(1));
            }

            // Gravar os Itens do Pedido
            Iterator<ItemPedido> itemPed = pedido.getListapedido().iterator();
            ItemPedido tmpItem;
            ItemPedidoDao itemPedDao = new ItemPedidoDao();

            while (itemPed.hasNext()) {
                tmpItem = itemPed.next();
                tmpItem.setPed_num(pedido.getPed_num());
                itemPedDao.incluir(tmpItem);
            }
            ps.getConnection().commit(); // Confirmar atualizações
        } catch (Exception erro) {
            erro.printStackTrace();
            ps.getConnection().rollback(); // Desfazer atualizações
            throw new Exception("Erro ao Incluir Pedido: " + erro.getMessage());
        } finally {
            ps.getConnection().setAutoCommit(true);
        }

    }

    public void alterar(Pedido pedido) throws Exception {
        PreparedStatement ps = null;
        try {
            String sql = "UPDATE PEDIDO SET  ent_cod = ?, fun_mat = ?, cli_id = ?, ped_data = ?"
                    + "WHERE ped_num = ?";
            ps = Conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.getConnection().setAutoCommit(false);

            ps.setInt(1, pedido.getEntregador().getEnt_cod());
            ps.setInt(2, pedido.getFuncionario().getFun_mat());
            ps.setInt(3, pedido.getCliente().getCli_id());
            if (pedido.getPed_data() == null) {
                ps.setDate(4, null);
            } else {
                ps.setDate(4, new java.sql.Date(pedido.getPed_data().getTime()));
            }
            if (pedido.getPed_num() <= 0) {
                ps.setString(5, null);
            } else {
                ps.setInt(5, pedido.getPed_num());
            }

            ps.executeUpdate();

            // Gravar os Itens da Pedido
            Iterator<ItemPedido> itemPed = pedido.getListapedido().iterator();
            ItemPedido tmpItem;
            ItemPedidoDao itemPedDao = new ItemPedidoDao();

            while (itemPed.hasNext()) {
                tmpItem = itemPed.next();
                tmpItem.setPed_num(pedido.getPed_num());

                if (tmpItem.getOperacao() == 'A') {
                    itemPedDao.alterar(tmpItem);
                } else if (tmpItem.getOperacao() == 'P' || tmpItem.getOperacao() == 'B') {
                    itemPedDao.incluir(tmpItem);
                } else if (tmpItem.getOperacao() == 'P' || tmpItem.getOperacao() == 'B') {
                    itemPedDao.incluir(tmpItem);
                }
            }
            ps.getConnection().commit(); // Confirmar atualizações
        } catch (Exception erro) {
            ps.getConnection().rollback(); // Desfazer atualizações
            throw new Exception("Erro ao Alterar Pedido: " + erro.getMessage());
        } finally {
            ps.getConnection().setAutoCommit(true);
        }
    }

    public void excluir(Pedido pedido) throws Exception {
        PreparedStatement ps = null;
        try {
            // ps.getConnection().setAutoCommit(false);

            // Gravar os Itens da Locacao
            Iterator<ItemPedido> itemPed = pedido.getListapedido().iterator();
            ItemPedido tmpItem;
            ItemPedidoDao itemPedDao = new ItemPedidoDao();

            while (itemPed.hasNext()) {
                tmpItem = itemPed.next();
                tmpItem.setPed_num(pedido.getPed_num());
                itemPedDao.excluir(tmpItem);
            }

            String sql = "DELETE FROM PEDIDO WHERE PED_NUM = ?";
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, pedido.getPed_num());

            ps.executeUpdate();

            // ps.getConnection().commit(); // Confirmar atualizações
        } catch (Exception erro) {
            //  ps.getConnection().rollback(); // Desfazer atualizações
            throw new Exception("Erro ao Excluir Pedido: " + erro.getMessage());
        } finally {
            // ps.getConnection().setAutoCommit(true);
        }
    }

    public Pedido selecionarPorId(int id) throws Exception {
        try {
            String sql = "SELECT * FROM pedido WHERE ped_num = ?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            FuncionarioDao funDao = new FuncionarioDao();
            EntregadorDao entreDao = new EntregadorDao();
            ClienteDAO cliDao = new ClienteDAO();
            ItemPedidoDao itemPedDao = new ItemPedidoDao();
            Pedido pedido = null;

            if (rs.next()) {
                pedido = new Pedido();
                pedido.setPed_num(rs.getInt("ped_num"));
                pedido.setEntregador(entreDao.selecionarPorCod(rs.getInt("ent_cod")));
                pedido.setFuncionario(funDao.selecionarPorCod(rs.getInt("fun_mat")));
                pedido.setCliente(cliDao.selecionarPorID(rs.getInt("cli_id")));
                pedido.setPed_data(rs.getDate("ped_data"));
                pedido.setListapedido(itemPedDao.selecionarPorPedido(rs.getInt("ped_num")));
            }
            return pedido;
        } catch (Exception erro) {
            throw new Exception("Erro ao localizar Pedido: " + erro.getMessage());
        }
    }

    public List<Pedido> selecionarPorPedido(int ped_num) throws Exception {
        try {
            String sql = "SELECT * FROM pedido WHERE ped_num = ?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, ped_num);

            ResultSet rs = ps.executeQuery();

            preencheLista(rs);

            return lista;
        } catch (Exception erro) {
            throw new Exception("Erro ao localizar Pedido: " + erro.getMessage());
        }
    }

    public List<Pedido> selecionarPorCliente(String nome) throws Exception {
        try {
            String sql;
            if (nome != null && !nome.isEmpty()) {
                sql = "SELECT * FROM pedido p, cliente c WHERE p.cli_id = c.cli_id and cli_nome like ? ORDER BY ped_num";
            } else {
                sql = "SELECT * FROM pedido ORDER BY ped_num";
            }
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            if (ps.getParameterMetaData().getParameterCount() > 0) {
                ps.setString(1, nome + "%");
            }
            ResultSet rs = ps.executeQuery();

            preencheLista(rs);

            return lista;
        } catch (Exception erro) {
            throw new Exception("Erro ao localizar Pedido: " + erro.getMessage());
        }
    }

    private void preencheLista(ResultSet rs) throws Exception {
        try {
            lista = new ArrayList<Pedido>();
            FuncionarioDao funDao = new FuncionarioDao();
            EntregadorDao entreDao = new EntregadorDao();
            ClienteDAO cliDao = new ClienteDAO();
            ItemPedidoDao itemPedDao = new ItemPedidoDao();
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setPed_num(rs.getInt("ped_num"));
                pedido.setFuncionario(funDao.selecionarPorCod(rs.getInt("fun_mat")));
                pedido.setEntregador(entreDao.selecionarPorCod(rs.getInt("ent_cod")));
                pedido.setCliente(cliDao.selecionarPorID(rs.getInt("cli_id")));
                pedido.setPed_data(rs.getDate("ped_data"));
                pedido.setListapedido(itemPedDao.selecionarPorPedido(rs.getInt("ped_num")));
                getLista().add(pedido);
            }
            return;
        } catch (Exception erro) {
            throw erro;
        }

    }

    public List<Pedido> getLista() {
        return lista;
    }
}
