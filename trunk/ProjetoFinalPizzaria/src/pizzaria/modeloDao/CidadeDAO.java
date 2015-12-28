package pizzaria.modeloDao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import pizzaria.controle.Conexao;
import pizzaria.modelo.Cidade;

public class CidadeDAO {

    private List<Cidade> lista = null;

    /** Incluir uma Nova estado ao Banco */
    public void incluir(Cidade cidade) throws Exception {
        try {
            String sql = "INSERT INTO cidade (CID_NOME,EST_UF,CID_ID) VALUES (?,?,?)";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            if (cidade.getCid_id() <= 0) {
                ps.setString(3, null);
            } else {
                ps.setInt(3, cidade.getCid_id());
            }
            ps.setString(1, cidade.getCid_nome());
            ps.setString(2, cidade.getEstado().getEst_uf());


            ps.executeUpdate();

            ResultSet rskey = ps.getGeneratedKeys();
            if (rskey.next()) {
                cidade.setCid_id(rskey.getInt(1));
            }
        } catch (Exception erro) {
            throw new Exception("Erro ao Incluir Cidade: " + erro.getMessage());
        }

    }

    public void alterar(Cidade cidade) throws Exception {
        try {
            String sql = "UPDATE cidade SET CID_NOME = ?, EST_UF=? WHERE CID_ID = ?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setString(1, cidade.getCid_nome());
            ps.setString(2, cidade.getEstado().getEst_uf());
            ps.setInt(3, cidade.getCid_id());

            ps.executeUpdate();
        } catch (Exception erro) {
            throw new Exception("Erro ao Alterar Cidade: " + erro.getMessage());
        }
    }

    public void excluir(Cidade cidade) throws Exception {
        try {
            String sql = "DELETE FROM cidade WHERE CID_ID= ?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, cidade.getCid_id());

            ps.executeUpdate();
        } catch (Exception erro) {
            throw new Exception("Erro ao Excluir cidade: " + erro.getMessage());
        }
    }

    /** Recuperar uma estado do Banco de Dados através de seu ID */
    public Cidade selecionarPorId(int id) throws Exception {
        try {
            String sql = "SELECT * FROM cidade WHERE CID_ID=?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            Cidade cidade = null;
            EstadoDAO estdao = new EstadoDAO();

            if (rs.next()) {
                cidade = new Cidade();

                cidade.setCid_id(rs.getInt("CID_ID"));
                cidade.setCid_nome(rs.getString("CID_NOME"));
                cidade.setEstado(estdao.selecionarPorUf(rs.getString("EST_UF")));
            }
            return cidade;
        } catch (Exception erro) {
            throw new Exception("Erro ao localizar Cidade: " + erro.getMessage());
        }
    }

    public List<Cidade> selecionarPorNome(String nome) throws Exception {
        try {
            String sql;
            if (nome != null && !nome.isEmpty()) {
                sql = "SELECT * FROM cidade WHERE CID_NOME LIKE ? ORDER BY CID_NOME";
            } else {
                sql = "SELECT * FROM cidade ORDER BY CID_NOME";
            }
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            if (ps.getParameterMetaData().getParameterCount() > 0) {
                ps.setString(1, nome + "%");
            }
            ResultSet rs = ps.executeQuery();

            preencheLista(rs);

            return getLista();
        } catch (Exception erro) {
            throw new Exception("Erro ao localizar Cidade pelo Nome: " + erro.getMessage());
        }

    }

    public List<Cidade> selecionarPorEstado(String uf, String nome) throws Exception {
        try {
            String sql = "SELECT * FROM cidade WHERE EST_UF = ? AND CID_NOME LIKE ? ORDER BY CID_NOME";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setString(1, uf);
            ps.setString(2, nome + "%");

            ResultSet rs = ps.executeQuery();
            Cidade cidade = null;
            EstadoDAO estdao = new EstadoDAO();
            lista = new ArrayList<Cidade>();
            while (rs.next()) {
                cidade = new Cidade();
                cidade.setCid_id(rs.getInt("CID_ID"));
                cidade.setCid_nome(rs.getString("CID_NOME"));
                cidade.setEstado(estdao.selecionarPorUf(rs.getString("EST_UF")));
                lista.add(cidade);
            }
            return lista;
        } catch (Exception erro) {
            throw new Exception("Erro ao localizar Cidade por Estado: " + erro.getMessage());
        }

    }

    private void preencheLista(ResultSet rs) throws Exception {
        try {
            lista = new ArrayList<Cidade>();
            EstadoDAO estdao = new EstadoDAO();
            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setCid_id(rs.getInt("CID_ID"));
                cidade.setCid_nome(rs.getString("CID_NOME"));
                cidade.setEstado(estdao.selecionarPorUf(rs.getString("EST_UF")));
                getLista().add(cidade);
            }
            return;
        } catch (Exception erro) {
            throw erro;
        }

    }

    public List<Cidade> getLista() {
        return lista;
    }
}
