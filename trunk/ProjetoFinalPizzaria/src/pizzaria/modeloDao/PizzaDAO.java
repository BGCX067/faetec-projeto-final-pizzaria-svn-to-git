package pizzaria.modeloDao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import pizzaria.controle.Conexao;
import pizzaria.modelo.Bairro;
import pizzaria.modelo.Pizza;

public class PizzaDAO {


  private List<Pizza> lista = null;

  /** Incluir uma Nova estado ao Banco */
  public void incluir(Pizza pizza) throws Exception {
    try {
      String sql = "INSERT INTO pizza (piz_id,piz_desc,piz_sabor,piz_tam,piz_preco) VALUES (?,?,?,?,?)";
      PreparedStatement ps = Conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

      if (pizza.getPiz_id() <= 0) {
        ps.setString(1, null);
      } else {
        ps.setInt(1, pizza.getPiz_id());
      }

      ps.setString(2, pizza.getPiz_desc());
      ps.setString(3, pizza.getPiz_sabor());
      ps.setString(4, pizza.getPiz_tam());
      ps.setDouble(5, pizza.getPiz_preco());

      ps.executeUpdate();

      ResultSet rskey = ps.getGeneratedKeys();
      if (rskey.next()) {
        pizza.setPiz_id(rskey.getInt(1));
      }
    } catch (Exception erro) {
      throw new Exception("Erro ao Incluir pizza: " + erro.getMessage());
    }

  }

  public void alterar(Pizza pizza) throws Exception {
    try {
      String sql = "UPDATE pizza SET piz_desc =?, piz_sabor = ?, piz_tam = ?, piz_preco = ? WHERE piz_id = ?";
      PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

      ps.setString(1, pizza.getPiz_desc());
      ps.setString(2, pizza.getPiz_sabor());
      ps.setString(3, pizza.getPiz_tam());
      ps.setDouble(4, pizza.getPiz_preco());
      ps.setInt(5, pizza.getPiz_id());

      ps.executeUpdate();
    } catch (Exception erro) {
      throw new Exception("Erro ao Alterar pizza: " + erro.getMessage());
    }
  }

  public void excluir(Pizza pizza) throws Exception {
    try {
      String sql = "DELETE FROM pizza WHERE PIZ_ID= ?";
      PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

      ps.setInt(1, pizza.getPiz_id());

      ps.executeUpdate();
    } catch (Exception erro) {
      throw new Exception("Erro ao Excluir pizza: " + erro.getMessage());
    }
  }

  /** Recuperar uma estado do Banco de Dados através de seu ID */
  public Pizza selecionarPorId(int id) throws Exception {
    try {
      String sql = "SELECT * FROM pizza WHERE piz_id=?";
      PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

      ps.setInt(1, id);

      ResultSet rs = ps.executeQuery();

      Pizza pizza = null;

      if (rs.next()) {
        pizza = new Pizza();

        pizza.setPiz_id(rs.getInt("piz_id"));
        pizza.setPiz_desc(rs.getString("piz_desc"));
        pizza.setPiz_sabor(rs.getString("piz_sabor"));
        pizza.setPiz_tam(rs.getString("piz_tam"));
        pizza.setPiz_preco(rs.getDouble("piz_preco"));
      }
      return pizza;
    } catch (Exception erro) {
      throw new Exception("Erro ao localizar Pizza: " + erro.getMessage());
    }
  }

  public List<Pizza> selecionarPorNome(String nome) throws Exception {
    try {
      String sql;
      if (nome != null && !nome.isEmpty()) {
        sql = "SELECT * FROM pizza WHERE piz_desc LIKE ? ORDER BY piz_id";
      } else {
        sql = "SELECT * FROM pizza ORDER BY piz_id";
      }
      PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
      if (ps.getParameterMetaData().getParameterCount() > 0) {
        ps.setString(1, nome + "%");
      }
      ResultSet rs = ps.executeQuery();

      preencheLista(rs);

      return getLista();
    } catch (Exception erro) {
      throw new Exception("Erro ao localizar Pizza pelo Nome: " + erro.getMessage());
    }

  }

   private void preencheLista(ResultSet rs) throws Exception {
    try {
      lista = new ArrayList<Pizza>();
      while (rs.next()) {
        Pizza pizza = new Pizza();
        pizza.setPiz_id(rs.getInt("piz_id"));
        pizza.setPiz_desc(rs.getString("piz_desc"));
        pizza.setPiz_sabor(rs.getString("piz_sabor"));
        pizza.setPiz_tam(rs.getString("piz_tam"));
        pizza.setPiz_preco(rs.getDouble("piz_preco"));
        getLista().add(pizza);
      }
      return;
    } catch (Exception erro) {
      throw erro;
    }

  }

  public List<Pizza> getLista() {
    return lista;
  }
}
