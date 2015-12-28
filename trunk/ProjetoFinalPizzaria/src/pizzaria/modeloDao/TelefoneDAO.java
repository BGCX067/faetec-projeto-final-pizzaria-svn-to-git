package pizzaria.modeloDao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import pizzaria.controle.Conexao;
import pizzaria.modelo.Telefone;

public class TelefoneDAO {

    private List<Telefone> lista = null;

    /** Incluir uma Nova estado ao Banco */
    public void incluir(Telefone telefone) throws Exception {
        try {
            String sql = "INSERT INTO telefone (TEL_TELEFONE,cli_id) VALUES (?,?)";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, telefone.getTel_numero());
            ps.setInt(2, telefone.getCliente());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                telefone.setTel_id(rs.getInt(1));
                telefone.setStatus('A');
            }
        } catch (Exception erro) {
            throw new Exception("Erro ao Incluir Telefone: " + erro.getMessage());
        }

    }

    public void alterar(Telefone telefone) throws Exception {
        try {
            String sql = "UPDATE telefone SET TEL_TELEFONE = ?, CLI_ID=? WHERE TEL_ID = ?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setString(1, telefone.getTel_numero());
            ps.setInt(2, telefone.getTel_id());
            ps.setInt(3, telefone.getCliente());

            ps.executeUpdate();
        } catch (Exception erro) {
            throw new Exception("Erro ao Alterar Telefone: " + erro.getMessage());
        }
    }

    public void excluir(Telefone telefone) throws Exception {
        try {
            String sql = "DELETE FROM telefone WHERE TEL_ID= ?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, telefone.getTel_id());

            ps.executeUpdate();
        } catch (Exception erro) {
            throw new Exception("Erro ao Excluir Telefone: " + erro.getMessage());
        }
    }

    /** Recuperar uma estado do Banco de Dados através de seu ID */
    public Telefone selecionarPorId(int id) throws Exception {
        try {
            String sql = "SELECT * FROM telefone WHERE TEL_ID=?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            Telefone telefone = null;

            if (rs.next()) {
                telefone = new Telefone();

                telefone.setTel_id(rs.getInt("TEL_ID"));
                telefone.setTel_numero(rs.getString("TEL_TELEFONE"));
                telefone.setCliente(rs.getInt("CLI_ID"));
                telefone.setStatus('A');
            }
            return telefone;
        } catch (Exception erro) {
            throw new Exception("Erro ao localizar Telefone: " + erro.getMessage());
        }
    }

    public List<Telefone> selecionarPorIDdoCliente(int cli_id) throws Exception {
        try {
            String sql = "SELECT * FROM telefone WHERE CLI_ID=?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, cli_id);

            ResultSet rs = ps.executeQuery();

            Telefone telefone = null;
            lista = new ArrayList<Telefone>();

            while (rs.next()) {
                telefone = new Telefone();

                telefone.setTel_id(rs.getInt("TEL_ID"));
                telefone.setTel_numero(rs.getString("TEL_TELEFONE"));
                telefone.setCliente(rs.getInt("CLI_ID"));
                telefone.setStatus('A');
                lista.add(telefone);
            }
            return lista;
        } catch (Exception erro) {
            throw new Exception("Erro ao localizar Telefone pelo ID do Cliente: " + erro.getMessage());
        }
    }
    

    public List<Telefone> getLista() {
        return lista;
    }
}
