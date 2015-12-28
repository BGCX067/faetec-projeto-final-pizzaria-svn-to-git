package pizzaria.modeloDao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import pizzaria.controle.Conexao;
import pizzaria.modelo.TipoLog;



public class TipoLogDAO {

    private List<TipoLog> lista = null;

    /** Incluir uma Nova estado ao Banco */
    public void incluir(TipoLog tipoLog) throws Exception {
        try {
            String sql = "INSERT INTO tipo_log(tplogra_id,tplogra_descr) VALUES (?,?)";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            if (tipoLog.getTplogra_id() <= 0) {
              ps.setString(1, null);
            } else {
              ps.setInt(1, tipoLog.getTplogra_id());
            }
            ps.setString(2, tipoLog.getTplogra_descr());

            ps.executeUpdate();

            ResultSet rskey = ps.getGeneratedKeys();
            if (rskey.next()) {
              tipoLog.setTplogra_id(rskey.getInt(1));
            }
        } catch (Exception erro) {
            throw new Exception("Erro ao Incluir Tipo de Logradouro: " + erro.getMessage());
        }

    }

    public void alterar(TipoLog tipoLog) throws Exception {
        try {
            String sql = "UPDATE tipo_Log SET tplogra_descr = ?, WHERE tplogra_id = ?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setString(1, tipoLog.getTplogra_descr());
            ps.setInt(2, tipoLog.getTplogra_id());

            ps.executeUpdate();
        } catch (Exception erro) {
            throw new Exception("Erro ao Alterar Tipo de Logradouro: " + erro.getMessage());
        }
    }

    public void excluir(TipoLog tipoLog) throws Exception {
        try {
            String sql = "DELETE FROM tipo_Log WHERE tplogra_id= ?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, tipoLog.getTplogra_id());

            ps.executeUpdate();
        } catch (Exception erro) {
            throw new Exception("Erro ao Excluir Tipo de Logradouro: " + erro.getMessage());
        }
    }

    /** Recuperar uma estado do Banco de Dados através de seu ID */
    public TipoLog selecionarPorId(int tip_id) throws Exception {
        try {
            String sql = "SELECT * FROM tipo_Log WHERE tplogra_id=?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, tip_id);

            ResultSet rs = ps.executeQuery();

            TipoLog tipoLog = null;

            if (rs.next()) {
                tipoLog = new TipoLog();

                tipoLog.setTplogra_id(rs.getInt("tplogra_id"));
                tipoLog.setTplogra_descr(rs.getString("tplogra_descr"));
            }
            return tipoLog;
        } catch (Exception erro) {
            throw new Exception("Erro ao localizar Tipo de Logradouro: " + erro.getMessage());
        }
    }

    public List<TipoLog> selecionarPorNome(String tip_nome) throws Exception {
        try {
            String sql;
            if (tip_nome != null && !tip_nome.isEmpty()) {
                sql = "SELECT * FROM Tipo_Log WHERE tplogra_descr LIKE ? ORDER BY tplogra_descr";
            } else {
                sql = "SELECT * FROM Tipo_Log ORDER BY tplogra_descr";
            }
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            if (ps.getParameterMetaData().getParameterCount() > 0) {
                ps.setString(1, tip_nome + "%");
            }
            ResultSet rs = ps.executeQuery();

            preencheLista(rs);

            return getLista();
        } catch (Exception erro) {
            throw new Exception("Erro ao localizar Tipo de Logradouro: " + erro.getMessage());
        }

    }

    private void preencheLista(ResultSet rs) throws Exception {
         try {
            lista = new ArrayList<TipoLog>();
            while (rs.next()) {
                TipoLog tipoLog = new TipoLog();
                tipoLog.setTplogra_id(rs.getInt("tplogra_ID"));
                tipoLog.setTplogra_descr(rs.getString("tplogra_descr"));
                getLista().add(tipoLog);
            }
            return;
        } catch (Exception erro) {
            throw erro;
        }

    }

    public List<TipoLog> getLista() {
        return lista;
    }
}
