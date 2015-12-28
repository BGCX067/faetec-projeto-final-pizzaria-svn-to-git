/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaria.modeloDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pizzaria.controle.Conexao;
import pizzaria.modelo.Entregador;

/**
 *
 * @author Administrador
 */
public class EntregadorDao {

    private List<Entregador> lista = null;

    /**Incluir um Novo Entregador ao Banco */
    public void incluir(Entregador entregador) throws Exception {
        try {
            String sql = "INSERT INTO ENTREGADOR (NOME, TELEFONE) VALUES (?, ?)";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            //ps.setInt(1, entregador.getEnt_cod());
            ps.setString(1, entregador.getNome());
            ps.setString(2, entregador.getTelefone());

            ps.executeUpdate(); /** executeUpdate só serve para comandos de atualiazação. */

        } catch (Exception erro) {
            erro.printStackTrace();
            throw new Exception("Erro ao Incluir Entregador: " + erro.getMessage());
        }
    }

    public void alterar(Entregador entregador) throws Exception {
        try {
            String sql = "UPDATE ENTREGADOR SET NOME = ?, TELEFONE = ? WHERE ENT_COD  = ?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setString(1, entregador.getNome());
            ps.setString(2, entregador.getTelefone());
            ps.setLong(3, entregador.getEnt_cod());

            ps.executeUpdate(); /** executeUpdate só serve para comandos de atualiazação. */

        } catch (Exception erro) {
            throw new Exception("Erro ao Alterar Entregador: " + erro.getMessage());
        }
    }

    public void excluir(Entregador entregador) throws Exception {
        try {
            String sql = "DELETE FROM ENTREGADOR WHERE ENT_COD = ?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setLong(1, entregador.getEnt_cod());

            ps.executeUpdate(); /** executeUpdate só serve para comandos de atualiazação. */

        } catch (Exception erro) {
            throw new Exception("Erro ao Excluir Entregador: " + erro.getMessage());
        }
    }

    /**Recuperar um Entregador do Banco através do seu Nome */
    public List<Entregador> selecionarPorNome(String Nome) throws Exception {
        try {
            String sql = "SELECT * FROM ENTREGADOR WHERE NOME LIKE ? ORDER BY NOME"; /** LIKE só funciona com String. */
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setString(1, Nome + "%");

            ResultSet rs = ps.executeQuery(); /** executeQuery só serve para comandos de consulta. */

            Entregador entregador = null;
            lista = new ArrayList<Entregador>();

            while (rs.next()) {
                entregador = new Entregador();

                entregador.setEnt_cod(rs.getInt("ent_cod"));
                entregador.setNome(rs.getString("nome"));
                entregador.setTelefone(rs.getString("telefone"));
                getLista().add(entregador);
            }
            return getLista();
        } catch (Exception erro) {
            throw new Exception("Erro ao Localizar Entregador por Nome: " + erro.getMessage());

        }
    }
    
    /**Recuperar um Entregador do Banco através de sua Id*/
    public Entregador selecionarPorCod(int Cod) throws Exception {
        try {
            String sql = "SELECT * FROM ENTREGADOR WHERE ENT_COD = ?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, Cod);

            ResultSet rs = ps.executeQuery(); /** executeQuery só serve para comandos de consulta. */

            Entregador entregador = null;

            if (rs.next()) {
                entregador = new Entregador();

                entregador.setEnt_cod(rs.getInt("ent_cod"));
                entregador.setNome(rs.getString("nome"));
                entregador.setTelefone(rs.getString("telefone"));

            }
            return entregador;
        } catch (Exception erro) {
            throw new Exception("Erro ao Localizar Entregador: " + erro.getMessage());

        }
    }
    
    public List<Entregador> getLista() {
        return lista;
    }
}