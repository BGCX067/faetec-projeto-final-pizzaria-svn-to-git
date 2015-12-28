package pizzaria.modeloDao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.Iterator;
import pizzaria.controle.Conexao;
import pizzaria.modelo.Cliente;
import pizzaria.modelo.Telefone;

public class ClienteDAO {

    private List<Cliente> lista = null;

    /** Incluir uma Nova Pessoa ao Banco */
    public void incluir(Cliente cliente) throws Exception {
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO CLIENTE (CLI_ID, CLI_NOME, CLI_SEXO, CLI_CPF, CLI_RG, CLI_DATA_NASC, LOG_ID, CLI_NUMERO, CLI_COMPL) " +
                    "VALUES (?,?,?,?,?,?,?,?,?)";

            ps = Conexao.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.getConnection().setAutoCommit(false);
            // Auto Increment

            ps.setInt(1, cliente.getCli_id());
            ps.setString(2, cliente.getCli_nome());
            ps.setString(3, cliente.getCli_sexo());
            ps.setString(4, cliente.getCli_cpf());
            ps.setString(5, cliente.getCli_rg());
            ps.setDate(6, new java.sql.Date(cliente.getCli_data_nasc().getTime()));
            ps.setInt(7, cliente.getLogradouro().getLog_id());
            ps.setString(8, cliente.getCli_numero());
            ps.setString(9, cliente.getCli_compl());

            

            if (cliente.getCli_id() < 1) {
                ps.setNull(1, Types.INTEGER);
            } else {
                ps.setInt(1, cliente.getCli_id());
            }

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                cliente.setCli_id(rs.getInt(1));
            }

            TelefoneDAO teldao = new TelefoneDAO();

            // Cria um objeto Interativo para navegação sequencial dos telefones
            Iterator<Telefone> it = cliente.getTelefones().iterator();

            while (it.hasNext()) {
                Telefone tel = it.next();
                tel.setCliente(cliente.getCli_id()); // Associa Id da Pessoa ao Telefone

                teldao.incluir(tel);	// Inclui Telefone

            }

