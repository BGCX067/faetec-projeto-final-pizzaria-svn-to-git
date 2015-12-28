package pizzaria.modeloDao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import pizzaria.controle.Conexao;
import pizzaria.modelo.Login;

public class LoginDAO {

    private List<Login> lista = null;

    /** Incluir uma Nova Pessoa ao Banco */
    public void incluir(Login login) throws Exception {
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO AUTENTICACAO (AUT_USUARIO, AUT_SENHA, AUT_ACESSO) " +
                    "VALUES ( ?, ?, ?)";

            ps = Conexao.getConexao().prepareStatement(sql);
            // Auto Increment

            ps.setString(1, login.getAut_usuario());
            ps.setString(2, login.getAut_senha());
            ps.setString(3, login.getAut_acesso());


            ps.executeUpdate();
           

        } catch (Exception erro) {
            throw new Exception("Erro ao Incluir Login: " + erro.getMessage());
        }
    }

    public void alterar(Login login) throws Exception {
        PreparedStatement ps = null;
        try {
            String sql = "UPDATE AUTENTICACAO SET AUT_SENHA=?, AUT_ACESSO=? WHERE AUT_USUARIO = ?";

            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(3, login.getAut_usuario());
            ps.setString(1, login.getAut_senha());
            ps.setString(2, login.getAut_acesso());


            ps.executeUpdate();


        } catch (Exception erro) {
            throw new Exception("Erro ao Alterar Login: " + erro.getMessage());
        }

    }

    public void excluir(Login login) throws Exception {
        PreparedStatement ps = null;
        try {
            String sql = "DELETE FROM AUTENTICACAO WHERE AUT_USUARIO = ?";
            ps = Conexao.getConexao().prepareStatement(sql);

            ps.setString(1, login.getAut_usuario());
            ps.executeUpdate();

        } catch (Exception erro) {
            throw new Exception("Erro ao Excluir Pessoa: " + erro.getMessage());
        }

    }

    /** Recuperar uma Pessoa do Banco de Dados através de seu ID */
    public List<Login> selecionarPorUsuario(String usuario) throws Exception {
        PreparedStatement ps = null;
        try {
            String sql;
            if (usuario != null && !usuario.isEmpty()) {
                sql = "SELECT * FROM AUTENTICACAO WHERE AUT_USUARIO LIKE ? ORDER BY AUT_USUARIO";
            } else {
                sql = "SELECT * FROM AUTENTICACAO ORDER BY AUT_USUARIO";
            }

            ps = Conexao.getConexao().prepareStatement(sql);

            if (ps.getParameterMetaData().getParameterCount() > 0) {
                ps.setString(1, usuario + "%");
            }

            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Login>();

            Login login = null;

            while (rs.next()) {
                login = new Login();

                login.setAut_usuario(rs.getString("AUT_USUARIO"));
                login.setAut_senha(rs.getString("AUT_SENHA"));
                login.setAut_acesso(rs.getString("AUT_ACESSO"));

                lista.add(login);

            }

            return lista;

        } catch (Exception erro) {
            throw new Exception("Erro ao Localizar Login Por Usuário: " + erro.getMessage());
        }

    }

    public Login validaLogin(String usuario, String senha) throws Exception {
        try {
            String sql = "SELECT * FROM autenticacao WHERE aut_usuario = ? and aut_senha = ?";

            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();

            Login login = null;
            if (rs.next()) {
                login = new Login();
                login.setAut_usuario(rs.getString("AUT_USUARIO"));
                login.setAut_senha(rs.getString("AUT_SENHA"));
                login.setAut_acesso(rs.getString("AUT_ACESSO"));
            }
            return login;
        } catch (SQLException ex) {
            throw new Exception("Login Inexistente", ex);
        }
    }

    public List<Login> getLista() {
        return lista;
    }
}
