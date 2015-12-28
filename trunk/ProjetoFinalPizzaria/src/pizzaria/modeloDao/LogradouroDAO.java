package pizzaria.modeloDao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import pizzaria.controle.Conexao;
import pizzaria.modelo.Logradouro;

public class LogradouroDAO {

  private List<Logradouro> lista = null;

  /** Incluir uma Nova estado ao Banco */
  public void incluir(Logradouro log) throws Exception {
    try {
      String sql = "INSERT INTO logradouro (log_id,bai_id,log_nome,tplogra_id,log_cep) VALUES (?,?,?,?,?)";
      PreparedStatement ps = Conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

      if (log.getLog_id() <= 0) {
        ps.setString(1, null);
      } else {
        ps.setInt(1, log.getLog_id());
      }
      ps.setInt(2, log.getBairro().getBai_Id());
      ps.setString(3, log.getLog_nome());
      ps.setInt(4, log.getTipolog().getTplogra_id());
      ps.setString(5, log.getLog_cep());

      ps.executeUpdate();
      ResultSet rs = ps.getGeneratedKeys();
      if (rs.next()) {
        log.setLog_id(rs.getInt(1));
      }

    } catch (Exception erro) {
      throw new Exception("Erro ao Incluir Logradouro: " + erro.getMessage());
    }

  }

  public void alterar(Logradouro log) throws Exception {
    try {
      String sql = "UPDATE Logradouro SET log_nome = ?, log_cep = ?, bai_id = ?, tplogra_id = ? WHERE log_id = ?";
      PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

      ps.setString(1, log.getLog_nome());
      ps.setString(2, log.getLog_cep());
      ps.setInt(3, log.getBairro().getBai_Id());
      ps.setInt(4, log.getTipolog().getTplogra_id());
      ps.setInt(5, log.getLog_id());

      ps.executeUpdate();
    } catch (Exception erro) {
      throw new Exception("Erro ao Alterar Logradouro: " + erro.getMessage());
    }
  }

  public void excluir(Logradouro log) throws Exception {
    try {
      String sql = "DELETE FROM Logradouro WHERE log_id= ?";
      PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

      ps.setInt(1, log.getLog_id());

      ps.executeUpdate();
    } catch (Exception erro) {
      throw new Exception("Erro ao Excluir Logradouro: " + erro.getMessage());
    }
  }

  /** Recuperar uma estado do Banco de Dados através de seu ID */
  public Logradouro selecionarPorId(int log_id) throws Exception {
    try {
      String sql = "SELECT * FROM Logradouro WHERE log_id=?";
      PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

      ps.setInt(1, log_id);

      ResultSet rs = ps.executeQuery();
      TipoLogDAO tpdao = new TipoLogDAO();
      BairroDAO baidao = new BairroDAO();

      Logradouro log = null;

      if (rs.next()) {
        log = new Logradouro();

        log.setLog_id(rs.getInt("log_id"));
        log.setLog_nome(rs.getString("log_nome"));
        log.setLog_cep(rs.getString("log_cep"));
        log.setTipolog(tpdao.selecionarPorId(rs.getInt("tplogra_id")));
        log.setBairro(baidao.selecionarPorId(rs.getInt("bai_id")));

      }
      return log;
    } catch (Exception erro) {
      throw new Exception("Erro ao localizar Logradouro por ID: " + erro.getMessage());
    }
  }

  public List<Logradouro> selecionarPorNome(String log_nome) throws Exception {
    try {
      String sql;
      if (log_nome != null && !log_nome.isEmpty()) {
        sql = "SELECT * FROM Logradouro WHERE log_nome LIKE ? ORDER BY log_nome";
      } else {
        sql = "SELECT * FROM Logradouro ORDER BY log_nome";
      }
      PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
      if (ps.getParameterMetaData().getParameterCount() > 0) {
        ps.setString(1, log_nome + "%");
      }
      ResultSet rs = ps.executeQuery();

      preencheLista(rs);

      return getLista();
    } catch (Exception erro) {
      throw new Exception("Erro ao localizar Logradouro por Nome: " + erro.getMessage());
    }

  }

  public List<Logradouro> getLista() {
    return lista;
  }

  public List<Logradouro> selecionarPorCEP(String log_cep) throws Exception {
    try {
      String sql;
      sql = "SELECT * FROM Logradouro WHERE log_cep = ? ORDER BY log_nome";
      PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
      ps.setString(1, log_cep);

      ResultSet rs = ps.executeQuery();

      preencheLista(rs);

      return getLista();
    } catch (Exception erro) {
      throw new Exception("Erro ao localizar Logradouro por CEP: " + erro.getMessage());
    }

  }

  public List<Logradouro> selecionarPorBairro(int bai_id, String log_nome) throws Exception {
    try {
      String sql;
      sql = "SELECT * FROM Logradouro WHERE bai_id=? and log_nome like ? ORDER BY log_nome";
      PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
      ps.setInt(1, bai_id);
      ps.setString(2, log_nome + "%");

      ResultSet rs = ps.executeQuery();

      preencheLista(rs);

      return getLista();
    } catch (Exception erro) {
      throw new Exception("Erro ao localizar Bairro: " + erro.getMessage());
    }

  }

  private void preencheLista(ResultSet rs) throws Exception {
    try {
      lista = new ArrayList<Logradouro>();
      TipoLogDAO tpdao = new TipoLogDAO();
      BairroDAO baidao = new BairroDAO();

      Logradouro log = null;

      while (rs.next()) {
        log = new Logradouro();

        log.setLog_id(rs.getInt("log_id"));
        log.setLog_nome(rs.getString("log_nome"));
        log.setLog_cep(rs.getString("log_cep"));
        log.setTipolog(tpdao.selecionarPorId(rs.getInt("tplogra_id")));
        log.setBairro(baidao.selecionarPorId(rs.getInt("bai_id")));

        getLista().add(log);
      }
      return;
    } catch (Exception erro) {
      throw erro;
    }

  }
}
