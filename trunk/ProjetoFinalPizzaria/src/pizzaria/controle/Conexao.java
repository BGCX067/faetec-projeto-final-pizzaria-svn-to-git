package pizzaria.controle;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private static String driver="com.mysql.jdbc.Driver";
    private static String banco="jdbc:mysql://localhost/dbpizzaria";
    private static String usuario="root";
    private static String senha="";
    private static Connection conexao=null;


    public static Connection getConexao() throws Exception {
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(banco,usuario,senha);
        }catch(Exception e) {
            throw new Exception("Falha de Conexao com o Banco:"+e.getMessage());
        }
        return conexao;

    }

}
