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
import pizzaria.modelo.Funcionario;

/**
 *
 * @author Administrador
 */
public class FuncionarioDao {

    private List<Funcionario> lista = null;

    /**Incluir um Novo Funcionario ao Banco */
    public void incluir(Funcionario funcionario) throws Exception {
        try {
            String sql = "INSERT INTO FUNCIONARIO (FUN_NOME, FUN_TEL) VALUES (?, ?)";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            //ps.setInt(1, funcionario.getFun_mat());
            ps.setString(1, funcionario.getFun_nome());
            ps.setString(2, funcionario.getFun_tel());

            ps.executeUpdate();
            /** executeUpdate só serve para comandos de atualiazação. */
        } catch (Exception erro) {
            erro.printStackTrace();
            throw new Exception("Erro ao Incluir Funcionario: " + erro.getMessage());
        }
    }

    public void alterar(Funcionario funcionario) throws Exception {
        try {
            String sql = "UPDATE FUNCIONARIO SET FUN_NOME = ?, FUN_TEL = ? WHERE FUN_MAT  = ?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setString(1, funcionario.getFun_nome());
            ps.setString(2, funcionario.getFun_tel());
            ps.setInt(3, funcionario.getFun_mat());

            ps.executeUpdate();
            /** executeUpdate só serve para comandos de atualiazação. */
        } catch (Exception erro) {
            throw new Exception("Erro ao Alterar Funcionario: " + erro.getMessage());
        }
    }

    public void excluir(Funcionario funcionario) throws Exception {
        try {
            String sql = "DELETE FROM FUNCIONARIO WHERE FUN_MAT = ?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, funcionario.getFun_mat());

            ps.executeUpdate();
            /** executeUpdate só serve para comandos de atualiazação. */
        } catch (Exception erro) {
            throw new Exception("Erro ao Excluir Funcionario: " + erro.getMessage());
        }
    }

    /**Recuperar um Entregador do Banco através do seu Nome */
    public List<Funcionario> selecionarPorNome(String Nome) throws Exception {
        try {
            String sql = "SELECT * FROM FUNCIONARIO WHERE FUN_NOME LIKE ? ORDER BY FUN_NOME";
            /** LIKE só funciona com String. */
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setString(1, Nome + "%");

            ResultSet rs = ps.executeQuery();
            /** executeQuery só serve para comandos de consulta. */
            Funcionario funcionario = null;
            lista = new ArrayList<Funcionario>();

            while (rs.next()) {
                funcionario = new Funcionario();

                funcionario.setFun_mat(rs.getInt("fun_mat"));
                funcionario.setFun_nome(rs.getString("fun_nome"));
                funcionario.setFun_tel(rs.getString("fun_tel"));
                getLista().add(funcionario);
            }
            return getLista();
        } catch (Exception erro) {
            throw new Exception("Erro ao Localizar Funcionario por Nome: " + erro.getMessage());

        }
    }

    /**Recuperar um Entregador do Banco através de sua Id*/
    public Funcionario selecionarPorCod(int Cod) throws Exception {
        try {
            String sql = "SELECT * FROM FUNCIONARIO WHERE FUN_MAT = ?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, Cod);

            ResultSet rs = ps.executeQuery();
            /** executeQuery só serve para comandos de consulta. */
            Funcionario funcionario = null;

            if (rs.next()) {
                funcionario = new Funcionario();

                funcionario.setFun_mat(rs.getInt("fun_mat"));
                funcionario.setFun_nome(rs.getString("fun_nome"));
                funcionario.setFun_tel(rs.getString("fun_tel"));

            }
            return funcionario;
        } catch (Exception erro) {
            throw new Exception("Erro ao Localizar Funcionario: " + erro.getMessage());

        }
    }

    public List<Funcionario> getLista() {
        return lista;
    }
}
