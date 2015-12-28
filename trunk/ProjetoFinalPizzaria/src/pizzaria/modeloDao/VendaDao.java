package pizzaria.modeloDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pizzaria.controle.Conexao;
import pizzaria.modelo.Venda;

public class VendaDao {

    private List<Venda> lista = null;

    /** Incluir uma Nova estado ao Banco */
    public void incluir(Venda venda) throws Exception {
        try {
            String sql = "INSERT INTO venda (fun_mat, ped_num) VALUES (?,?)";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

         /*  if (venda.getVenda_id() <= 0) {
                ps.setString(1, null);
            } else {
                ps.setInt(1, venda.getVenda_id());
            }*/

            ps.setInt(1, venda.getFuncionario().getFun_mat());
            ps.setInt(2, venda.getPedido().getPed_num());

            ps.executeUpdate();

         /*   ResultSet rskey = ps.getGeneratedKeys();
            if (rskey.next()) {
                venda.setVenda_id(rskey.getInt(1));
            }*/
        } catch (Exception erro) {
            throw new Exception("Erro ao Incluir venda: " + erro.getMessage());
        }

    }

    public void alterar(Venda venda) throws Exception {
        try {
            String sql = "UPDATE venda SET venda_id =?, fun_mat = ? WHERE ped_num = ?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, venda.getVenda_id());
            ps.setInt(2, venda.getFuncionario().getFun_mat());
            ps.setInt(3, venda.getPedido().getPed_num());

            ps.executeUpdate();
        } catch (Exception erro) {
            throw new Exception("Erro ao Alterar venda: " + erro.getMessage());
        }
    }

    public void excluir(Venda venda) throws Exception {
        try {
            String sql = "DELETE FROM venda WHERE venda_id = ?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, venda.getVenda_id());

            ps.executeUpdate();
        } catch (Exception erro) {
            throw new Exception("Erro ao Excluir venda: " + erro.getMessage());
        }
    }

    /** Recuperar uma estado do Banco de Dados através de seu ID */
    public Venda selecionarPorId(int id) throws Exception {
        try {
            String sql = "SELECT * FROM venda WHERE venda_id =?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            FuncionarioDao funDao = new FuncionarioDao();
            PedidoDao pedDao = new PedidoDao();
            Venda venda = null;

            if (rs.next()) {
                venda = new Venda();

                venda.setVenda_id(rs.getInt("venda_id"));
                venda.setFuncionario(funDao.selecionarPorCod(rs.getInt("fun_mat")));
                venda.setPedido(pedDao.selecionarPorId(rs.getInt("ped_num")));
            }
            return venda;
        } catch (Exception erro) {
            throw new Exception("Erro ao localizar Venda: " + erro.getMessage());
        }
    }

    public List<Venda> selecionarPorFunc(String nome) throws Exception {
        try {
            String sql;
            if (nome != null && !nome.isEmpty()) {
                sql = "SELECT * FROM venda v,funcionario f where v.fun_mat = f.fun_mat and fun_nome LIKE concat(?,'%') ORDER BY ped_num";
            } else {
                sql = "SELECT * FROM venda ORDER BY ped_num";
            }
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            if (ps.getParameterMetaData().getParameterCount() > 0) {
                ps.setString(1, nome);
            }
            ResultSet rs = ps.executeQuery();

            preencheLista(rs);

            return getLista();
        } catch (Exception erro) {
            throw new Exception("Erro ao localizar Venda pelo Nome: " + erro.getMessage());
        }

    }

    private void preencheLista(ResultSet rs) throws Exception {
        try {
            lista = new ArrayList<Venda>();
            FuncionarioDao funDao = new FuncionarioDao();
            PedidoDao pedDao = new PedidoDao();
            while (rs.next()) {
                Venda venda = new Venda();
                venda.setVenda_id(rs.getInt("venda_id"));
                venda.setFuncionario(funDao.selecionarPorCod(rs.getInt("fun_mat")));
                venda.setPedido(pedDao.selecionarPorId(rs.getInt("ped_num")));
                getLista().add(venda);
            }
            return;
        } catch (Exception erro) {
            throw erro;
        }

    }

    public List<Venda> getLista() {
        return lista;
    }
}