            ps.getConnection().commit();

        } catch (Exception erro) {
            if (ps != null) {
                ps.getConnection().rollback(); // Defaz todas as alterações
            }
            throw new Exception("Erro ao Incluir Cliente: " + erro.getMessage());


        } finally {
            ps.getConnection().setAutoCommit(true);
        }

    }

    public void alterar(Cliente cliente) throws Exception {
        PreparedStatement ps = null;
        try {
            String sql = "UPDATE CLIENTE SET CLI_NOME=?, CLI_CPF=?, CLI_RG=?, CLI_SEXO=?, CLI_DATA_NASC=?, LOG_ID=?, CLI_NUMERO=?, CLI_COMPL=? WHERE CLI_ID = ?";
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.getConnection().setAutoCommit(false);  // Para múltiplas transações, desativando confirmação automatizada
            ps.setString(1, cliente.getCli_nome());
            ps.setString(2, cliente.getCli_cpf());
            ps.setString(3, cliente.getCli_rg());
            ps.setString(4, cliente.getCli_sexo());
            ps.setDate(5, new java.sql.Date(cliente.getCli_data_nasc().getTime()));
            ps.setInt(6, cliente.getLogradouro().getLog_id());
            ps.setString(7, cliente.getCli_numero());
            ps.setString(8, cliente.getCli_compl());
            ps.setInt(9, cliente.getCli_id());

            ps.executeUpdate();

            // Gravar Telefones da Pessoa
            TelefoneDAO teldao = new TelefoneDAO();

            Iterator<Telefone> it = cliente.getTelefones().iterator();
            while (it.hasNext()) {
                Telefone tel = it.next();
                tel.setCliente(cliente.getCli_id());

                if (tel.getStatus() == 'N') {
                    teldao.incluir(tel);
                } else if (tel.getStatus() == 'A') {
                    teldao.alterar(tel);
                } else if (tel.getStatus() == 'E') {
                    teldao.excluir(tel);
                    it.remove();
                }

            }
            ps.getConnection().commit(); // Grava todas as operações realizadas

        } catch (Exception erro) {
            if (ps != null) {
                ps.getConnection().rollback(); // Defaz todas as alterações
            }
            throw new Exception("Erro ao Alterar Cliente: " + erro.getMessage());
        } finally {
            ps.getConnection().setAutoCommit(true);
        }

    }

    public void excluir(Cliente cliente) throws Exception {
        PreparedStatement ps = null;
        try {
            String sql = "DELETE FROM TELEFONE WHERE CLI_ID = ?";
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.getConnection().setAutoCommit(false);  // Para múltiplas transações, desativando confirmação automátizada

            // Excluir Telefones
            ps.setInt(1, cliente.getCli_id());
            ps.executeUpdate();

            sql = "DELETE FROM CLIENTE WHERE CLI_ID = ?";
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, cliente.getCli_id());
            ps.executeUpdate();

            ps.getConnection().commit();

        } catch (Exception erro) {
            if (ps != null) {
                ps.getConnection().rollback(); // Defaz todas as alterações
            }
            throw new Exception("Erro ao Excluir Cliente: " + erro.getMessage());
        } finally {
            ps.getConnection().setAutoCommit(true);
        }

    }

    /** Recuperar uma Pessoa do Banco de Dados através de seu ID */
    public Cliente selecionarPorID(int id) throws Exception {
        PreparedStatement ps = null;
        try {
            String sql = "SELECT * FROM CLIENTE WHERE CLI_ID = ?";
            ps = Conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            LogradouroDAO logdao = new LogradouroDAO();
            TelefoneDAO teldao = new TelefoneDAO();

            Cliente cliente = null;

            if (rs.next()) {
                cliente = new Cliente();

                cliente.setCli_id(rs.getInt("CLI_ID"));
                cliente.setCli_nome(rs.getString("CLI_NOME"));
                cliente.setCli_cpf(rs.getString("CLI_CPF"));
                cliente.setCli_rg(rs.getString("CLI_RG"));
                cliente.setCli_sexo(rs.getString("CLI_SEXO"));
                cliente.setCli_data_nasc(rs.getDate("CLI_DATA_NASC"));
                cliente.setLogradouro(logdao.selecionarPorId(rs.getInt("LOG_ID")));
                cliente.setCli_numero(rs.getString("CLI_NUMERO"));
                cliente.setCli_compl(rs.getString("CLI_COMPL"));
                cliente.setTelefones(teldao.selecionarPorIDdoCliente(rs.getInt("CLI_ID")));

            }

            return cliente;

        } catch (Exception erro) {
            throw new Exception("Erro ao Localizar Cliente por ID: " + erro.getMessage());
        }

    }

    public List<Cliente> selecionarPorNome(String nome) throws Exception {
        try {
      String sql;
      if (nome != null && !nome.isEmpty()) {
        sql = "SELECT * FROM CLIENTE WHERE CLI_NOME LIKE ? ORDER BY CLI_NOME";
      } else {
        sql = "SELECT * FROM CLIENTE ORDER BY CLI_NOME";
      }

      PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);

      if (ps.getParameterMetaData().getParameterCount() > 0) {
        ps.setString(1, nome + "%");
      }

      ResultSet rs = ps.executeQuery();

      lista = new ArrayList<Cliente>();
      LogradouroDAO logdao = new LogradouroDAO();
      TelefoneDAO teldao= new TelefoneDAO();

      Cliente cliente = null;

      while (rs.next()) {
        cliente = new Cliente();

        cliente.setCli_id(rs.getInt("CLI_ID"));
        cliente.setCli_nome(rs.getString("CLI_NOME"));
        cliente.setCli_cpf(rs.getString("CLI_CPF"));
        cliente.setCli_rg(rs.getString("CLI_RG"));
        cliente.setCli_sexo(rs.getString("CLI_SEXO"));
        cliente.setCli_data_nasc(rs.getDate("CLI_DATA_NASC"));
        cliente.setLogradouro(logdao.selecionarPorId(rs.getInt("LOG_ID")));
        cliente.setCli_numero(rs.getString("CLI_NUMERO"));
        cliente.setCli_compl(rs.getString("CLI_COMPL"));
        cliente.setTelefones(teldao.selecionarPorIDdoCliente(rs.getInt("cli_id")));
        lista.add(cliente);
      }
      return lista;

    } catch (Exception erro) {
      throw new Exception("Erro ao Localizar Cliente Pelo Nome: " + erro.getMessage());
    }


    }

    public List<Cliente> getLista() {
        return lista;
    }
}
