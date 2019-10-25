package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import util.exception.ErroSistema;

public class ConnectionFactory {

	private static Connection conexao;
    private static final String URL_CONEXAO = "jdbc:mysql://200.130.152.86:7798/library";
    private static final String USER = "root";
    private static final String PASSWORD = "rafael";
    //200.130.152.86
    //7798

    public static Connection getConexao() throws ErroSistema {
        if (conexao == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexao = DriverManager.getConnection(URL_CONEXAO, USER, PASSWORD);
            } catch (ClassNotFoundException ex) {
                throw new ErroSistema("Driver n�o encontrado", ex);
            } catch (SQLException ex) {
                throw new ErroSistema("N�o foi possivel conectar ao banco de dados.", ex);
            }
        }
        return conexao;
    }

    public static void fechaConexao() throws ErroSistema {
        if (conexao != null) {
            try {
                conexao.close();
                conexao = null;
            } catch (SQLException ex) {
                throw new ErroSistema("Erro ao fechar conex�o com o banco de dados", ex);
            }
        }
    }
}
