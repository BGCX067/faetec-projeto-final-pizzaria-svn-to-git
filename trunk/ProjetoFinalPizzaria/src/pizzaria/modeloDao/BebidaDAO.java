package pizzaria.modeloDao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import pizzaria.controle.Conexao;
import pizzaria.modelo.Bebida;

public class BebidaDAO {


  private List<Bebida> lista = null;

  /** Incluir uma Nova bebida ao Banco */
  public void incluir(Bebida bebida) throws Exception {
    try {
      String sql = "INSERT INTO bebida (beb_id,beb_desc,beb_preco,beb_tam) VALUES (?,?,?,?)";
      PreparedStatement ps = Conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

      if (bebida.getBeb_id() <= 0) {
        ps.setString(1, null);
      } else {
        ps.setInt(1, bebida.getBeb_id());
      }

      ps.setString(2, bebida.getBeb_desc());
      ps.setDouble(3, bebida.getBeb_preco());
      ps.setString(4, bebida.getBeb_tam());

      ps.executeUpdate();

      ResultSet rskey = ps.getGeneratedKeys();
      if (rskey.next()) {
       bebida.setBeb_id(rskey.getInt(1));
      }
    } catch (Exception erro) {
        erro.printStackTrace();
      throw new Exception("Erro ao Incluir Bebida: " + erro.getMessage());
    }

  }

  public void alterar(Bebida bebida) throws Exception {
    try {
      String sql = "UPDATE bebida SET beb_desc = ?, beb_preco = ?, beb_tam = ? WHERE beb_id = ?";
      PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

      ps.setString(1, bebida.getBeb_desc());
      ps.setDouble(2, bebida.getBeb_preco());
      ps.setString(3, bebida.getBeb_tam());
      ps.setInt(4, bebida.getBeb_id());

      ps.executeUpdate();
    } catch (Exception erro) {
      throw new Exception("Erro ao Alterar bebida: " + erro.getMessage());
    }
  }

  public void excluir(Bebida bebida) throws Exception {
    try {
      String sql = "DELETE FROM bebida WHERE beb_id = ?";
      PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

      ps.setInt(1, bebida.getBeb_id());

      ps.executeUpdate();
    } catch (Exception erro) {
      throw new Exception("Erro ao Excluir bebida: " + erro.getMessage());
    }
  }

  /** Recuperar uma estado do Banco de Dados através de seu ID */
  public Bebida selecionarPorId(int id) throws Exception {
    try {
      String sql = "SELECT * FROM bebida WHERE beb_id =?";
      PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

      ps.setInt(1, id);

      ResultSet rs = ps.executeQuery();

      Bebida bebida = null;
      
      if (rs.next()) {
        bebida = new Bebida();

        bebida.setBeb_id(rs.getInt("beb_id"));
        bebida.setBeb_desc(rs.getString("beb_desc"));
        bebida.setBeb_preco(rs.getDouble("beb_preco"));
        bebida.setBeb_tam(rs.getString("beb_tam"));
      }
      return bebida;
    } catch (Exception erro) {
      throw new Exception("Erro ao localizar Bebida: " + erro.getMessage());
    }
  }

  public List<Bebida> selecionarPorNome(String nome) throws Exception {
    try {
      String sql;
      if (nome != null && !nome.isEmpty()) {
        sql = "SELECT * FROM bebida WHERE beb_desc LIKE ? ORDER BY beb_desc";
      } else {
        sql = "SELECT * FROM bebida ORDER BY beb_desc";
      }
      PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
      if (ps.getParameterMetaData().getParameterCount() > 0) {
        ps.setString(1, nome + "%");
      }
      ResultSet rs = ps.executeQuery();

      preencheLista(rs);

      return getLista();
    } catch (Exception erro) {
      throw new Exception("Erro ao localizar bebida pelo Nome: " + erro.getMessage());
    }

  }

  private void preencheLista(ResultSet rs) throws Exception {
    try {
      lista = new ArrayList<Bebida>();
      while (rs.next()) {
        Bebida bebida = new Bebida();
        bebida.setBeb_id(rs.getInt("beb_id"));
        bebida.setBeb_desc(rs.getString("beb_desc"));
        bebida.setBeb_preco(rs.getDouble("beb_preco"));
        bebida.setBeb_tam(rs.getString("beb_tam"));
        getLista().add(bebida);
      }
      return;
    } catch (Exception erro) {
      throw erro;
    }

  }

  public List<Bebida> getLista() {
    return lista;
  }
}
