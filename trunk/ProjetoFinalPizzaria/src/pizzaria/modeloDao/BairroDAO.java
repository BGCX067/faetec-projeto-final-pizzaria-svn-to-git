package pizzaria.modeloDao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import pizzaria.controle.Conexao;
import pizzaria.modelo.Bairro;

public class BairroDAO {


  private List<Bairro> lista = null;

  /** Incluir uma Nova estado ao Banco */
  public void incluir(Bairro bairro) throws Exception {
    try {
      String sql = "INSERT INTO bairro (BAI_NOME,BAI_ID,CID_ID) VALUES (?,?,?)";
      PreparedStatement ps = Conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

      if (bairro.getBai_Id() <= 0) {
        ps.setString(2, null);
      } else {
        ps.setInt(2, bairro.getBai_Id());
      }

      ps.setString(1, bairro.getBai_Nome());
      ps.setInt(3, bairro.getCidade().getCid_id());

      ps.executeUpdate();

      ResultSet rskey = ps.getGeneratedKeys();
      if (rskey.next()) {
        bairro.setBai_Id(rskey.getInt(1));
      }
    } catch (Exception erro) {
      throw new Exception("Erro ao Incluir Bairro: " + erro.getMessage());
    }

  }

  public void alterar(Bairro bairro) throws Exception {
    try {
      String sql = "UPDATE bairro SET BAI_NOME = ?, CID_ID=? WHERE BAI_ID = ?";
      PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

      ps.setString(1, bairro.getBai_Nome());
      ps.setInt(3, bairro.getCidade().getCid_id());
      ps.setInt(2, bairro.getBai_Id());

      ps.executeUpdate();
    } catch (Exception erro) {
      throw new Exception("Erro ao Alterar Bairro: " + erro.getMessage());
    }
  }

  public void excluir(Bairro bairro) throws Exception {
    try {
      String sql = "DELETE FROM bairro WHERE BAI_ID= ?";
      PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

      ps.setInt(1, bairro.getBai_Id());

      ps.executeUpdate();
    } catch (Exception erro) {
      throw new Exception("Erro ao Excluir bairro: " + erro.getMessage());
    }
  }

  /** Recuperar uma estado do Banco de Dados através de seu ID */
  public Bairro selecionarPorId(int id) throws Exception {
    try {
      String sql = "SELECT * FROM bairro WHERE BAI_ID=?";
      PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

      ps.setInt(1, id);

      ResultSet rs = ps.executeQuery();

      Bairro bairro = null;
      CidadeDAO cidadedao = new CidadeDAO();

      if (rs.next()) {
        bairro = new Bairro();

        bairro.setBai_Id(rs.getInt("BAI_ID"));
        bairro.setBai_Nome(rs.getString("BAI_NOME"));
        bairro.setCidade(cidadedao.selecionarPorId(rs.getInt("CID_ID")));
      }
      return bairro;
    } catch (Exception erro) {
      throw new Exception("Erro ao localizar Bairro: " + erro.getMessage());
    }
  }

  public List<Bairro> selecionarPorNome(String nome) throws Exception {
    try {
      String sql;
      if (nome != null && !nome.isEmpty()) {
        sql = "SELECT * FROM bairro WHERE BAI_NOME LIKE ? ORDER BY BAI_NOME";
      } else {
        sql = "SELECT * FROM bairro ORDER BY BAI_NOME";
      }
      PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
      if (ps.getParameterMetaData().getParameterCount() > 0) {
        ps.setString(1, nome + "%");
      }
      ResultSet rs = ps.executeQuery();

      preencheLista(rs);

      return getLista();
    } catch (Exception erro) {
      throw new Exception("Erro ao localizar Bairro pelo Nome: " + erro.getMessage());
    }

  }

  public List<Bairro> selecionarPorCidade(int id, String nome) throws Exception {
    try {
      String sql;
      sql = "SELECT * FROM bairro WHERE BAI_ID = ? and BAI_NOME LIKE ? ORDER BY BAI_NOME";
      PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
      ps.setInt(1, id);
      ps.setString(2, nome + "%");

      ResultSet rs = ps.executeQuery();

      preencheLista(rs);

      return getLista();
    } catch (Exception erro) {
      throw new Exception("Erro ao localizar Bairro por Cidade: " + erro.getMessage());
    }

  }

  private void preencheLista(ResultSet rs) throws Exception {
    try {
      lista = new ArrayList<Bairro>();
      CidadeDAO cidadedao = new CidadeDAO();
      while (rs.next()) {
        Bairro bairro = new Bairro();
        bairro.setBai_Id(rs.getInt("BAI_ID"));
        bairro.setBai_Nome(rs.getString("BAI_NOME"));
        bairro.setCidade(cidadedao.selecionarPorId(rs.getInt("CID_ID")));
        getLista().add(bairro);
      }
      return;
    } catch (Exception erro) {
      throw erro;
    }

  }

  public List<Bairro> getLista() {
    return lista;
  }
}
