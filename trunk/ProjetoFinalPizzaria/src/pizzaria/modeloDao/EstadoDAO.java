package pizzaria.modeloDao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import pizzaria.controle.Conexao;
import pizzaria.modelo.Estado;

public class EstadoDAO {

    private List<Estado> lista = null;

    /** Incluir uma Nova estado ao Banco */
    public void incluir(Estado estado) throws Exception {
        try {
            String sql = "INSERT INTO estado (EST_UF,EST_NOME) VALUES (?,?)";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setString(1, estado.getEst_uf());
            ps.setString(2, estado.getEst_nome());

            ps.executeUpdate();
        } catch (Exception erro) {
            throw new Exception("Erro ao Incluir Estado: " + erro.getMessage());
        }

    }

    public void alterar(Estado estado) throws Exception {
        try {
            String sql = "UPDATE estado SET EST_NOME = ? WHERE EST_UF = ?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setString(1, estado.getEst_uf());
            ps.setString(2, estado.getEst_nome());

            ps.executeUpdate();
        } catch (Exception erro) {
            throw new Exception("Erro ao Alterar Estado: " + erro.getMessage());
        }
    }

    public void excluir(Estado estado) throws Exception {
        try {
            String sql = "DELETE FROM estado WHERE EST_UF= ?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setString(1, estado.getEst_uf());

            ps.executeUpdate();
        } catch (Exception erro) {
            throw new Exception("Erro ao Excluir estado: " + erro.getMessage());
        }
    }

    /** Recuperar uma estado do Banco de Dados através de seu ID */
    public Estado selecionarPorUf(String uf) throws Exception {
        try {
            String sql = "SELECT * FROM estado WHERE EST_UF=?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setString(1, uf);

            ResultSet rs = ps.executeQuery();

            Estado estado = null;

            if (rs.next()) {
                estado = new Estado();

                estado.setEst_uf(rs.getString("EST_UF"));
                estado.setEst_nome(rs.getString("EST_NOME"));
            }
            return estado;
        } catch (Exception erro) {
            throw new Exception("Erro ao localizar Estado: " + erro.getMessage());
        }
    }

    public List<Estado> selecionarPorNome(String nome) throws Exception {
        try {
            String sql;
            if (nome != null && !nome.isEmpty()) {
                sql = "SELECT * FROM estado WHERE EST_NOME LIKE ? ORDER BY EST_NOME";
            } else {
                sql = "SELECT * FROM estado ORDER BY EST_NOME";
            }
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            if (ps.getParameterMetaData().getParameterCount() > 0) {
                ps.setString(1, nome + "%");
            }
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Estado>();

            while (rs.next()) {
                Estado estado = new Estado();

                estado.setEst_uf(rs.getString("EST_UF"));
                estado.setEst_nome(rs.getString("EST_NOME"));

                getLista().add(estado);
            }
            return getLista();
        } catch (Exception erro) {
            throw new Exception("Erro ao localizar estado pelo Nome: " + erro.getMessage());
        }

    }

    public List<Estado> getLista() {
        return lista;
    }
}
