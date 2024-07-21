package apptarefa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbtarefa?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "@slash";

	private Connection getConexao() throws Exception {

		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

}
